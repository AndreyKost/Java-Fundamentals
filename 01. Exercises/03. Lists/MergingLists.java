import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String values1=scanner.nextLine();
        List<Integer> numbers1=Arrays.stream(values1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String values2=scanner.nextLine();
        List<Integer> numbers2=Arrays.stream(values2.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> merged=new ArrayList<>();


        if(numbers1.size()>=numbers2.size()){
            for (int i = 0; i <numbers1.size() ; i++) {
                merged.add(numbers1.get(i));
                if(i<numbers2.size()){
                    merged.add(numbers2.get(i));
                }

            }


        } else {
            for (int i = 0; i <numbers2.size() ; i++) {
                if(i<numbers1.size()){
                    merged.add(numbers1.get(i));
                }
                merged.add(numbers2.get(i));
            }

        }

        for(int num : merged ){
            System.out.print(num + " ");
        }


    }
}
