import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfPeople=Integer.parseInt(scanner.nextLine());
        int capacity=Integer.parseInt(scanner.nextLine());
        int nums2;

        if (numberOfPeople>capacity){
            int nums1=numberOfPeople/capacity;
            if (numberOfPeople%capacity!=0) {
                nums2=nums1+1;
            }else {
                nums2=nums1;
            }

            System.out.printf("%d",nums2);

        } else {
            System.out.println("1");
        }


    }
}
