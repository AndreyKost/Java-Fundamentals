import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise2Articles {
    public static class Article{
        private String title;
        private String content;
        private String author;


        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setContent(String content){
            this.content=content;
        }

        public void changeAuthor(String author){
            this.author=author;
        }

        public void rename(String title){
            this.title=title;
        }

        @Override
        public String toString(){
            return String.format("%s - %s: %s"
            ,this.title
            ,this.content
            ,this.author);
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] line=scanner.nextLine().split(",");
        String title=line[0];
        String content=line[1];
        String author=line[2];

        Article article=new Article(title,content,author);

        int n=Integer.parseInt(scanner.nextLine());

        while (n>0){
            String[] tokens=scanner.nextLine().split(": ");
            String command=tokens[0];
            String param=tokens[1];

            if(command.equals("Edit")){
                article.setContent(param);
            } else if(command.equals("ChangeAuthor")){
                article.changeAuthor(param);
            } else if(command.equals("Rename")){
                article.rename(param);
            }
            n--;
        }

        System.out.println(article);


    }
}
