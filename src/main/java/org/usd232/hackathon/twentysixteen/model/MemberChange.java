package org.usd232.hackathon.twentysixteen.model;

import java.util.List;

public class MemberChange
{
    private List<String> addUsers;
    private List<String> removeUsers;

    public MemberChange()
    {
    }

    public MemberChange(List<String> addUsers, List<String> removeUsers)
    {
        super();
        this.addUsers = addUsers;
        this.removeUsers = removeUsers;
    }

    public List<String> getAddUsers()
    {
        return addUsers;
    }

    public void setAddUsers(List<String> addUsers)
    {
        this.addUsers = addUsers;
    }

    public List<String> getRemoveUsers()
    {
        return removeUsers;
    }

    public void setRemoveUsers(List<String> removeUsers)
    {
        this.removeUsers = removeUsers;
    }
}
