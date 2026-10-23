package model;

import java.util.Objects;

public abstract class Vehicle {
    private String plateNumber;
    private String ownerName;
    private String vehicleType;
    private int registrationYear;
    private String status;

    public Vehicle(String plateNumber,String ownerName, String vehicleType,int registrationYear,String status){
        this.plateNumber=plateNumber;
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
        this.registrationYear=registrationYear;
        this.status=status;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public String getStatus() {
        return status;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  @Override
  public String toString(){
        return "["+plateNumber+"]"+ " | " + vehicleType +" | "+" owner : " +ownerName+" | "+" year : " + registrationYear + " | " + " status : "+status;
  }
 public abstract String getRegistrationLabel();

  @Override
  public boolean equals(Object o){
      if(o==this){
          return true;
      }
      if(o==null ||this.getClass()!=o.getClass()){
          return false;}
      Vehicle v = (Vehicle) o;
      return plateNumber.equalsIgnoreCase(v.plateNumber);
  }
  @Override
  public int hashCode() {
      int result = Objects.hash(plateNumber.toLowerCase());
      return result;
  }


}

