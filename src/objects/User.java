package objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import connect.net.sqlite.Connect;

public class User 
{
    private String username;
    private String password;
    

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
