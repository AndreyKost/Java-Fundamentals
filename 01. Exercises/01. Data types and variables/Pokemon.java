import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int half=N/2;

        while (N >= M) {

            N -= M;
            count++;
            if (N==half) {
                if(Y!=0) {
                    N = N / Y;
                }
            }

        }

        System.out.println(N);
        System.out.println(count);


    }
}
