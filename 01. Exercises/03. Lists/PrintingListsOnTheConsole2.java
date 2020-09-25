import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintingListsOnTheConsole2 {
    public static void main(String[] args) {
        List<String> lists=new ArrayList<>(Arrays.asList("one","two","three","four","five","six"));

        System.out.println(String.join(" ",lists));



    }
}
