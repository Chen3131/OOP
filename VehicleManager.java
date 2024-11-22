import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManager {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private static final String filename = "Vehicles.txt";
    private static int vehicleId = 1;
    private Scanner input = new Scanner(System.in);

    public void saveToFile() {
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filename))) {
            for(Vehicle vehicle : vehicleList) {
                bWriter.write("ID: " + vehicle.getId() + "\n" 
                + "Model: " + vehicle.getCarModel() + "\n" + "Car Type: " + vehicle.getCarType() + "\n" + "Quantity: " + vehicle.getQuantity() 
                + "\n" + "Rental Rate: " + vehicle.getRentRate() + "\n");
            }
        }catch(IOException exc) {
            System.out.println("Saving vehicle data failed, " + exc.getMessage());
        }
    }

    Vehicle findVehicleById(int id) {
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle() {
        System.out.println("------/ Add Vehicle /------");
        int id = vehicleId++;
        System.out.println("Enter the car model: ");
        String carModel = input.nextLine();
        System.out.println("Enter the car type: ");
        String carType = input.nextLine();
        System.out.println("Enter the quantity of cars: ");
        int quantity = input.nextInt();
        System.out.println("Enter the rental rate: ");
        double rentRate = input.nextDouble();
        input.nextLine();

        vehicleList.add(new Vehicle(id, carModel, carType, quantity, rentRate));
        saveToFile();
    }

    public void viewInventory() {
        if(vehicleList.isEmpty()) {
            System.out.println("No vehicles available.\n");
        } else {
            for(Vehicle vehicle: vehicleList) {
                System.out.println(vehicle);
            }
        }
    }

    public void removeVehicle() {
        for(Vehicle vehicle : vehicleList) {
            System.out.println("------/ Remove Vehicle /------");
            System.out.print("Enter ID: ");
            int idRemove = input.nextInt();
            input.nextLine();
 
            Vehicle vehicleRemove = findVehicleById(idRemove);

            if(vehicleRemove != null) {
                vehicleList.remove(vehicleRemove);
                saveToFile();
                System.out.println("Vehicle removed successfully.\n");
            } else {
                System.out.println("No vehicle find with the ID: " + idRemove);
            }
        }
    }

    public void updateVehicles() {
        System.out.println("Enter the ID of the vehicle to be updated: ");
        int idUpdate = input.nextInt();
        input.nextLine();

        Vehicle vehicleUpdate = findVehicleById(idUpdate);

        if(vehicleUpdate != null) {
            System.out.println("Vehicle found: " + vehicleUpdate);
            System.out.print("Enter new model(press Enter to keep current): ");
            String newmodel = input.nextLine();
            if(!newmodel.isEmpty()) {
                vehicleUpdate.setCarModel(newmodel);
            }

            System.out.print("Enter new type(press Enter to keep current): ");
            String newtype = input.nextLine();
            if(!newtype.isEmpty()) {
                vehicleUpdate.setCarType(newtype);
            }

            System.out.print("Enter new quantity(press Enter to keep current): ");
            String quaninput = input.nextLine();
            
            if(!quaninput.isEmpty()) {
                int newquan = Integer.parseInt(quaninput);
                vehicleUpdate.setQuantity(newquan);
            }

            System.out.print("Enter new rental rate(press Enter to keep current): ");
            String rrinput = input.nextLine();

            if(!rrinput.isEmpty()) {
                double newrr = Double.parseDouble(rrinput);
                vehicleUpdate.setRentRate(newrr);
            }

            saveToFile();
            System.out.println("Vehicle updated.\n");
        }
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
