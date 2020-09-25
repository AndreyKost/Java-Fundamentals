import java.util.Scanner;

public class Elevator2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfPeople=Integer.parseInt(scanner.nextLine());
        int capacity=Integer.parseInt(scanner.nextLine());

        int all=(int)Math.ceil((double)numberOfPeople/capacity);

        System.out.printf("%d",all);


    }
}
