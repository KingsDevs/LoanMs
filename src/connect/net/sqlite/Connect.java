package connect.net.sqlite;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect 
{
    private String dbUrl = "db\\dblms.db";
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

    private Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ResultSet select(String tableName, String[] columns)
    {

        String sql = "SELECT ";
        for (String column : columns) 
        {
            sql += (column + ", ");
        }
        sql += " FROM " + tableName;

        try (Connection conn = this.connect();
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
    
    

}