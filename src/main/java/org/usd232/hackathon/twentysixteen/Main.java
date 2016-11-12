package org.usd232.hackathon.twentysixteen;

import static spark.Spark.*;
import java.util.List;
import java.util.UUID;
import org.usd232.hackathon.twentysixteen.authentication.IAuthenticationService;
import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.database.IDatabaseConnection;
import org.usd232.hackathon.twentysixteen.model.Account;
import org.usd232.hackathon.twentysixteen.model.AuthStatus;
import org.usd232.hackathon.twentysixteen.model.Capabilities;
import org.usd232.hackathon.twentysixteen.model.Chat;
import org.usd232.hackathon.twentysixteen.model.MemberChange;
import org.usd232.hackathon.twentysixteen.model.NewChat;
import org.usd232.hackathon.twentysixteen.providers.IMessageProvider;
import com.google.gson.Gson;

public class Main
{
    private static final Gson     GSON = new Gson();
    // TODO Set auth to something
    static IAuthenticationService auth;
    static IDatabaseConnection    db;
    static IMessageProvider       message;

    public static void main(String[] args)
    {
        get("/hello", (req, res)->"Hello World");
        /*-
        get("/authStatus", (req, res)->
        {
            boolean authed = auth.isAuthenticated(req.attribute("X-Auth-Token").toString());
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String json = "{\"authed\":" + authed + ",\"fname\":\"" + user.getFirstname() + "\",\"lname\":\"" + user.getLastname() + "\"}";
            return json;
        });
        // */
        /*-
        get("/accounts", (req, res)->
        {
            // TODO Fix req.* stuff
            String json = "[";
            int accountsNum = req.NUMBER_OF_ACCOUNTS;
            for (int i = 0; i < accountsNum; i++)
            {
                String thisAccountJSON = "{\"type\":\"" + req.ACCOUNTS[i].TYPE + "\",\"name\":\"" + req.ACCOUNTS[i].NAME
                                + "\",\"category\":\"" + req.ACCOUNTS[i].CATEGORY + "\",\"id\":\""
                                + req.ACCOUNTS[i].GUID + "\"},";
                json += thisAccountJSON;
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            return json;
        });
        // */
        /*-
        get("/accounts/GUID", (req, res)->{
            //TODO Fix req.* stuff
           String json = "{\"type\":\"" + req.ACCOUNT.GUID.TYPE + "\",\"name\":\"" + req.ACCOUNT.GUID.NAME + "\",\"category\":\"" + req.ACCOUNT.GUID.CATEGORY + "\"";
           json += ",\"chats\":[";
           for(int i = 0; i < req.ACCOUNT.GUID.CHATS.length; i++){
               json += "{\"type:\"" + req.ACCOUNT.GUIDE.CHATS[i].TYPE + "\"name:\"" + req.ACCOUNT.GUIDE.CHATS[i].NAME + "\"id:\"" + req.ACCOUNT.GUIDE.CHATS[i].GUID + "\"},";
           }
           json = json.substring(0, json.length() - 2);
           json += "]}";
           return json;
        });
        // */
        /*-
        get("/accounts/GUID/chats/GUID", (req, res)->
        {
            // TODO Fix req.* stuff
            String json = "{\"type\":\"" + req.ACCOUNT.GUID.CHATS.GUID.TYPE + "\",\"name\":\""
                            + req.ACCOUNT.CHATS.GUID.GUID.NAME + "\"";
            json += ",\"messages\":[";
            for (int i = 0; i < req.ACCOUNT.GUID.CHATS.length; i++)
            {
                json += "{\"type:\"" + req.ACCOUNT.GUID.CHATS.GUID[i].SENDER + "\"name:\""
                                + req.ACCOUNT.GUID.CHATS.GUID[i].MESSAGE + "\"id:\""
                                + req.ACCOUNT.GUID.CHATS.GUID[i].GUID + "\"time:" + req.ACCOUNT.GUID.CHATS.GUID[i].TIME
                                + "\",";
                json += "\"reactions\":";
                for (int j = 0; j < req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS.length; i++)
                {
                    json += "{\"" + req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS[j].REACTION + "\":[";
                    for (int k = 0; k < req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS[j].USERS; i++)
                    {
                        json += "\"" + req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS[j].USERS[k] + "\",";
                    }
                    json = json.substring(0, json.length() - 2);
                    json += "]";
                }
            }
            json = json.substring(0, json.length() - 2);
            json += "]}";
            return json;
        });
        // */
        get("/authStatus", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            AuthStatus authed = new AuthStatus(auth.isAuthenticated(req.attribute("X-Auth-Token").toString()),
                            user.getName());
            String json = GSON.toJson(authed);
            return json;
        });
        get("/accounts/GUID", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            Account account = ModuleFactory.DATABASE_CONNECTION.getAccount(user,
                            UUID.fromString(req.url().split("/")[1]));
            account.setChats(message.getChats(user, UUID.fromString(req.url().split("/")[1])));
            String json = GSON.toJson(account);
            return json;
        });
        get("/accounts", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            List<Account> accounts = db.getAccounts(user);
            String json = GSON.toJson(accounts);
            return json;
        });
        get("/accounts/GUID/chats/GUID", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            Account account = ModuleFactory.DATABASE_CONNECTION.getAccount(user, UUID.fromString(urlSections[1]));
            account.setChats(message.getChats(user, UUID.fromString(urlSections[1])));
            Chat chat = message.getChat(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]));
            String json = GSON.toJson(chat);
            return json;
        });
        post("/accounts/GUID/chats/GUID", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            boolean succeeded = true;
            try
            {
                message.postMessage(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]), req.body());
            }
            catch (Exception e)
            {
                succeeded = false;
            }
            return succeeded;
        });
        post("/accounts/GUID/chats/GUID/messages/GUID/react", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            boolean success = true;
            try
            {
                message.react(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]),
                                UUID.fromString(urlSections[5]), req.body());
            }
            catch (Exception e)
            {
                success = false;
            }
            return success;
        });
        put("/accounts/GUID/chats", (req, res)->
        {
            boolean success = true;
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            NewChat newChat = GSON.fromJson(req.body(), NewChat.class);
            try
            {
                message.createChat(user, UUID.fromString(urlSections[1]), newChat.getName(), newChat.getType(), newChat.getUsers());
            }
            catch (Exception e)
            {
                success = false;
            }
            return success;
        });
        delete("/accounts/GUID/chats/GUID", (req, res)->{
            boolean success = true;
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            try{
                message.deleteChat(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]));
            }
            catch(Exception e){
                success = false;
            }
            return success;
        });
        delete("/accounts/GUID/chats/GUID/messages/GUID", (req, res)->{
            boolean success = true;
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            try{
                message.deleteMessage(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]), UUID.fromString(urlSections[5]));
            }
            catch(Exception e){
                success = false;
            }
            return success;
        });
        delete("/accounts/GUID/chats/GUID/messages/GUID/react", (req, res)->{
            boolean success = true;
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            try{
                message.unreact(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]), UUID.fromString(urlSections[5]), req.body());
            }
            catch(Exception e){
                success = false;
            }
            return success;
        });
        put("/accounts/GUID/chats/GUID/messages/GUID", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            boolean succeeded = true;
            try
            {
                message.editMessage(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]), UUID.fromString(urlSections[3]), req.body());
            }
            catch (Exception e)
            {
                succeeded = false;
            }
            return succeeded;
        });
        post("/accounts/GUID/chats/GUID", (req, res)->
        {
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String[] urlSections = req.url().split("/");
            MemberChange members = GSON.fromJson(req.body(), MemberChange.class);
            boolean succeeded = true;
            try
            {
                message.modifyMembers(user, UUID.fromString(urlSections[1]), UUID.fromString(urlSections[3]), members);
            }
            catch (Exception e)
            {
                succeeded = false;
            }
            return succeeded;
        });
        get("provider/name", (req, res)->{
            Capabilities caps = GSON.fromJson(req.body(), Capabilities.class);
            return caps;
        });
    }
}
