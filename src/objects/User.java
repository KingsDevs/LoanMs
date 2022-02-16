package objects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User 
{
    private String username;
    private String password;
    

    public void setFromDb(ResultSet rs) throws SQLException
    {
        while (rs.next()) 
        {
            username = rs.getString("username");
            password = rs.getString("password");
        }
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
