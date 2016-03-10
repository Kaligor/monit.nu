package sql;

public class access_id
{

    final int ID;
    final int UNIT_ID;
    final String USERNAME;
    final int DELAYTIMEMINUTE;
    final String PHONE;

    public access_id(int ID, int UNIT_ID, String USERNAME, int DELAYTIMEMINUTE, String PHONE)
    {
        this.ID = ID;
        this.UNIT_ID = UNIT_ID;
        this.USERNAME = USERNAME;
        this.DELAYTIMEMINUTE = DELAYTIMEMINUTE;
        this.PHONE = PHONE;
    }

    @Override
    public String toString()
    {
        return "access_id{" + "ID=" + ID + ", UNIT_ID=" + UNIT_ID + ", USERNAME=" + USERNAME + ", DELAYTIMEMINUTE=" + DELAYTIMEMINUTE + ", PHONE=" + PHONE + '}';
    }

}
