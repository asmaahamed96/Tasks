package util;

import exception.InvalidInputException;

import javax.xml.crypto.Data;
import java.util.Date;

public class InputValidator {

    public static void validatePlateNumber(String plateNumber) {

            if (plateNumber == null
                    || !plateNumber.trim().toUpperCase().matches("[A-Z0-9-]{3,10}")) {
                throw new InvalidInputException("Plate number must be 3-10 alphanumeric characters");
            }
        }



    public static void validateOwnerName(String ownerName) {
            if (ownerName == null
                    || ownerName.trim().length() < 3
                    || !ownerName.trim().matches("[A-Za-z]+( [A-Za-z]+)*")) {
                throw new InvalidInputException("Owner name must contain only letters");
            }
        }

public static void validateVehicleType(String vehicleType){
        if(!vehicleType.equalsIgnoreCase("Car") && !vehicleType.equalsIgnoreCase("Truck")&& !vehicleType.equalsIgnoreCase("Motorcycle")) {
            throw new InvalidInputException("Invalid type. Use: Car , Truck , Motorcycle ");
        }
    }
public static void validateRegistrationYear(Integer registrationYear){

        int currentYear = java.time.Year.now().getValue();
        if (registrationYear<1990 ||registrationYear>currentYear){
            throw new InvalidInputException("Year must be between 1990 and "+currentYear);
        }

}














}
