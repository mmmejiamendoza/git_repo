import java.util.Scanner;

public class repl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0; //ensure it starts at 0 lol
        boolean running = true;

        while(running){
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("--------------------------");

            String option = scanner.nextLine().trim();
            
            switch(option){
                case "1":
                    System.out.println("--------------------------");
                    System.out.println("Remaining Balance: " + balance); 
                    System.out.println("--------------------------");
                    break;
                case "2":
                    System.out.println("--------------------------");
                    System.out.println("How much would you like to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (deposit <= 0){
                        System.err.println("Can not be in the negatives");
                    } else{
                        balance += deposit;
                        System.out.println("Success! New balance: " + balance);
                    }
                    System.out.println("--------------------------");
                    break;
                case "3":
                    System.out.println("--------------------------");
                    System.out.println("How much would you like to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw <= 0){
                        System.out.println("Cant withdraw nothing");
                    } else {
                        balance -= withdraw;
                        System.err.println("Success! New balance: " + balance);
                    }
                    System.out.println("--------------------------");
                    break;
                case "4":
                    System.out.println("--------------------------");
                    System.out.println("Exiting...");
                    System.out.println("--------------------------");
                    running = false;
                    break;

            }
        }


    }
}
