import java.util.ArrayList;
import java.util.Scanner;

public class RawData {
    public static class Car{


        private String model;
        private Engine engine;
        private Cargo cargo;
        private ArrayList<Tyre> tyre;

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public ArrayList<Tyre> getTyre() {
            return tyre;
        }

        public Car(String model, Engine engine, Cargo cargo, ArrayList<Tyre> tyre) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tyre = tyre;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
    public static class Engine{

    }
    public static class Cargo{

    }
    public static class Tyre{

    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);



    }
}
