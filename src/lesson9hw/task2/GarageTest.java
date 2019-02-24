package lesson9hw.task2;

public class GarageTest {

    public static void main(String[] args) {
        Car tesla = new Tesla(Tesla.TeslaModel.MODEL1, 2008,
                "VI78360358-767-666", 200, "testlicensePlate96961",
                false);
        Car similarTesla = new Tesla(Tesla.TeslaModel.MODEL1, 2018,
                "VI79160458-927-665", 200, "testlicensePlate99961",
                false);
        Car bmwModel1 = new Bmw(Bmw.BmwModel.MODEL1, 2000,
                "VI73360458-482-663", 200, "testlicensePlate99961",
                false);
        Car toyota = new Toyota(Toyota.ToyotaModel.MODEL1, 2000,
                "VI70460458-754-663", 200, "testlicensePlate99961",
                false);
        Car bmwModel2 = new Bmw(Bmw.BmwModel.MODEL2, 2002,
                "VI73360458-777-653", 200, "testlicensePlate99761",
                false);
        Car similarBmwModel2 = new Bmw(Bmw.BmwModel.MODEL2, 2004,
                "VI73360458-777-643", 200, "testlicensePlate99861",
                false);
        Car differentBmwModel2 = new Bmw(Bmw.BmwModel.MODEL2, 1998,
                "VI73360458-777-443", 200, "testlicensePlate89861",
                true);

        Garage garage = new Garage();
        garage.parkCar(tesla);
        garage.parkCar(similarTesla);
        garage.parkCar(toyota);
        garage.parkCar(bmwModel1);
        garage.parkCar(bmwModel2);
        garage.parkCar(similarBmwModel2);
        garage.parkCar(differentBmwModel2);
        System.out.println(garage);
        System.out.println("\nAmount of same BMW's: Model 2, etc. in the garage:  "
                + garage.getAmountOfSameCars(bmwModel2));
        System.out.println("Amount of all BMW's in the garage at the moment:  "
                + garage.getAmountOfSameMakeCars(Car.Make.BMW));
        System.out.println("Total amount of cars at the moment:  "
                + garage.getCarAmountMap().size());

        garage.takeCar(similarBmwModel2.getVehicleIdentificationNumber());
        garage.takeCar(toyota.getVehicleIdentificationNumber());
        garage.takeCar("VI73360458-482-663");
        System.out.println("\n\n" + garage);
        System.out.println("\nAmount of Toyota's after Toyota is taken:  " + garage.getAmountOfSameCars(toyota));
        System.out.println("Amount of same BMW's: Model 2, etc. after one is taken:  "
                + garage.getAmountOfSameCars(similarBmwModel2));
        System.out.println("Total amount of cars after three cars are taken:  "
                + garage.getCarAmountMap().size());
    }
}