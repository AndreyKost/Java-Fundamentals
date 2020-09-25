import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    public static class Vehicle {
        private String typeOfVehicle;
        private String model;
        private String color;
        private int horsePower;

        public String getTypeOfVehicle() {
            return typeOfVehicle;
        }

        public void setTypeOfVehicle(String typeOfVehicle) {
            this.typeOfVehicle = typeOfVehicle;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public Vehicle(String typeOfVehicle, String model, String color, int horsePower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        @Override
        public String toString(){
            return String.format("Type: %s%n"+
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d"
            ,getTypeOfVehicle().toUpperCase().charAt(0)+this.getTypeOfVehicle().substring(1)
            ,this.model
            ,this.color
            ,this.horsePower);
        }
    }

    private static double average(List<Vehicle> vehicles){
        if(vehicles.size()==0){
            return 0.0;
        }
        double sum=0;
        for(Vehicle vehicle : vehicles){
            sum+=vehicle.getHorsePower();
        }
        return sum /vehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();


        while (!line.equals("End")) {
            String[] commands = line.split(" ");
            String typeOfVehicle = commands[0];
            String model = commands[1];
            String color = commands[2];
            int horsePower = Integer.parseInt(commands[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            vehicles.add(vehicle);
            line = scanner.nextLine();
        }

        while (true) {
            String models = scanner.nextLine();
            if(!models.equals("Close the Catalogue")) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getModel().equals(models)) {
                        System.out.println(vehicle.toString());
                    }
                }
            } else {
                break;
            }

        }

        System.out.println(String.format("Cars have average horsepower of: %.2f.", average(vehicles.stream()
                .filter(v -> v.getTypeOfVehicle().equals("car"))
                .collect(Collectors.toList()))));

        System.out.println(String.format("Trucks have average horsepower of: %.2f.", average(vehicles.stream()
                .filter(v -> v.getTypeOfVehicle().equals("truck"))
                .collect(Collectors.toList()))));


    }
}
