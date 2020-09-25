import java.time.LocalDate;
import java.time.LocalDateTime;

public class Date {
    public static void main(String[] args) {
        LocalDate date=LocalDate.of(1992,2,1);
        System.out.println(date);
        LocalDateTime today=LocalDateTime.now();
        System.out.println(today);
    }
}
