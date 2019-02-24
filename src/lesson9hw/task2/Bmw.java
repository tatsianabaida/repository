package lesson9hw.task2;

public class Bmw extends Car {

    public Bmw(BmwModel model, int manufactureYear, String vehicleIdentificationNumber,
               int enginePower, String licensePlateNumber, boolean armoredIndicator) {
        super(Make.BMW, model, manufactureYear, vehicleIdentificationNumber,
                enginePower, licensePlateNumber, armoredIndicator);
    }

    public enum BmwModel {

        MODEL1, MODEL2, MODEL3
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
