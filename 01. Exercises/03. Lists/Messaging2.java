import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String message=scanner.nextLine();

        for (int i = 0; i <numbers.size() ; i++) {
            int index=0;
            int n=numbers.get(i);
            while (n>0){
                 int currentNumber=n%10;
                index+=currentNumber;
                n=n/10;
            }
            int currentindex=0;
            for (int j = 0; j <index ; j++) {
                currentindex++;
                if(currentindex==message.length()){
                    currentindex=0;
                }
            }
            System.out.printf("%c",message.charAt(currentindex));

            StringBuilder newMessage=new StringBuilder(message);
            newMessage.deleteCharAt(currentindex);
            message=newMessage.toString();


        }



    }
}
