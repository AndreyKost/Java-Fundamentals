import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise4Articles2 {
    public static class Article {
        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s"
                    , this.title
                    , this.content
                    , this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        while (n > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(", ");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];

            Article article = new Article(title, content, author);
            articles.add(article);


            n--;
        }

        String command=scanner.nextLine();
        if(command.equals("title")){
            articles.sort(Comparator.comparing(Article::getTitle));
        } else if(command.equals("content")){
            articles.sort(Comparator.comparing(Article::getContent));
        } else if(command.equals("author")){
            articles.sort(Comparator.comparing(Article::getAuthor));
        }

        for(Article article : articles){
            System.out.println(article.toString());
        }



    }
}
