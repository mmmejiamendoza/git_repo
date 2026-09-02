public class loops {
    public static void main(String[] args) {
        //for loop
        System.out.printf("For loop: ");
        for(int i=1; i<=5; i++){
            if(i>1){
                System.out.print(" ");
            }
            System.out.print(i);
            }

            System.out.println(); //to start new line

            //while loop
            int i = 1;
            System.out.print("While Loop:");
            while (i<=5){
                System.out.print(" " + i);
                i++;
            }

            System.out.println(); //to start new line

            //do-while loop
            i=1;
            System.out.print("Do-While Loop:");
            do {
                System.out.print(" " + i);
                i++;
            } while(i<=5);

        }

    }
