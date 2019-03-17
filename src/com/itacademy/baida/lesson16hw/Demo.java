package com.itacademy.baida.lesson16hw;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        CrazyScientist firstScientist = new CrazyScientist("Scientist 1 :: ");
        CrazyScientist secondScientist = new CrazyScientist(":: Scientist 2 :: ");
        Servant firstServant = new Servant("Servant 1 :: ", firstScientist);
        Servant secondServant = new Servant(":: Servant 2 ", secondScientist);
        Factory factory = new Factory(":FACTORY: ");
        factory.throwDetails(20);

        factory.start();
        firstServant.start();
        secondServant.start();
        firstScientist.start();
        secondScientist.start();

        factory.join();
        firstServant.join();
        secondServant.join();
        firstScientist.join();
        secondScientist.join();

        System.out.println(System.lineSeparator() + "Scientists 1 finished " + firstScientist.getRobotDetails());
        System.out.println("\tRobots amount " + firstScientist.getRobots().size());
        System.out.println("Scientists 2 finished " + secondScientist.getRobotDetails());
        System.out.println("\tRobots amount " + secondScientist.getRobots().size() + System.lineSeparator());

        System.out.println(firstScientist.getRobots().size() > secondScientist.getRobots().size()
                ? "First scientist won! Robots amount: " + firstScientist.getRobots().size()
                : firstScientist.getRobots().size() == secondScientist.getRobots().size()
                    ? "Draw! Scientists created equal amount of robots: " + firstScientist.getRobots().size()
                    : "Second scientist won!  Robots amount: " + secondScientist.getRobots().size());
    }
}