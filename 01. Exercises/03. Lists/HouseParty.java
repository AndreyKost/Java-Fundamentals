import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOfLines=Integer.parseInt(scanner.nextLine());
        List<String> guests=new ArrayList<>();


        while (numOfLines>0){
            String input=scanner.nextLine();
            String[] tokens=input.split(" ");


            if (tokens[2].equals("going!")) {
                if(guests.contains(tokens[0])){
                    System.out.printf("%s is already in the list!%n",tokens[0]);
                } else {
                    guests.add(tokens[0]);
                }
            } else {
                if(guests.contains((Object) tokens[0])){

                    while(guests.remove((Object) tokens[0])){

                    }
                } else {
                    System.out.printf("%s is not in the list!%n",tokens[0]);
                }
            }

            numOfLines--;
        }

        for(String str : guests){
            System.out.println(str);
        }


    }
}
