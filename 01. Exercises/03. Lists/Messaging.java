import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    static int calculateIndex(Integer number){
        int index=0;
        while(number>0){
            int currentNumber=number%10;
            index+=currentNumber;
            number/=10;
        }
        return index;
    }
    static char getCharFromMessage(int index , String message){
        int countindex=0;
        for (int i = 0; i <index ; i++) {
            countindex++;
            if(countindex==message.length()){
                countindex=0;
            }
        }
        char currentChar=message.charAt(countindex);
        return  currentChar;
    }
    static int calculateRealIndex(int index, String message){
        int countindex=0;
        for (int i = 0; i <index ; i++) {
            countindex++;
            if(countindex==message.length()){
                countindex=0;
            }
        }
        return  countindex;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String message=scanner.nextLine();

        for (int i = 0; i <numbers.size() ; i++) {
            int currentNumber=numbers.get(i);
            int index=calculateIndex(currentNumber);

            char currentChar=getCharFromMessage(index,message);
            System.out.printf("%c",currentChar);

            int realIndex=calculateRealIndex(index,message);
            StringBuilder newMessage=new StringBuilder(message);
            newMessage.deleteCharAt(realIndex);
            message=newMessage.toString();

        }

        System.out.println();

    }
}
