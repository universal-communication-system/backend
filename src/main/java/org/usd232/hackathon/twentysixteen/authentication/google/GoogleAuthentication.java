package org.usd232.hackathon.twentysixteen.authentication.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.usd232.hackathon.twentysixteen.ModuleFactory;
import org.usd232.hackathon.twentysixteen.authentication.IAuthenticationService;
import org.usd232.hackathon.twentysixteen.authentication.UserInfo;

import com.google.gson.Gson;

public class GoogleAuthentication implements IAuthenticationService {
	private static final String LOGIN_URL = "https://accounts.google.com/o/oauth2/v2/auth?response_type=code&client_id=805368686165-iv67r499l7n4dunkr97nb8pcqbairhqe.apps.googleusercontent.com&redirect_uri=%s&scope=https://www.googleapis.com/auth/plus.me&state=%s";
	private static final String TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token";
	private static final String ACCESS_URL = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=";
	private static final String CLIENT_ID = "805368686165-iv67r499l7n4dunkr97nb8pcqbairhqe.apps.googleusercontent.com";
	private static final Map<String, UserInfo> USER_CACHE = new HashMap<String, UserInfo>();
	private static final HttpClient HTTP_CLIENT = HttpClients.createDefault();
	private static final Gson GSON = new Gson();

	private String generateToken() {
		char[] chars = new char[64];
		Random rand = new Random();
		for ( int i = 0; i < chars.length; ++i ) {
			int num = rand.nextInt(64);
			if ( num < 10 ) {
				chars[i] = (char) ('0' + num);
			} else if ( num < 36 ) {
				chars[i] = (char) ('a' + num - 10);
			} else {
				chars[i] = (char) ('A' + num - 36);
			}
		}
		return new String(chars);
	}

	@Override
	public boolean isAuthenticated(String token) {
		return USER_CACHE.containsKey(token);
	}

	@Override
	public UserInfo getInfo(String token) {
		return USER_CACHE.get(token);
	}

	@Override
	public void logoutUser(String token) {
		USER_CACHE.remove(token);
	}

	@Override
	public String loginUser(String uri) {
		try {
			Map<String, String> queries = new HashMap<String, String>();
			for ( String var : uri.substring(uri.indexOf('?')).split("&") ) {
				String[] parts = var.split(" ");
				queries.put(parts[0], parts[1]);
			}
			TokenResponse tokenRes;
			{
				HttpPost req = new HttpPost(TOKEN_URL);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("code", queries.get("code")));
				params.add(new BasicNameValuePair("client_id", CLIENT_ID));
				params.add(new BasicNameValuePair("client_secret", System.getenv("CLIENT_SECRET")));
				params.add(new BasicNameValuePair("redirect_uri", queries.get("state")));
				params.add(new BasicNameValuePair("grant_type", "authorization_code"));
				req.setEntity(new UrlEncodedFormEntity(params));
				HttpResponse res = HTTP_CLIENT.execute(req);
				HttpEntity resEntity = res.getEntity();
				StringBuilder builder = new StringBuilder();
				try ( Scanner reader = new Scanner(resEntity.getContent()) ) {
					builder.append(reader.nextLine());
				}
				tokenRes = GSON.fromJson(builder.toString(), TokenResponse.class);
			}
			{
				HttpGet req = new HttpGet(ACCESS_URL.concat(tokenRes.getAccessToken()));
				HttpResponse res = HTTP_CLIENT.execute(req);
				HttpEntity resEntity = res.getEntity();
				StringBuilder builder = new StringBuilder();
				try ( Scanner reader = new Scanner(resEntity.getContent()) ) {
					builder.append(reader.nextLine());
				}
				AccessResponse access = GSON.fromJson(builder.toString(), AccessResponse.class);
				UserInfo info = new UserInfo(access.id, access.name);
				ModuleFactory.DATABASE_CONNECTION.afterLogin(info);
				String token = generateToken();
				USER_CACHE.put(token, info);
				return token;
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLoginUri(String domain) {
		return String.format(LOGIN_URL, domain, domain);
	}
}
