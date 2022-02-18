package connect.net.sqlite;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.User;

public class Connect 
{
 
    //private static String dbUrl = "db/dblms.db";
    private static String dbUrl = "E:\\myCraft\\Java\\LoanMS\\src\\connect\\net\\sqlite\\db\\dblms.db";
    private static Connection connection = null;
    // public void connect() throws SQLException{
    //     String dbUrl = "E:\\myCraft\\Java\\test\\test\\src\\db\\database.db";

    //     Connection conn = DriverManager.getConnection("jdbc:sqlite:/" + dbUrl);
    //     Statement statement = conn.createStatement();
    //     ResultSet rs = statement.executeQuery("SELECT * from user");

    //     while(rs.next())
    //     {
    //         System.out.println(rs.getString("username"));
    //         System.out.println(rs.getString("password"));
    //     }

    //     System.out.println("Connected Successfully");
    // }

    public static Connection getConnection()
    {
        if (connection == null) 
        {
            connection = connect();    
        }

        return connection;
    }

    private static Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/" + dbUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ResultSet select(String tableName, String columns)
    {

        String sql = "SELECT " + columns + " FROM " + tableName;
        
        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
        {
            
            return rs;
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }


        return null;
    }
    
    // public static void main(String[] args) 
    // {
    //     connect();
    //     System.out.println("Successfully");
    // }
    
    public User getUserData(Statement stmt) throws SQLException
    {
        String username;
        String password;

        // Connection conn = connect();
        // Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery("SELECT * FROM user LIMIT 1");

        username = rs.getString("username");  
        password = rs.getString("password");  

        User user = new User(username, password);

        return user;
    }

}
