package lesson9hw.task2;

import java.util.Objects;

public abstract class Car {

    private Make make;
    private Enum model;
    private int manufactureYear;
    private int enginePower;
    private boolean armoredIndicator;
    private String vehicleIdentificationNumber;
    private String licensePlateNumber;

    public Car(Make make, Enum model, int manufactureYear, String vehicleIdentificationNumber,
               int enginePower, String licensePlateNumber, boolean armoredIndicator) {
        this.make = make;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.enginePower = enginePower;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.armoredIndicator = armoredIndicator;
    }

    public enum Make {

        BMW, TOYOTA, TESLA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return vehicleIdentificationNumber.equals(car.vehicleIdentificationNumber) &&
                licensePlateNumber.equals(car.licensePlateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, enginePower, armoredIndicator);
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + " ::"
                + "\n\tmodel = '" + model + '\''
                + "\n\tmanufactureYear = " + manufactureYear
                + "\n\tenginePower = " + enginePower
                + "\n\tvehicleIdentificationNumber = " + vehicleIdentificationNumber
                + "\n\tlicensePlateNumber = '" + licensePlateNumber + '\''
                + "\n\tarmoredIndicator = " + armoredIndicator + "    ";
    }

    public Enum getMake() {
        return make;
    }

    public boolean isArmoredIndicator() {
        return armoredIndicator;
    }

    public Enum getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public boolean getArmoredIndicator() {
        return armoredIndicator;
    }
}
