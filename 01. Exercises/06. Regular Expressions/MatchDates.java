import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //String regex="(\\d{2}\\/[A-Za-z]{3}\\/\\d{4})|(\\d{2}-[A-Za-z]{3}-\\d{4})|(\\d{2}\\.[A-Za-z]{3}\\.\\d{4})";
        String regex="\\b(?<Day>\\d{2})([-.\\/])(?<Month>[A-Za-z]{3})\\2(?<Year>\\d{4})\\b";
        String text=scanner.nextLine();

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",matcher.group("Day"),matcher.group("Month"),matcher.group("Year"));
        }




    }
}
