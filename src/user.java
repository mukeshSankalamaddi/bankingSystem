public class user {

    private int id;
    private String password;
    private double balance;

    user(int id, String password){
        this.id = id;
        this.password = password;
        this.balance = 500;
    }

    public int getId(){
        return this.id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

}
