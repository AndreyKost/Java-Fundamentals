import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingListValuesFromASingleLine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers=new ArrayList<>();

        String input=scanner.nextLine();
        String[] strings=input.split(" ");

        for(String string : strings){
            int number=Integer.parseInt(string);
            numbers.add(number);

        }

        for(Integer num : numbers){
            System.out.print(num+" ");
        }



    }


}
