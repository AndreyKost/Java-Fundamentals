import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double a=Double.parseDouble(scanner.nextLine());
        double b=Double.parseDouble(scanner.nextLine());
        double difference=0;
        double eps=0.000001;

        if (a>b) {
            difference=a-b;
        } else {
            difference=b-a;
        }

        if (difference<=eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }





    }
}
