public class operators {
    public static void main(String[] args){
    int a = 20;
    int b = 10;

    //add, subtract, multiply & divide a and b
    System.out.println("Addition: " + (a + b)); //addition
    System.out.println("Subtraction: " + (a - b));//subtraction
    System.out.println("Mulitplcation: " + (a * b)); //multiply
    System.out.println("Division: " + (a / b)); //divide

    //compare a & b and store result to boolean
    boolean greaterThan = a > b;
    System.out.println("Is a greater than b? " + greaterThan);

    //check if a>b & b<0 using logiccal operator & store result
    boolean compare = a > b;
    boolean compare2 = b > 0;
    boolean answer = (compare) && (compare2);

    System.out.println("Is a > b AND b < 0? " + answer);
    }
}
