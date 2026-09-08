import java.time.LocalDate;
import java.time.Period; //to get date, year and month
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class datetime_api {
    public static void main(String[] args){
        LocalDate now = LocalDate.now();
        Scanner scanner = new Scanner(System.in);

        System.out.println("DATE: " + now);
        System.out.println("YEAR: " + now.getYear());
        System.out.println("MONTH: " + now.getMonth());
        System.out.println("DAY: " + now.getDayOfMonth());
        System.out.println();

        System.out.println("Enetr your birth date in (YYYY-MM--DD): ");
        LocalDate bday = LocalDate.parse(scanner.nextLine());

        Period age = Period.between(bday, now);

        System.out.println("You are " + age.getYears() + " years old.");
        System.out.println();

        LocalDate nextbday = bday.withYear(now.getYear());
        if(nextbday.isBefore(now) || nextbday.isEqual(now)){
            nextbday = nextbday.plusYears(1);
        }

        long daysTil = ChronoUnit.DAYS.between(now, nextbday);
        System.out.println("Days until your next birthday: " + daysTil);

        scanner.close();
        }
    }
