package sql;

import java.sql.*;

public class SQL
{

    public static void main(String[] args)
    {
        Connector conn = new Connector();
        try
        {
            conn.connect();
            conn.printResultSet(conn.query("IGNORE"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
