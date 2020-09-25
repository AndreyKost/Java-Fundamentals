import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] houses=scanner.nextLine().split("@");
        int[] numbers=new int[houses.length];
        for(int i=0;i<houses.length;i++){
            int n=Integer.parseInt(houses[i]);
            numbers[i]=n;
        }
        String line=scanner.nextLine();
        int index=0;

        while(!line.equals("Merry Xmas!")){
            String[] symbols=line.split(" ");
            if(symbols[0].equals("Jump")) {
                int jumpLenght = Integer.parseInt(symbols[1]);

                if (index + jumpLenght >= numbers.length) {
                    int sum = index + jumpLenght;
                    index = sum - numbers.length;
                    while (index>=numbers.length){
                        index = index - numbers.length;
                    }
                } else {
                    int sum = index + jumpLenght;
                    index = sum;
                }

                if (numbers[index] == 0) {
                    System.out.printf("House %d will have a Merry Christmas.%n", index);
                } else {
                    numbers[index] -= 2;
                }
            }
            line=scanner.nextLine();
        }

        boolean isValid=true;
        int count=0;
        System.out.printf("Santa's last position was %d.%n",index);
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]!=0){
                isValid=false;
                count++;
            }
        }


        if(isValid){
            System.out.printf("Mission was successful.%n");
        } else {
            System.out.printf("Santa has failed %d houses.",count);
        }
    }
}
