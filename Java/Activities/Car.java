package Activities;

public class Car{
    // Class variables
    int make;
    int tyres;
    int doors;
    String color;
    String transmission;

    // Constructor
    Car() {
        tyres = 4;
        doors = 4;
    }
    // Class methods
    public void displayCharacteristics() {
        System.out.println("make of the Car is  " + make);
        System.out.println("total tyres on the Car is " + tyres);
        System.out.println("total doors on the Car is  " + doors);
        System.out.println("color of the Car is " + color);
        System.out.println("transmission of the Car is " + transmission);
    }
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }
    public void brake() {
        System.out.println("Car has stopped.");
    }

}