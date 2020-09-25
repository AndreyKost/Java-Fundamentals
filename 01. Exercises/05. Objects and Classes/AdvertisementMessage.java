import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String[] Phrases = new String[] {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};

        String[] Events = new String[] { "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!" };

        String[] Authors = new String[] { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };

        String[] Cities = new String[] { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

        Random num = new Random();


        for (int i = 0; i <number ; i++) {
            int PhraseIndex = num.nextInt(Phrases.length);
            int EventIndex = num.nextInt( Events.length);
            int AuthorIndex = num.nextInt(Authors.length);
            int CityIndex = num.nextInt(Cities.length);

            System.out.println(Phrases[PhraseIndex]+" "+Events[EventIndex]+" " + Authors[AuthorIndex]+ " - "+Cities[CityIndex]);

        }
        
    }
}
