import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while(true){
            String input=scanner.nextLine();
            String[] tokens=input.split(" ");
            if(tokens[0].equals("End")){
                break;
            }

            if(tokens[0].equals("Add")){
                int element=Integer.parseInt(tokens[1]);
                numbers.add(element);
            } else if(tokens[0].equals("Insert")) {
                int element=Integer.parseInt(tokens[1]);
                int index=Integer.parseInt(tokens[2]);
                if(index <0 || index>=numbers.size()){
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index,element);
                }
            } else if(tokens[0].equals("Remove")){
                int index=Integer.parseInt(tokens[1]);
                if(index < 0 || index>=numbers.size()){
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }
            } else if(tokens[0].equals("Shift")){
                if(tokens[1].equals("left")){
                    int count=Integer.parseInt(tokens[2]);
                    while(count>0){
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                        count--;
                    }
                } else {
                    int count=Integer.parseInt(tokens[2]);
                        while (count > 0) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                            count--;
                        }
                }
            }


        }

        for(Integer num : numbers){
            System.out.print(num + " ");
        }


    }
}
