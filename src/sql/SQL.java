package sql;

public class SQL
{

    public static void main(String[] args)
    {
        Connector conn = new Connector();
        conn.connect();
        conn.printResultSet(conn.query("IGNORE"));

    }

}
