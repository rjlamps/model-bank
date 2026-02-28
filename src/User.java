public class User 
{
    private String username;
    private String password;
    private int accountID;

    public User(String username, String password, int accountID)
    {
        this.username = username;
        this.password = password;
        this.accountID = accountID;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getAccountID()
    {
        return accountID;
    }

}
