import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> gifts= Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        String line=scanner.nextLine();

        while(!line.equals("No Money")){
            String[] coomands=line.split(" ");
            String command=coomands[0];

            if(command.equals("OutOfStock")){
                String gift=coomands[1];
                if(gifts.contains(gift)){
                    while(gifts.contains(gift)){
                    int index=gifts.indexOf(gift);
                    gifts.set(index,"None");
                    }
                }
            } else if(command.equals("Required")){
                String gift=coomands[1];
                int index=Integer.parseInt(coomands[2]);
                if(index>=0 && index<gifts.size()){
                    gifts.set(index,gift);
                }
            } else if(command.equals("JustInCase")){
                String gift=coomands[1];
                gifts.set(gifts.size()-1,gift);
            }


            line=scanner.nextLine();
        }


        for (int i = 0; i <gifts.size() ; i++) {
            if(!(gifts.get(i)).equals("None")){
                System.out.printf("%s ",gifts.get(i));
            }
        }



    }
}
