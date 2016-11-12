package org.usd232.hackathon.twentysixteen.providers.slack;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.usd232.hackathon.twentysixteen.ModuleFactory;
import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.model.Capabilities;
import org.usd232.hackathon.twentysixteen.model.Chat;
import org.usd232.hackathon.twentysixteen.model.MemberChange;
import org.usd232.hackathon.twentysixteen.model.Message;
import org.usd232.hackathon.twentysixteen.providers.IMessageProvider;
import org.usd232.hackathon.twentysixteen.providers.slack.json.ApiTestResponse;
import org.usd232.hackathon.twentysixteen.providers.slack.json.Channel;
import org.usd232.hackathon.twentysixteen.providers.slack.json.ChannelList;
import org.usd232.hackathon.twentysixteen.providers.slack.json.ChannelSuccess;
import org.usd232.hackathon.twentysixteen.providers.slack.json.TokenRequest;
import org.usd232.hackathon.twentysixteen.providers.slack.json.User;
import org.usd232.hackathon.twentysixteen.providers.slack.json.UserChannelRequest;
import org.usd232.hackathon.twentysixteen.providers.slack.json.UserList;

import com.google.gson.Gson;

public class SlackProvider implements IMessageProvider {
	private static final HttpClient HTTP_CLIENT = HttpClients.createDefault();
	private static final Gson GSON = new Gson();

	private <TRes, TReq> TRes request(String endpoint, TReq req, Class<TRes> cls) throws Exception {
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new StringEntity(GSON.toJson(req)));
		HttpResponse res = HTTP_CLIENT.execute(post);
		StringBuilder builder = new StringBuilder();
		try ( Scanner reader = new Scanner(res.getEntity().getContent()) ) {
			builder.append(reader.nextLine());
		}
		return GSON.fromJson(builder.toString(), cls);
	}

	private Map<UUID, Channel> getChannels(UserInfo user, String token) throws Exception {
		Map<UUID, Channel> map = new HashMap<UUID, Channel>();
		ChannelList channels = request(SlackEndpoints.CHANNELS_LIST, new TokenRequest(token), ChannelList.class);
		for ( Channel channel : channels.getChannels() ) {
			ResultSet res = ModuleFactory.DATABASE_CONNECTION
					.query(String.format("SELECT `guid` FROM `slack_guids` WHERE `id` = '%s'", channel.getId()));
			if ( res.next() ) {
				map.put(UUID.fromString(res.getString(0)), channel);
			} else {
				UUID guid = UUID.randomUUID();
				ModuleFactory.DATABASE_CONNECTION.statement(String
						.format("INSERT INTO `slack_guids` (`id`, `guid`) VALUES ('%s', '%s')", channel.getId(), guid));
				map.put(guid, channel);
			}
		}
		return map;
	}

	private String getChannel(UserInfo user, String token, UUID channel) throws Exception {
		return getChannels(user, token).get(channel).getId();
	}

	private Map<String, String> getUsers(UserInfo info, String token) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		UserList users = request(SlackEndpoints.CHANNELS_LIST, new TokenRequest(token), UserList.class);
		for ( User user : users.getMembers() ) {
			map.put(user.getName(), user.getId());
		}
		return map;
	}

	private String getUser(UserInfo user, String token, String name) throws Exception {
		return getUsers(user, token).get(name);
	}

	@Override
	public UUID registerAccount(UserInfo user, String token) {
		try {
			ModuleFactory.DATABASE_CONNECTION.addAccount(user, token);
			ApiTestResponse res = request(SlackEndpoints.AUTH_TEST, new TokenRequest(token), ApiTestResponse.class);
			UUID uuid = UUID.randomUUID();
			ModuleFactory.DATABASE_CONNECTION.statement(String.format(
					"INSERT INTO `slack_accounts` (`team_id`, `user_id`, `guid`) VALUES ('%s', '%s', '%s')",
					res.getTeamId(), res.getUserId(), uuid.toString()));
			return uuid;
		} catch ( Exception ex ) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Capabilities getCapabilities() {
		return new Capabilities(true, true, true, true, true, true, true, true, true, true, false);
	}

	@Override
	public void modifyMembers(UserInfo user, UUID account, UUID chat, MemberChange change) {
		try {
			String token = ModuleFactory.DATABASE_CONNECTION.getAccountData(user, account);
			String channelid = getChannel(user, token, chat);
			for ( String username : change.getAddUsers() ) {
				String userid = getUser(user, token, username);
				request(SlackEndpoints.CHANNELS_INVITE, new UserChannelRequest(channelid, userid, token),
						ChannelSuccess.class);
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}

	@Override
	public void editMessage(UserInfo user, UUID account, UUID chat, UUID message, String content) {
	}

	@Override
	public void unreact(UserInfo user, UUID account, UUID chat, UUID message, String reaction) {
	}

	@Override
	public List<Chat> getChats(UserInfo user, UUID account) {
		return null;
	}

	@Override
	public List<Message> getMessages(UserInfo user, UUID account, UUID chat) {
		return null;
	}

	@Override
	public Chat getChat(UserInfo user, UUID account, UUID chat) {
		return null;
	}

	@Override
	public Message getMessage(UserInfo user, UUID account, UUID chat, UUID message) {
		return null;
	}

	@Override
	public void postMessage(UserInfo user, UUID account, UUID chat, String content) {
	}

	@Override
	public void react(UserInfo user, UUID account, UUID chat, UUID message, String reaction) {
	}

	@Override
	public void createChat(UserInfo user, UUID account, String name, String type, List<String> users) {
	}

	@Override
	public void deleteChat(UserInfo user, UUID account, UUID chat) {
	}

	@Override
	public void deleteMessage(UserInfo user, UUID account, UUID chat, UUID message) {
	}

	public SlackProvider() {
		// @formatter:off
		ModuleFactory.DATABASE_CONNECTION.statement("CREATE TABLE IF NOT EXISTS `slack_accounts` (" +
				"	`team_id` VARCHAR(256)," +
				"	`user_id` VARCHAR(256)," +
				"	`guid` VARCHAR(64)," +
				"	PRIMARY KEY (`guid`)" +
				")");
		ModuleFactory.DATABASE_CONNECTION.statement("CREATE TABLE IF NOT EXISTS `slack_guids` (" +
				"	`id` VARCHAR(256)," +
				" 	`guid` VARCHAR(256)," +
				"	PRIMARY KEY(`id`)" +
				")");
		// @formatter:on
	}
}
