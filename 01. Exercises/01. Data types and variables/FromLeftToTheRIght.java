import java.util.Scanner;

public class FromLeftToTheRIght {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;

        for (int i = 0; i <n ; i++) {
            double a=scanner.nextDouble();
            double b=scanner.nextDouble();



            if (a>b) {
                a=Math.abs(a);
                while(a>0) {
                    sum += a % 10;
                    a = a / 10;
                }
            }else if(b>a){
                b=Math.abs(b);
                while (b>0) {
                    sum += b % 10;
                    b = b / 10;
                }
            } else {
                a=Math.abs(a);
                while(a>0) {
                    sum += a % 10;
                    a = a / 10;
                }
            }

            System.out.printf("%d %n",sum);

            sum=0;
        }



    }
}
