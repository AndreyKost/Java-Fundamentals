import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {

    static String joinElementsByDelimiter(List<Double> items, String delimiter){
        String output="";
        for (Double item : items){
            output+=(new DecimalFormat("0.#").format(item) + delimiter);
        }
        return output;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String[] lines=line.split(" ");
        List<Double> numbers=new ArrayList<>();

        for (String str: lines) {
            double num=Double.parseDouble(str);
            numbers.add(num);

        }

        int index=0;


        while(index<numbers.size()-1){
            double current=numbers.get(index);
            double next=numbers.get(index+1);
            double sum=0;

            if(current==next){
                sum=current+next;
                numbers.set(index,sum);
                numbers.remove(index + 1);
                index=0;
            } else {
                index++;
            }

        }

        String output=joinElementsByDelimiter(numbers, " ");
        System.out.println(output);





    }
}
