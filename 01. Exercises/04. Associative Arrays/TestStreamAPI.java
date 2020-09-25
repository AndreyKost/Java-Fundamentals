import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TestStreamAPI {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] numbers= new int[]{1,2,3,4};

        IntStream s=Arrays.stream(numbers);
        OptionalInt x = s.min();

        if(x.isPresent()){
            System.out.println(x.getAsInt());
        } else {
            System.out.println("no elements");
        }

    }
}
