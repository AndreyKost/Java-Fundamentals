import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] numbers2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sum=0;
        boolean isValid=true;
        for (int i = 0; i <numbers1.length ; i++) {
            if (numbers1[i] == numbers2[i]) {
                sum+=numbers1[i];
            } else {
                isValid=false;
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                break;
            }
        }

        if(isValid){
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }


    }
}
