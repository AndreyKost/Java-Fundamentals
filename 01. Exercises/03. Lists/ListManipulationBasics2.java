import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        while (true){
            String line=scanner.nextLine();
            if(line.equals("end")){
                break;
            }

            String[] tokens=line.split(" ");
            switch (tokens[0]){
                case "Add" :
                    int num=Integer.parseInt(tokens[1]);
                    numbers.add(num);
                    break;
                case "Remove" :
                    int num1=Integer.parseInt(tokens[1]);
                    numbers.remove((Object)num1);
                    break;
                case "RemoveAt" :
                    int num3=Integer.parseInt(tokens[1]);
                    numbers.remove(num3);
                    break;
                case "Insert" :
                    int num4=Integer.parseInt(tokens[1]);
                    int num5=Integer.parseInt(tokens[2]);
                    numbers.add(num5,num4);
                    break;
            }


        }

        for(Integer n : numbers){
            System.out.print(n + " ");
        }


    }
}
