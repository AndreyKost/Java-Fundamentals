import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long yield=Integer.parseInt(scanner.nextLine());
        long total=0;
        long days=0;




            while (yield >= 100) {
                days++;
                total += yield;
                total = total - 26;
                yield = yield - 10;

            }

        System.out.println(days);
        System.out.println(total-26);



    }
}
