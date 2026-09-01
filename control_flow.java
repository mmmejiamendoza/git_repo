public class control_flow {
    public static void main(String[] args) {
        char grade = 'B';
        int score = 75;

        if (score >= 50){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        //use else-if condtions
        if (score >= 90){
            System.out.println("Grade: A");
        } else if (score>=75 && score<=89){
            System.out.println("Grade: B");
        } else if (score>=60 && score<=74){
            System.out.println("Grade: C");
        } else if (score<=60){
            System.out.println("Grade: D");
        }

    }
}
