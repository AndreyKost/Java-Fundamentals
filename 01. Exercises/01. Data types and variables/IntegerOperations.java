import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int first=Integer.parseInt(scanner.nextLine());
        int second=Integer.parseInt(scanner.nextLine());
        int third=Integer.parseInt(scanner.nextLine());
        int forth=Integer.parseInt(scanner.nextLine());


        int firstSecond=(first+second)/third;
        int sum=firstSecond*forth;

        System.out.printf("%d",sum);


    }
}
