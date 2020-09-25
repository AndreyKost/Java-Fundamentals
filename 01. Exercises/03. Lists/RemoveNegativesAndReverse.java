import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] words=input.split(" ");

        List<Integer> numbers=new ArrayList<>();
        for(String word : words){
            int n=Integer.parseInt(word);
            numbers.add(n);
        }

        int index=0;
        while(index<numbers.size()){
            if(numbers.get(index)<0){
                numbers.remove(numbers.get(index));
                index=0;
            } else {
                index++;
            }
        }


        if(numbers.size()>0){
            for(int i=numbers.size()-1;i>=0;i--){
                System.out.printf("%d ",numbers.get(i));
            }
        } else {
            System.out.println("empty");
        }

    }
}
