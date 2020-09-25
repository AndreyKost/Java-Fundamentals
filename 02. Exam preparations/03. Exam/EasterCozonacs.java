import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        double priceFor1KgFlour=Double.parseDouble(scanner.nextLine());
        double pricePackOfEggs=priceFor1KgFlour*0.75;
        double priceFor1LMilk=priceFor1KgFlour*1.25;
        double priceForQuarterMilk=priceFor1LMilk/(double)4;
        int colouredEggs=0;
        double totalPrice=0;
        int countOfCozonacs=0;


        while (totalPrice<budget){
            double currentPrice=pricePackOfEggs+priceFor1KgFlour+priceForQuarterMilk;
            if(totalPrice+currentPrice<budget){
                totalPrice+=currentPrice;
                countOfCozonacs++;
                colouredEggs+=3;
                if(countOfCozonacs!=0 && countOfCozonacs%3==0){
                    int minus=countOfCozonacs-2;
                    colouredEggs-=minus;
                }

            } else {
                break;
            }

        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",countOfCozonacs,colouredEggs,budget-totalPrice);




    }
}
