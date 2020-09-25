import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tests1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> words=new ArrayList<>();
        words.add("Gabrovo");
        words.add("Pleven");
        words.add("Sofia");
        words.add("Sevlievo");
        words.add("Pleven");
        words.add("Sofia");

        /*for (String word : words) {
            System.out.print(word+" ");
        }*/

        while(words.remove("Sofia")){

        }

        for (String word : words) {
            System.out.print(word+" ");
        }



    }
}
