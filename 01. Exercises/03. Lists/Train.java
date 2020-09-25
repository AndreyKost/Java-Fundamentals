import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> listOfWagons= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxPassangers=Integer.parseInt(scanner.nextLine());


        while(true){
            String input=scanner.nextLine();
            String[] symbols=input.split(" ");

            if(symbols[0].equals("end")){
                break;
            }

            int sum=0;

            if(symbols[0].equals("Add")){
                int n=Integer.parseInt(symbols[1]);
                listOfWagons.add(n);
            } else  {
                int n=Integer.parseInt(symbols[0]);
                for(int i=0;i<listOfWagons.size();i++){
                     sum=listOfWagons.get(i)+n;
                    if(sum<=maxPassangers){
                        listOfWagons.set(i,sum);
                        break;
                    }
                }

            }


        }

        for(Integer wagon : listOfWagons ){
            System.out.print(wagon + " ");
        }



    }
}
