package sql;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class Connector
{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://db.monit.nu/monit_db";

    static final String USER = "monitdb";
    static final String PASSWORD = "Pil2ner?";

    Connection conn = null;
    Statement stmt = null; //Bör göra Prepared Statements i Java

    /**
     * Attempts to connect to the Database listed in the DB_URL String using USER and PASSWORD
     */
    public void connect()
    {
        try
        {
            Class.forName(JDBC_DRIVER).newInstance();

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Send in an EXACT query and it will be attempted towards the server !!!!
     * HARD CODED !!!!
     *
     * @param query
     * @return
     */
    public TreeMap<Integer, access_id> query(String query)
    {
        TreeMap<Integer, access_id> results = new TreeMap();
        try
        {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM `access_id`"; // !!!!HARD CODED!!!!
            try (ResultSet rs = stmt.executeQuery(sql))
            {
                access_id temp;
                while (rs.next())
                {
                    temp = new access_id(
                            rs.getInt("id"),
                            rs.getInt("unit_id"),
                            rs.getString("username"),
                            rs.getInt("delaytimeminute"),
                            rs.getString("phone")
                    );
                    results.put(temp.ID, temp);
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Prints TreeMap content
     * @param result 
     */
    public void printResultSet(TreeMap<Integer, access_id> result)
    {
        for (Map.Entry<Integer, access_id> entry : result.entrySet())
        {
            Integer key = entry.getKey();
            access_id value = entry.getValue();
            
            System.out.println("Key: " + key + " Value: " + value);
            
        }
    }

}
