import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        List<Integer> numbers=new ArrayList<>();
        StringBuilder newLine=new StringBuilder(line);
        List<Integer> takeList=new ArrayList<>();
        List<Integer> skipList=new ArrayList<>();

        for(int i=0;i<line.length();i++){
            String s="";
            if(Character.isDigit(line.charAt(i))){
                 s=""+line.charAt(i);
                numbers.add(Integer.parseInt(s));
            }
        }
        int a=0;
        while(a<newLine.length()){
            String s="";
            if(Character.isDigit(newLine.charAt(a))){
                newLine.deleteCharAt(a);
            } else {
                a++;
            }
        }

        line=newLine.toString();
        List<String> nonNumbers=new ArrayList<>();
        for(int i=0;i<line.length();i++){
            String s="";
            s=""+line.charAt(i);
            nonNumbers.add(s);
        }

        String sum="";
        for(int i=0;i<numbers.size();i++){
            if(i%2==0){
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        for (int i = 0; i <takeList.size() ; i++) {
            int num1=0;
            int num2=0;

            for (int j = 0; j <takeList.get(i) ; j++) {
                if(j<nonNumbers.size()) {
                    sum = sum + "" + nonNumbers.get(j);
                }
            }
             num1=takeList.get(i);
            while(num1>0){
                if(num1<=nonNumbers.size()) {
                    nonNumbers.remove(0);
                }
                num1--;
            }

             num2=skipList.get(i);
            while (num2>0){
                if(num2<=nonNumbers.size()) {
                    nonNumbers.remove(0);
                }
                num2--;
            }

        }

        System.out.println(sum);







    }
}
