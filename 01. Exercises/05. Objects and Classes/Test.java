import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
   static class Client{
       String name;
       int age;
       int cents;

       @Override
       public  String toString(){
           return String.format("%s %d %d%n",name,age,cents);
       }
   }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       List<Client> clients=new ArrayList<>();
       String input=scanner.next();
       while (!input.equals("end")) {
           String name = input;
           int age=scanner.nextInt();
           int cents=scanner.nextInt();

           Client client=new Client();
           client.name=name;
           client.age=age;
           client.cents=cents;
           clients.add(client);
           input=scanner.next();
       }

       int minAge=scanner.nextInt();

        for(Client client : clients){
            if(client.age>=minAge){
                client.cents-=500;
                //System.out.printf("%s %d %d%n",client.name,client.age,client.cents);
                client.toString();
            }
        }



    }
}
