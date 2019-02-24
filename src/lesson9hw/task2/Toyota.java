package lesson9hw.task2;

public class Toyota extends Car {

    public Toyota(ToyotaModel model, int manufactureYear, String vehicleIdentificationNumber,
                  int enginePower, String licensePlateNumber, boolean armoredIndicator) {
        super(Make.TOYOTA, model, manufactureYear, vehicleIdentificationNumber,
                enginePower, licensePlateNumber, armoredIndicator);
    }

    public enum ToyotaModel {

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