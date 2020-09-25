import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> shops= Arrays.stream(scanner.nextLine()
        .split(" "))
        .collect(Collectors.toList());

        int n=Integer.parseInt(scanner.nextLine());

        while (n>0){
            String[] commands=scanner.nextLine().split(" ");
            String command=commands[0];
            if(command.equals("Include")){
                String shop=commands[1];
                shops.add(shop);
            } else if(command.equals("Visit")){
                String str=commands[1];
                if(str.equals("first")){
                    int number=Integer.parseInt(commands[2]);
                    if(number<=shops.size()){
                        while(number>0){
                            shops.remove(0);
                            number--;
                        }
                    }
                }
                if(str.equals("last")){
                    int number=Integer.parseInt(commands[2]);
                    if(number<=shops.size()){
                        while(number>0){
                            shops.remove(shops.size()-1);
                            number--;
                        }
                    }
                }
            } else if(command.equals("Prefer")){
                int index1=Integer.parseInt(commands[1]);
                int index2=Integer.parseInt(commands[2]);
                if((index1>=0 && index1<shops.size()) && (index2>=0 && index2<shops.size())){
                   String shop1=shops.get(index1);
                   String shop2=shops.get(index2);
                   shops.set(index1,shop2);
                   shops.set(index2,shop1);
                }
            } else if(command.equals("Place")){
                String shop=commands[1];
                int index=Integer.parseInt(commands[2]);
                if(index+1>=0 && index+1<=shops.size()){
                    shops.add(index+1,shop);
                }
            }

            n--;
        }


        System.out.println("Shops left:");
        for (int i = 0; i <shops.size() ; i++) {
            System.out.printf("%s ",shops.get(i));
        }

    }
}
