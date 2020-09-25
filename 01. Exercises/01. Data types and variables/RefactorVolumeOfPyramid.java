import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        double lenght=0;
        System.out.print("Length: ");
        lenght = Double.parseDouble(scanner.nextLine());
        double width=0;
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());
        double height=0;
        System.out.print("Height: ");
        height = Double.parseDouble(scanner.nextLine());
        double sum = (lenght + width + height);
        System.out.printf("Pyramid Volume: %.2f", sum);




    }
}
