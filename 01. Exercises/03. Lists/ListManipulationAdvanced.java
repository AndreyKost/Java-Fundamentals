import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers=new ArrayList<>();

        String input=scanner.nextLine();
        String[] strs=input.split(" ");
        for(String str : strs){
            int n=Integer.parseInt(str);
            numbers.add(n);
        }


        int sum=0;

        while (true){
            String line=scanner.nextLine();
            if(line.equals("End")){
                break;
            }

            String[] tokens=line.split(" ");

            sum=0;
            switch (tokens[0]) {
                case "Contains":
                    int num =Integer.parseInt(tokens[1]);
                    if (numbers.contains((Object) num)){
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (Integer n : numbers) {
                            if (n % 2 == 0) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    } else {
                        for (Integer n : numbers) {
                            if (n % 2 != 0) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    }
                case "Get":
                    if(tokens[1].equals("sum")){
                        for(Integer n : numbers){
                            sum+=n;
                        }
                        System.out.println(sum);
                        break;
                    }
                case "Filter":
                    int num1=Integer.parseInt(tokens[2]);
                    if(tokens[1].equals("<")){
                        for(Integer n : numbers){
                            if(n < num1 ){
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    } else if(tokens[1].equals(">")){
                        for(Integer n : numbers){
                            if(n > num1 ){
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    } else if(tokens[1].equals("<=")){
                        for(Integer n : numbers){
                            if(n <= num1 ){
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    } else if(tokens[1].equals(">=")){
                        for(Integer n : numbers){
                            if(n >= num1 ){
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                        break;
                    }


            }
            }
        }




    }

