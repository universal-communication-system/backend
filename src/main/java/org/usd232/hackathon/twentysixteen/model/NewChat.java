package org.usd232.hackathon.twentysixteen.model;

import java.util.List;
import org.eclipse.jetty.server.Authentication.User;

public class NewChat
{
    private String name;
    private String type;
    private List<String> users;

    public NewChat()
    {
    }

    public NewChat(String name, String type, List<String> users)
    {
        this.name = name;
        this.type = type;
        this.users = users;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public List<String> getUsers()
    {
        return users;
    }

    public void setUsers(List<String> users)
    {
        this.users = users;
    }
}
