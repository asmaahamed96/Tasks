package service;

import exception.DuplicatePlateException;
import exception.VehicleNotFoundException;
import model.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class RegistrationService {

    private List<Vehicle> vehicleList = new ArrayList<>();
    private Map<String, Vehicle> plateIndex = new HashMap<>();
    private Set<String> registeredPlates = new HashSet<>();

    public void registerVehicle(Vehicle vehicle) {
        String plateNumberUpperCase = vehicle.getPlateNumber().toUpperCase();
        if (registeredPlates.contains(plateNumberUpperCase)) {
            throw new DuplicatePlateException(vehicle.getPlateNumber());
        }
        vehicleList.add(vehicle);
        plateIndex.put(plateNumberUpperCase, vehicle);
        registeredPlates.add(plateNumberUpperCase);
    }

    public Vehicle findByPlate(String plate) {
        String plateUpperCase = plate.toUpperCase();
        Vehicle vehicle = plateIndex.get(plateUpperCase);
        if (vehicle == null) {
            throw new VehicleNotFoundException(plate);
        }
        return vehicle;
    }

    public void deleteVehicle(String plate) {
        String plateUpperCase = plate.toUpperCase();
        Vehicle vehicle = findByPlate(plate);
        if (vehicle == null) {
            throw new VehicleNotFoundException(plate);
        }
        vehicleList.remove(vehicle);
        plateIndex.remove(plateUpperCase, vehicle);
        registeredPlates.remove(plateUpperCase);
    }

    public void updateOwner(String plate, String newOwner) {
        Vehicle vehicle = findByPlate(plate);
        if (vehicle == null) {
            throw new VehicleNotFoundException(plate);
        }
        vehicle.setOwnerName(newOwner);
    }

    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(vehicleList);
    }
public List<Vehicle> filterByType(String type){
        return vehicleList.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(type)).
                collect(Collectors.toList());
}
public List<Vehicle> getVehiclesByOwner(String ownerName){
      return vehicleList.stream().filter(vehicle -> vehicle.getOwnerName().toLowerCase().
              contains(ownerName.toLowerCase())).collect(Collectors.toList());

}

    public List<Vehicle> getExpiredRegistrations(Integer currentYear) {
        return vehicleList.stream().filter(vehicle -> currentYear-vehicle.getRegistrationYear()>5).
                sorted(Comparator.comparingInt(Vehicle::getRegistrationYear)).collect(Collectors.toList());
    }
    public List<Vehicle> getSortedByYear(Boolean ascending){

        Comparator<Vehicle>comp =Comparator.comparingInt(Vehicle::getRegistrationYear);
        if (!ascending)comp = comp.reversed();
        return vehicleList.stream().sorted(comp).collect(Collectors.toList());

    }
    public void printStatistics(){
        IntSummaryStatistics stats = vehicleList.stream()
                .mapToInt(Vehicle::getRegistrationYear).summaryStatistics();

        Map<String,Long> byType =vehicleList.stream()
                .collect(Collectors.groupingBy(Vehicle::getVehicleType,Collectors.counting()));

        Map<Boolean,Long> byStatus = vehicleList.stream()
                .collect(Collectors.partitioningBy(vehicle -> vehicle.getStatus().equals("ACTIVE"),Collectors.counting() ));
        System.out.println("=============== REGISTRATION STATISTICS ==================");
        System.out.printf("Total Vehicles %d%n",stats.getCount());
        System.out.printf("Average Year %.0f%n" ,stats.getAverage());
        System.out.printf("Newest Vehicle %d%n" ,stats.getMax());
        System.out.printf("Oldest Vehicle %d%n" ,stats.getMin());
        System.out.println("-----------------------------------");
        System.out.println("Vehicles by type : ");
        byType.forEach((type , count)->System.out.printf("%s %d%n",type , count));
        System.out.println("-----------------------------------");
        System.out.printf("Active Vehicles : %d%n",byStatus.get(true));
        System.out.printf("Expired Vehicles : %d%n",byStatus.get(false));

        System.out.println("====================================================");

    }}