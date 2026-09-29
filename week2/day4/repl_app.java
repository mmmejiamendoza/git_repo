import java.util.Scanner;
import java.util.Random;

public class repl_app {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        boolean run = true;

        while(run){
            System.out.println("Welcome to my REPL App!");
            System.out.println("> help");
            System.out.println("> add");
            System.out.println("> subtract");
            System.out.println("> multiply");
            System.out.println("> divide");
            System.out.println("> reverse");
            System.out.println("> random");
            System.out.println("> quit");
            System.out.println(" - - - - - - - - - - - - - - - - - -");

            String choice = scanner.nextLine().trim();

            switch(choice){
                case "help":
                    System.out.println("You have the avalible choices to chose from");
                    System.out.println("- - - - - - - - - - - - - - - - - -");
                    break;

                case "add":
                    System.out.printf("First number: ");
                    int add1 = scanner.nextInt();
                    scanner.nextLine(); // to ensure the menu doesnt repeat twice
                    System.out.printf("Second number: ");
                    int add2 = scanner.nextInt();
                    scanner.nextLine();
                    sum = add1 + add2;
                    System.out.println("Result: " + sum);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "subtract":
                    System.out.printf("First number: ");
                    int sub1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Second number: ");
                    int sub2 = scanner.nextInt();
                    scanner.nextLine();
                    sum = sub1 - sub2;
                    System.out.println("Result: " + sum);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "multiply":
                    System.out.printf("First number: ");
                    int multi1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Second number: ");
                    int multi2 = scanner.nextInt();
                    scanner.nextLine();
                    sum = multi1 * multi2;
                    System.out.println("Result: " + sum);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "divide":
                    System.out.printf("First number: ");
                    int div1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Second number: ");
                    int div2 = scanner.nextInt();
                    scanner.nextLine();
                    sum = div1 / div2;
                    System.out.println("Result: " + sum);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "reverse":
                    System.out.printf("Enter text: ");
                    String txt = scanner.nextLine();
                    //scanner.nextLine();
                    String reverse = new StringBuilder(txt).reverse().toString();
                    System.out.println("Result: " + reverse);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "random":
                    Random random = new Random();
                    System.out.printf("Minimum: ");
                    int min = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Maximum: ");
                    int max = scanner.nextInt();
                    scanner.nextLine();
                    int randNum = random.nextInt((max-min) + 1) + min;
                    System.out.println("Random Number: " + randNum);
                    System.out.println(" - - - - - - - - - - - - - - - - - -");
                    break;

                case "quit":
                    System.out.printf("Goodbye!");
                    run = false;
                    break;
            }
        }
    }
}
