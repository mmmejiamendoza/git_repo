public class calc5 {
    public static void main(String[] args) {
        int [] scores = {100,90,60,75,20};
        int sum = 0;
        int min = scores[0];
        int max = scores[0];

        System.out.print("If the 5 test scores entered are: ");
        for(int num : scores){
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("Then:");

        System.out.println();
        
        for(int num : scores){
            sum += num;
        }
        System.out.println("Total: " + sum);

        int avg = sum / scores.length;
        System.out.println("Average: " + avg);

        for(int num : scores){
            if(num < min) min = num;
            if(num > max) max = num;
        }
        System.out.println("Highest:" + max);
        System.out.println("Lowest: " + min);

        System.out.println();

        for(int num : scores){
            if(num >= 90){
                System.out.println(num + " - A");
            } else if(num >= 75){
                System.err.println(num + " - C");
            } else if(num >= 60){
                System.err.println(num + " - D");
            } else if(num >= 20){
                System.err.println(num + " - F ");
            }
        }
        
    }
}
