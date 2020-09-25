import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] str=input.split(" ");
        List<Integer> numbers=new ArrayList<>();
        for(String st : str){
            int num=Integer.parseInt(st);
            numbers.add(num);
        }

        String command=scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] sentence=command.split(" ");

            if (sentence[0].equalsIgnoreCase("Add")) {
                int num=Integer.parseInt(sentence[1]);
                numbers.add(num);
            } else if (sentence[0].equalsIgnoreCase("Remove")) {
                int num=Integer.parseInt(sentence[1]);
                numbers.remove((Object)num);
            } else if (sentence[0].equalsIgnoreCase("RemoveAt")) {
                int num=Integer.parseInt(sentence[1]);
                numbers.remove(num);
            } else if (sentence[0].equalsIgnoreCase("Insert")) {
                int num1 = Integer.parseInt(sentence[1]);;
                int num = Integer.parseInt(sentence[2]);;
                numbers.add(num,num1 );
            }

            command = scanner.nextLine();
        }

        for(Integer n : numbers){
            System.out.print(n + " ");
        }


    }

}
