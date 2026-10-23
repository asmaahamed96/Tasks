import exception.DuplicatePlateException;
import exception.InvalidInputException;
import exception.VehicleNotFoundException;
import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;
import service.RegistrationService;
import util.InputValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        RegistrationService registrationService = new RegistrationService();
        registrationService.registerVehicle(new Car("CAR-001", "Ahmed Ali",    2019, "EXPIRED", 4));
        registrationService.registerVehicle(new Car("CAR-002", "Sara Kamel",   2023, "ACTIVE",  2));
        registrationService.registerVehicle(new Truck("TRK-001", "Mohamed Said", 2021, "ACTIVE",
                10.0));
        registrationService.registerVehicle(new Truck("TRK-002", "Laila Nour",   2017, "EXPIRED",
                5.5));
        registrationService.registerVehicle(new Motorcycle("MOT-001", "Omar Fathi", 2022, "ACTIVE",
                "Sport"));
        registrationService.registerVehicle(new Motorcycle("MOT-002", "Nadia Hamed", 2024, "ACTIVE",
                "Cruiser"));
        while (true){
            System.out.println("==============================");
            System.out.println("VEHICLE REGISTRATION SYSTEM   v1.0 ");
            System.out.println("==============================");
        System.out.println("1. Register New Vehicle ");
        System.out.println("2. Search Vehicle by plate ");
        System.out.println("3. Update Owner Name ");
        System.out.println("4. Delete Vehicle ");
        System.out.println("5. List All Vehicle ");
        System.out.println("6. Filter by Vehicle Type ");
        System.out.println("7. Show Owen History ");
        System.out.println("8. Show Expired Registration ");
        System.out.println("9. Statics Report ");
        System.out.println("0. Exit ");
        System.out.println("==============================");

        System.out.println("enter your choice : ");
Integer choice=0;

try {
     choice= scanner.nextInt();
     scanner.nextLine();
} catch (InputMismatchException exception) {
    scanner.nextLine();
    throw new InputMismatchException("Invalid input . please enter a number ");

}
            switch (choice){

                case 1:
                    String plateNumber="";
                    String ownerName="";
                    String vehicleType="";
                    Integer registrationYear=0;
                    try {
                        System.out.println("enter plate number : ");
                         plateNumber = scanner.nextLine();
                        InputValidator.validatePlateNumber(plateNumber);
                        System.out.println("enter owner name : ");
                         ownerName = scanner.nextLine();
                         InputValidator.validateOwnerName(ownerName);
                        System.out.println("enter vehicle type : ");
                         vehicleType = scanner.next();
                         InputValidator.validateVehicleType(vehicleType);
                        System.out.println("enter registration year : ");
                         registrationYear = scanner.nextInt();
                         InputValidator.validateRegistrationYear(registrationYear);
                    }catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());
                    }

if(vehicleType.equalsIgnoreCase("car")) {
    System.out.println("enter number of doors : ");
    Integer numberOfDoors = scanner.nextInt();
    Vehicle vehicle = new Car(plateNumber, ownerName, registrationYear, "ACTIVE", numberOfDoors);
    try {
        registrationService.registerVehicle(vehicle);
    } catch (DuplicatePlateException exception) {

        System.out.println(exception.getMessage());

    }
}else if (vehicleType.equalsIgnoreCase("motorCycle")) {

    System.out.println("please enter engine type : ");
    String engineType = scanner.next();
    Vehicle vehicle = new Motorcycle(plateNumber, ownerName, registrationYear, "ACTIVE", engineType);

    try {
        registrationService.registerVehicle(vehicle);
    } catch (DuplicatePlateException exception) {

        System.out.println(exception.getMessage());

    }
    }
else if (vehicleType.equalsIgnoreCase("Truck")) {

    System.out.println("please enter cargoCapacityTons : ");
    double cargoCapacityTons = scanner.nextDouble();
    Vehicle vehicle = new Truck(plateNumber, ownerName, registrationYear, "ACTIVE",cargoCapacityTons);

    try {
        registrationService.registerVehicle(vehicle);
    } catch (DuplicatePlateException exception) {

        System.out.println(exception.getMessage());

    }
}

                    break;
                case 2:
                    System.out.println("enter plate number ");
                    String plate="";
                    try {
                         plate=scanner.nextLine();
                    }catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());
                    }


                 try {
                     System.out.println(registrationService.findByPlate(plate));
                 }catch (VehicleNotFoundException exception){
                     System.out.println(exception.getMessage());
                 }

                    break;

                case 3:
                    System.out.println("enter plate number ");
                    String searchPlate="";
                    String newOwnerName="";
                    try{
                     searchPlate=scanner.nextLine();
                    System.out.println("enter new owner name : ");
                     newOwnerName =scanner.nextLine(); }
                    catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());
                    }
                    try {
                        registrationService.updateOwner(searchPlate,newOwnerName);
                    }catch (VehicleNotFoundException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;

                case 4:
                    plate="";
                    try {

                    System.out.println("enter plate number ");
                    plate=scanner.nextLine();}
                    catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());

                    }
                    try {
                        registrationService.deleteVehicle(plate);
                    }catch (VehicleNotFoundException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;

                case 5:
                    System.out.println(registrationService.getAllVehicles());

                    break;
                case 6:
                    String type="";
                    try {


                    System.out.println("enter vehicle type : ");
                     type=scanner.next();}
                    catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());

                    }
                    System.out.println(registrationService.filterByType(type));
                    break;
                case 7:
                   String OwnerName="";
                    try {


                    System.out.println("enter owner name : ");
                     OwnerName =scanner.nextLine();}
                    catch (InvalidInputException exception)
                    { System.out.println("Input error : "+exception.getMessage());
                    }
                    System.out.println(registrationService.getVehiclesByOwner(OwnerName));

                    break;
                case 8:
                    Integer currentYear=0;
                    try {


                    System.out.println("enter current year : ");
                     currentYear=scanner.nextInt(); }
                    catch (InvalidInputException exception){
                        System.out.println("Input error : "+exception.getMessage());
                    }
                    System.out.println(registrationService.getExpiredRegistrations(currentYear));
                    break;
                case 9:
            registrationService.printStatistics();
                    break;
                case 0:
                    System.out.println("Bye...Bye");
                    System.exit(0);
                    break;

                default:
                    System.out.println("invalid choice ");
            }

 }
















    }
}