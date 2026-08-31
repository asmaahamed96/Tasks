package Level4;

import java.util.Objects;

public class Car {
    private final String plateNumber;
    private final String color;

    public Car(String plateNumber, String color) {
        this.plateNumber = plateNumber;
        this.color = color;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Car{plate='" + plateNumber + "', color='" + color + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        return Objects.equals(this.plateNumber, ((Car) obj).plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}
