package org.usd232.hackathon.twentysixteen;

import static spark.Spark.get;
import org.usd232.hackathon.twentysixteen.authentication.IAuthenticationService;
import org.usd232.hackathon.twentysixteen.authentication.UserInfo;

public class Main
{
    // TODO Set auth to something
    static IAuthenticationService auth;

    public static void main(String[] args)
    {
        get("/hello", (req, res)->"Hello World");
        get("/authStatus", (req, res)->
        {
            boolean authed = auth.isAuthenticated(req.attribute("X-Auth-Token").toString());
            UserInfo user = auth.getInfo(req.attribute("X-Auth-Token").toString());
            String json = "{\"authed\":" + authed + ",\"fname\":\"" + user.getFirstname() + "\",\"lname\":\"" + user.getLastname() + "\"}";
            return json;
        });
        get("/accounts", (req, res)->{
            //TODO Fix req.* stuff
           String json = "[";
           int accountsNum = req.NUMBER_OF_ACCOUNTS;
           for(int i = 0; i < accountsNum; i++){
               String thisAccountJSON = "{\"type\":\"" + req.ACCOUNTS[i].TYPE + "\",\"name\":\"" + req.ACCOUNTS[i].NAME + "\",\"category\":\"" + req.ACCOUNTS[i].CATEGORY + "\",\"id\":\"" + req.ACCOUNTS[i].GUID + "\"},";
               json += thisAccountJSON;
           }
           json = json.substring(0, json.length() - 2);
           json += "]";
           return json;
        });
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
        get("/accounts/GUID/chats/GUID", (req, res)->{
            //TODO Fix req.* stuff
           String json = "{\"type\":\"" + req.ACCOUNT.GUID.CHATS.GUID.TYPE + "\",\"name\":\"" + req.ACCOUNT.CHATS.GUID.GUID.NAME + "\"";
           json += ",\"messages\":[";
           for(int i = 0; i < req.ACCOUNT.GUID.CHATS.length; i++){
               json += "{\"type:\"" + req.ACCOUNT.GUID.CHATS.GUID[i].SENDER + "\"name:\"" + req.ACCOUNT.GUID.CHATS.GUID[i].MESSAGE + "\"id:\"" + req.ACCOUNT.GUID.CHATS.GUID[i].GUID + "\"time:" + req.ACCOUNT.GUID.CHATS.GUID[i].TIME + "\",";
               json += "\"reactions\":";
               for(int j = 0; j <  req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS.length; i++){
                   json += "{\"" + req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS[j].REACTION + "\":[";
                   for(int k = 0; k < req.ACCOUNT.GUID.CHATS.GUID[i].REACTIONS[j].USERS; i++){
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
    }
}
