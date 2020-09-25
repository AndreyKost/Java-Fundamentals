import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=Integer.parseInt(scanner.nextLine());
        double max=Double.MIN_VALUE;
        double snowballValue=0;
        int snowballShowMax=0;
        int snowBallTimeMax=0;
        double snowballQualityMax=0;

        for (int i = 1; i <=N ; i++) {
            int snowballSnow=Integer.parseInt(scanner.nextLine());
            int snowballTime=Integer.parseInt(scanner.nextLine());
            int snowballQuality=Integer.parseInt(scanner.nextLine());
            double calc=snowballSnow/snowballTime;
            snowballValue=Math.pow(calc,snowballQuality);

            if (snowballValue>=max) {
                max=snowballValue;
                snowballShowMax=snowballSnow;
                snowBallTimeMax=snowballTime;
                snowballQualityMax=snowballQuality;
            }

        }



        System.out.printf("%d : %d = %.0f (%.0f)",snowballShowMax,snowBallTimeMax,max,snowballQualityMax);



    }
}
