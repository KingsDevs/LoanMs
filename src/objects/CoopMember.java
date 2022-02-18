package objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connect.net.sqlite.Connect;
import javafx.collections.ObservableList;

public class CoopMember 
{
    private String firstname;    
    private String middlename;    
    private String lastname;    
    private String position;    
    private String address;

  

    
    public CoopMember(String firstname, String middlename, String lastname, String position, String address)
    {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.address = address;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getMiddlename()
    {
        return middlename;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getPosition()
    {
        return position;
    }

    public String getAddress()
    {
        return address;
    }

    public static ResultSet getMembers() throws SQLException
    {
        ResultSet resultSet = Connect.getStatement().executeQuery("SELECT * FROM coop_members ORDER BY lastname");
        return resultSet;
    }
}
