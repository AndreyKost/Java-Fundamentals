import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, List<String>> storeItems=new LinkedHashMap<>();

        String line=scanner.nextLine();
        while (!line.equals("END")){
            String[] tokens=line.split("->");
            if(tokens[0].equals("Add")) {
                if (!tokens[2].contains(",")) {
                    String store = tokens[1];
                    String item = tokens[2];
                    if (storeItems.containsKey(store)) {
                        storeItems.get(store).add(item);
                    } else {
                        storeItems.put(store, new ArrayList<>());
                        storeItems.get(store).add(item);
                    }
                } else {
                    String store = tokens[1];
                    String[] moreItem = tokens[2].split(",");
                    if (storeItems.containsKey(store)) {
                        for (int i = 0; i < moreItem.length; i++) {
                            storeItems.get(store).add(moreItem[i]);
                        }
                    } else {
                        storeItems.put(store, new ArrayList<>());
                        for (int i = 0; i < moreItem.length; i++) {
                            storeItems.get(store).add(moreItem[i]);
                        }
                    }
                }
            } else {
                String store=tokens[1];
                if(storeItems.containsKey(store)){
                    storeItems.remove(store);
                }
            }

            line=scanner.nextLine();
        }


        System.out.println("Stores list:");
        storeItems.entrySet().stream().sorted((first,second)->{
            int result=Integer.compare(second.getValue().size(),first.getValue().size());
            if(result==0){
                result=second.getKey().compareTo(first.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s%n",e.getKey());
            List<String> pts=e.getValue();
            for (int i = 0; i <pts.size() ; i++) {
                System.out.println("<<"+pts.get(i)+">>");
            }
        });



    }
}
