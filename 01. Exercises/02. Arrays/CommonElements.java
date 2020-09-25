import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        
        String[] words1=scanner.nextLine().trim().split(" ");
        String[] words2=scanner.nextLine().trim().split(" ");

        for (int i = 0; i <words2.length ; i++) {
            for (int j = 0; j <words1.length ; j++) {
                if (words2[i].equals(words1[j])) {
                    System.out.printf("%s ",words2[i]);
                }

            }
        }





    }
}
