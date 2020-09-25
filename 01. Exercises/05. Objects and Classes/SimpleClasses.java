import java.util.Scanner;

public class SimpleClasses {
    static class Client{
        String name;
        int age;
        int cents;

        /*@Override
        public  String toString(){
            return String.format("%s %d %d%n",name,age,cents);
        }*/
    }

     static void haveABirthday(Client client){
        client.age++;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Client clientA=new Client();
        clientA.name="Joro";
        clientA.age=27;
        //System.out.println(clientA.cents);


        Client clientB=clientA;
        clientB.age++;
        System.out.println(clientA);
        System.out.println(clientB);
        System.out.println(clientB.age);
        System.out.println(clientA.age);

        haveABirthday(clientA);
        System.out.println(clientA.age);

    }
}
