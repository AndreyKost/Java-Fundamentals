import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //int[] inputElements= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        String[] inputElements=scanner.nextLine().split(" ");   
        int[] number=new int[inputElements.length];

        for (int i = 0; i <inputElements.length ; i++) {
            number[i] = Integer.parseInt(inputElements[i]);

        }

        int rotations=Integer.parseInt(scanner.nextLine());
        rotations=rotations%number.length;

        for (int i = 0; i <rotations ; i++) {
            int firstElement = number[0];

            for (int j = 0; j < number.length - 1; j++) {
                number[j] = number[j + 1];
            }

            number[number.length - 1] = firstElement;
        }

        for (int i = 0; i <number.length ; i++) {
            System.out.printf("%d ",number[i]);
        }

        
    }

}
