public class calc {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";

        while (again.equals("y")) {

            if (operator == '+') {
                double result = num1 + num2;
                System.out.println("Result: " + result);
            } else if (operator == '-') {
                double result = num1 - num2;
                System.out.println("Result: " + result);
            } else if (operator == '*') {
                double result = num1 * num2;
                System.out.println("Result: " + result);
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    double result = num1 / num2;
                    System.out.println("Result: " + result);
                }
            }

            again = "n";
        }

        System.out.println("Thank you for using the calculator.");
    }
}