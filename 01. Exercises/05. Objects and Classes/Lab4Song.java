import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4Song {
    public static class Song {
        private String typeList;
        private String name;
        private String time;

        private void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        private String getTypeList() {
            return typeList;
        }

        private void setName(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }

        private void setTime(String time) {
            this.time = time;
        }

        private String time() {
            return time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs=new ArrayList<>();

        while (n > 0) {
            String line = scanner.nextLine();
            String[] albums = line.split("_");
            String typeList = albums[0];
            String name = albums[1];
            String time = albums[2];

            Song song=new Song();
            song.setTypeList(typeList);
            song.setName(name);
            song.setTime(time);

            songs.add(song);

            n--;
        }

        String typeList=scanner.nextLine();

        if(typeList.equals("all")){
            for(Song song : songs){
                System.out.println(song.getName());
            }
        } else {
            for(Song song : songs){
                if(song.getTypeList().equals(typeList)){
                    System.out.println(song.getName());
                }
            }
        }



    }
}
