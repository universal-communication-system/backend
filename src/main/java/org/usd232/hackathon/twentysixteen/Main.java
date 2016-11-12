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
    }
}
