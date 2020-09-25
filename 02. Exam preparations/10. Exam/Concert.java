import java.util.*;

public class Concert {
    static class   Band{

        private String name;
        private int time;
        List<String> members=new ArrayList<>();

        public Band(String name){
            this.name=name;
        }

        public int getTime() {
            return time;
        }

        public String getName() {
            return name;
        }

        public List<String> getMembers() {
            return members;
        }

        public void play(int time) {
            this.time+=time;
        }

        public void add(String member) {
            if(!this.members.contains(member)) {
                this.members.add(member);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, Band> bandsByName=new HashMap<>();

        String command=scanner.nextLine();

        while (!command.equals("start of concert")){
            String[] commandBandParameters=command.split("; ");

            Band band=bandsByName.get(commandBandParameters[1]);
            String bandName=commandBandParameters[1];
            if(band==null){
                band=new Band(bandName);
                bandsByName.put(bandName,band);
            }


            if(commandBandParameters[0].equals("Play")){
                int playTime=Integer.parseInt(commandBandParameters[2]);
                band.play(playTime);

            } else if(commandBandParameters[0].equals("Add")){
                String[] members=commandBandParameters[2].split(", ");
                for (String member : members) {
                    band.add(member);
                }


            } else {
                throw new IllegalStateException("uknown command");
            }


            command=scanner.nextLine();
        }

        int totalTime=0;
        List<Band> bandsSorted = new ArrayList<>(bandsByName.values());
        Collections.sort(bandsSorted,(a,b)->{
            int result=Integer.compare(b.getTime(),a.getTime());
            if(result==0){
                result=(a.getName().compareTo(b.getName()));
            }
            return result;
        });

        for (Band band : bandsSorted) {
            totalTime+=band.getTime();
        }
        System.out.printf("Total time: %d%n",totalTime);

        //TODO: sort bands
        for (Band band : bandsSorted) {
            System.out.printf("%s -> %d%n",band.getName(), band.getTime());
        }

        String bandToPrint=scanner.nextLine();

        // TODO: print band members of bandToPrint
        Band band=bandsByName.get(bandToPrint);
        System.out.println(bandToPrint);
        for (String member : band.getMembers()) {
            System.out.println("=> "+ member);
        }


    }
}
