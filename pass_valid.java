import java.util.Scanner;

public class pass_valid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass;
        boolean valid;

        do { 
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            //scanner.nextLine();
            System.out.println("Create a password based on these requirements:");
            System.out.println("Be at least 8 characters");
            System.out.println("Contain at least one uppercase letter");
            System.out.println("Contain at least one lowercase letter");
            System.out.println("Contain at least one number");
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("Enter password: ");
            pass = scanner.nextLine();

            boolean upper = false;;
            boolean lower= false;
            boolean digits = false;
            
            for(char c: pass.toCharArray()){
                if(Character.isUpperCase(c)) upper = true;
                if(Character.isLowerCase(c)) lower = true;
                if(Character.isDigit(c)) digits = true;
            }

            valid = pass.length() >= 8 && upper && lower && digits;
            if(valid){
            System.out.println("Password Accepted!");
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            } else if(pass.length() < 8){
                System.out.println("Must be at least 8 characters long");
            } else if(!upper){
                System.out.println("Need at least one uppercase");
            } else if(!lower){
                System.out.println("Need at least one lowercase");
            } else if(!digits){
                System.out.println("Need at least one number");
            }

            
        } while (!valid);
        }
    }
