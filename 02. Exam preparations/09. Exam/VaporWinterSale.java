import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String line=scanner.nextLine();
        Map<String, Double> gamesPrice=new LinkedHashMap<>();
        Map<String, String> gamesDLC=new LinkedHashMap<>();

        String[] commands=line.split(", ");
        for (String command : commands) {
            if(command.contains("-")){
                String[] tokens=command.split("-");
                String game=tokens[0];
                Double price=Double.parseDouble(tokens[1]);
                if(!gamesPrice.containsKey(game)){
                    gamesPrice.put(game,price);
                }
            } else {
                String[] tokens=command.split(":");
                String game=tokens[0];
                String DLC=tokens[1];
                if(gamesPrice.containsKey(game)){
                    gamesDLC.put(game,DLC);
                }
            }
        }

        Map<String, Double> gamesFinal=new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : gamesPrice.entrySet()) {
            boolean isEqual=false;
            for (Map.Entry<String, String> stringEntry : gamesDLC.entrySet()) {
                if(entry.getKey().equals(stringEntry.getKey())){
                    isEqual=true;
                    double n=entry.getValue()*1.20;
                    double y=n*0.5;
                    gamesFinal.put(entry.getKey(),y);
                }

            }
            if(!isEqual){
                double n=entry.getValue()*0.8;
                gamesFinal.put(entry.getKey(),n);
            }
        }

        gamesFinal.entrySet().stream().sorted((first,second)->{
            int result=first.getValue().compareTo(second.getValue());
            return result;
        }).forEach(e->{
            /*gamesDLC.entrySet().forEach(e2->{
                if(e.getKey().equals(e2.getKey())){
                    System.out.printf("%s - %s - %.2f%n",e.getKey(),e2.getValue(),e.getValue());
                }
            });*/
            if(gamesDLC.containsKey(e.getKey())){
                System.out.printf("%s - %s - %.2f%n",e.getKey(),gamesDLC.get(e.getKey()),e.getValue());
            }
        });

        AtomicBoolean isValid=new AtomicBoolean();
        gamesFinal.entrySet().stream().sorted((first,second)->{
            int result=second.getValue().compareTo(first.getValue());
            return result;
        }).forEach(e->{
            /*isValid.set(false);
            gamesDLC.entrySet().forEach(e2->{
                if(e.getKey().equals(e2.getKey())){
                    System.out.printf("%s - %s - %.2f%n",e.getKey(),e2.getValue(),e.getValue());
                    isValid.set(true);
                }
            });
            if(isValid.compareAndSet(false,false)){
                System.out.printf("%s - %.2f%n",e.getKey(),e.getValue());
            }*/
            if(!gamesDLC.containsKey(e.getKey())){
                System.out.printf("%s - %.2f%n",e.getKey(),e.getValue());
            }
        });



    }
}
