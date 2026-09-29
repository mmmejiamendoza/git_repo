import java.util.Scanner;

public class word_analyze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        System.out.println("Enter a word: ");

        String input = scanner.nextLine();
        int totalchar = input.replace(" ", "").length();
        int vowelCount = 0;
        int consonantsCount = 0;
        String input2 = input.replace(" ", "").toLowerCase();
        for (char c : input2.toCharArray()){
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vowelCount++;
                }
            }

        for (char c : input2.toCharArray()){
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    consonantsCount++;
                }
            }

            int length = 0;
            for (char c : input2.toCharArray()){
                if (Character.isDigit(c)) {
                length++;
                }
            }

            int space = 0;
            for (char c : input.toCharArray()){
                if (c == ' ') {
                space++;
                }
            }
            
            System.out.println("Total Characters: " + totalchar);
            System.out.println("Vowels: " + vowelCount);
            System.out.println("Consonants: " + consonantsCount);
            System.out.println("Digits: " + length);
            System.out.println("Space: " + space);
        }



    }
