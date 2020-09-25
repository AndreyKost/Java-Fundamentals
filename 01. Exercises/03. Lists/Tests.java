import java.util.ArrayList;
import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.remove(3);
        numbers.remove(Integer.valueOf(50));


        for (Integer num : numbers) {
            System.out.print(num+" ");
        }



    }
}
