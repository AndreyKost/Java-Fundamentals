import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] lines=scanner.nextLine().split(" ");
        List<Integer> numbers=new ArrayList<>();
        for(String str : lines){
            int num=Integer.parseInt(str);
            numbers.add(num);
        }

        List<Integer> modified=new ArrayList<>();

        for(int i=0;i<numbers.size()/2;i++){
           int sum= numbers.get(i)+ numbers.get(numbers.size()-1-i);
           modified.add(sum);
        }

        if(numbers.size()%2!=0){
            modified.add(numbers.get(numbers.size()/2));
        }

        numbers=modified;

        for(int number : numbers){
            System.out.print(number+ " ");
        }

    }
}
