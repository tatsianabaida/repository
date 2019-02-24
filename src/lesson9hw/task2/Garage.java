package lesson9hw.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Garage {

    private Map<Car, Integer> carAmountMap;

    public Garage() {
        this.carAmountMap = new HashMap<>();
    }

    public void parkCar(Car newCar) {
        carAmountMap.put(newCar, (int) getAmountOfSameCars(newCar) + 1);
        carAmountMap.entrySet().stream()
                .filter(entry -> entry.getKey().hashCode() == newCar.hashCode())
                .forEach(entry ->
                        carAmountMap.compute(entry.getKey(), (key, value) -> carAmountMap.get(newCar)));
    }

    public long getAmountOfSameCars(Car car) {
        return (carAmountMap.keySet().stream()
                .filter(garageCar -> garageCar.hashCode() == car.hashCode())
                .count());
    }

    public void takeCar(String vehicleIdentificationNumber) {
        Optional<Car> targetCar = carAmountMap.keySet().stream()
                .filter(garageCar -> garageCar.getVehicleIdentificationNumber().equals(vehicleIdentificationNumber))
                .findFirst();
        if (targetCar.isPresent()) {
            carAmountMap.remove(targetCar.get());
            int amountOfRemainingCars = (int) getAmountOfSameCars(targetCar.get());
            carAmountMap.entrySet().stream()
                    .filter(entry -> entry.getKey().hashCode() == targetCar.hashCode())
                    .forEach(entry ->
                            carAmountMap.compute(entry.getKey(),
                                    (key, value) -> amountOfRemainingCars));
        }
    }

    public long getAmountOfSameMakeCars(Enum make) {
        return carAmountMap.entrySet().stream()
                .filter(entry -> entry.getKey().getMake() == make)
                .count();
    }

    @Override
    public String toString() {
        return "Garage {"
                + "\n\tCar map :: "
                + "\n\t\tcar = total amount of same cars "
                + "\n\t\tin the garage at the moment: " + carAmountMap + '}';
    }

    public Map<Car, Integer> getCarAmountMap() {
        return carAmountMap;
    }
}
