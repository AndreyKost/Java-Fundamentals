

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingListValuesFromASingleLine2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String values=scanner.nextLine();
        List<String> items= Arrays.stream(values.split(" ")).collect(Collectors.toList());

        List<Integer> nums=new ArrayList<>();
        for (int i = 0; i <items.size() ; i++) {
            nums.add(Integer.parseInt(items.get(i)));
        }

        for (int i = 0; i <nums.size() ; i++) {
            System.out.printf("arr[%d]=%d%n",i,nums.get(i));
        }

        //za integer e
        //List<Integer> items=Arrays.stream(values.split(" ")).map(Integer::parseInt).collect(Collectors.toList());


    }
}
