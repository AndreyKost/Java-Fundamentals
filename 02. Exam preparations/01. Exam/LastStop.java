import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line=scanner.nextLine();

        while(!line.equals("END")){
            String[] commands=line.split(" ");
            String command=commands[0];

            if(command.equals("Change")){
                int number1=Integer.parseInt(commands[1]);
                int number2=Integer.parseInt(commands[2]);
                if(numbers.contains(number1)){
                    int index=numbers.indexOf(number1);
                    numbers.set(index,number2);
                }
            } else if(command.equals("Hide")){
                int number1=Integer.parseInt(commands[1]);
                if(numbers.contains(number1)){
                    numbers.remove(Integer.valueOf(number1));
                }
            } else if(command.equals("Switch")){
                int number1=Integer.parseInt(commands[1]);
                int number2=Integer.parseInt(commands[2]);
                if(numbers.contains(number1) && numbers.contains(number2)){
                    int index1=numbers.indexOf(number1);
                    int index2=numbers.indexOf(number2);
                    numbers.set(index1,number2);
                    numbers.set(index2,number1);
                }
            } else if(command.equals("Insert")){
                int index=Integer.parseInt(commands[1]);
                int number=Integer.parseInt(commands[2]);
                if(index>=0 && index<numbers.size()){
                    numbers.add(index+1,number);
                }
            } else if(command.equals("Reverse")){
                //Collections.sort(numbers);
                Collections.reverse(numbers);
            }


            line=scanner.nextLine();
        }

        for(Integer num : numbers){
            System.out.printf("%d ",num);
        }


    }
}
