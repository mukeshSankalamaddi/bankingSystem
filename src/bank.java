import java.util.*;

public class bank {
    Scanner sc = new Scanner(System.in);
    private HashMap<Integer, user> users;

    bank(){
        users = new HashMap<>();
    }

    public void addUser(int id, String password){
        user newUser = new user(id,password);
        if(users.containsKey(id)){
            System.out.println("User already exists");
            System.out.println("");
        }
        else{
            users.put(id, newUser);
            System.out.println("Successfully created your Account :)");
            System.out.println("");
        }
    }

    public void sendMoney(int senderId, int receiverId, double amount){
        user sender = users.get(senderId);
        if(sender.getBalance() >= amount){
            System.out.println("Transferring the money :)");
            user receiver = users.get(receiverId);

            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            System.out.println("Transferred money Successfully to "+receiverId);
            System.out.println("Your new balance is : $" + sender.getBalance());
            System.out.println("");
        }
        else{
            System.out.println("Bank balance low. Can't send money :(");
            System.out.println("");
        }
    }
    public void withdrawMoney(int user){
        user getter = users.get(user);
        double balance = viewBalance(user);
        int withdraw = sc.nextInt();
        if (balance >= withdraw) {
            getter.setBalance(getter.getBalance() - withdraw);
            System.out.println("Please collect your money");
            System.out.println("");
        } else {
            System.out.println("Insufficient Balance");
            System.out.println("");
        }
    }
    public void depositMoney(int id,double money){
        user depositor= users.get(id);
        depositor.setBalance(depositor.getBalance()+money);
        System.out.println("Successfully deposited $"+money+" into "+id+"'s account");
        System.out.println("");
    }
    public double viewBalance(int senderId){
        user viewer=users.get(senderId);
        return viewer.getBalance();
    }
    public boolean verifyId(int id){
        user present =users.getOrDefault(id,null);
        if(present==null){
            return false;
        }
        return true;
    }
    public boolean verifyCredentials(int id, String password){
        user newUser = users.getOrDefault(id,null);
        if(newUser==null){
            return false;
        }
        return newUser.verifyPassword(password);
    }
}
