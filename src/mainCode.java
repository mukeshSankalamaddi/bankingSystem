import java.util.*;
public class mainCode {
    public static void main(String[] args) {

        bank bank = new bank();

        System.out.println("Welcome to My Bank");

        int optionNumber;

        do{
            System.out.println("-------------------------------");
            System.out.println("Choose the option");
            System.out.println("1. Create an account");
            System.out.println("2. Send Money");
            System.out.println("3. View Balance");
            System.out.println("4. Withdraw money");
            System.out.println("5. Deposit money");
            System.out.println("6. Exit");

            Scanner sc = new Scanner(System.in);
            int id;
            String password;

            optionNumber = sc.nextInt();
            switch (optionNumber) {
                //create an account.
                case 1:
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    bank.addUser(id, password);
                    break;
                //sending money
                case 2:
                    System.out.print("Enter your id: ");
                    int senderId = sc.nextInt();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    boolean loggedIn = bank.verifyCredentials(senderId, password);
                    if(loggedIn){
                        System.out.print("Enter receiver id: ");
                        int receiverId = sc.nextInt();
                        boolean verify= bank.verifyId(receiverId);
                        if(verify==true) {
                            System.out.print("Enter amount to transfer: ");
                            double amountToTransfer = sc.nextDouble();
                            bank.sendMoney(senderId, receiverId, amountToTransfer);
                        }
                        else {
                            System.out.println("Enter a valid receiver's Id");
                            System.out.println("");
                        }
                    }
                    else{
                        System.out.println("Enter a valid user id or password");
                        System.out.println("");
                    }
                    break;
                //view balance
                case 3:
                    System.out.print("Enter your id: ");
                    int user = sc.nextInt();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(user, password);
                    if(loggedIn){
                        double balance=bank.viewBalance(user);
                        System.out.println("your current balance is : $" + balance);
                        System.out.println("");
                    }
                    else {
                        System.out.println("Enter a valid user Id or password");
                        System.out.println("");
                    }
                    break;
                //with draw money
                case 4:
                    System.out.print("Enter your id: ");
                    int withDrawer = sc.nextInt();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(withDrawer, password);
                    if(loggedIn) {
                        System.out.println("Enter money to be withdrawn:");
                        bank.withdrawMoney(withDrawer);
                    }
                    else {
                        System.out.println("Enter a valid user Id or password");
                        System.out.println("");
                    }

                    break;
                //deposit money
                case 5:
                    System.out.println("Enter id to which you want to deposit the money :");
                    int depositId=sc.nextInt();
                    if(bank.verifyId(depositId)==true){
                        System.out.println("Enter money to be deposited:");
                        double deposit=sc.nextInt();
                        bank.depositMoney(depositId,deposit);
                    }
                    else{
                        System.out.println("Enter a valid Id");
                        System.out.println("");
                    }
                    break;
                //Exit
                case 6:
                    System.out.println("Thank you for using our bank service  ");
                    System.out.println("Have a nice day :)");
                    break;
                default:
                    System.out.println("Enter a Valid key");
                    System.out.println("");
                    break;
            }
        }
        while(optionNumber!=6);

    }
}