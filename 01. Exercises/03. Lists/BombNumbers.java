import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());



        int specialNumber=scanner.nextInt();
        int power=scanner.nextInt();

        while(numbers.contains(specialNumber)){
            for(int i=1;i<=power;i++){
                int index=numbers.indexOf(specialNumber);
                if(index-1>=0) {
                    numbers.remove(index - 1);
                }
                 index=numbers.indexOf(specialNumber);
                if(index+1<numbers.size()) {
                    numbers.remove(index + 1);
                }
            }
           int index=numbers.indexOf(specialNumber);
            numbers.remove(index);
        }



        int sum=0;

        for(Integer n : numbers){
            sum+=n;
        }
        System.out.println(sum);

    }
}
