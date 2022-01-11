package Activities;

public class Activity1{
    public static void main(String [] args) {
        // Car class instance
        Car refAudi = new Car();
        // Initialize the values
        refAudi.make = 2014;
        refAudi.color = "Black";
        refAudi.transmission = "Manual";
        // Calling Car class method
        refAudi.displayCharacteristics();
        refAudi.accelarate();
        refAudi.brake();

    }
}