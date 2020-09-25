import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String[] arr=new String[n];

        for (int i = 0; i <arr.length ; i++) {
            String str=scanner.nextLine();
            arr[i]=str;
        }

        String temp="";
        for (int i = 0; i <arr.length/2 ; i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }


    }
}
