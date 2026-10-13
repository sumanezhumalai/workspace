package Abstraction;

/**
 * Vehicle
 */
abstract class Vehicle { // abstract class indicates/can any abstract method or property
    // but its is not compulsory to have one inside

    public abstract void drive(); // tells that this implementation is don by the you (the sub clas)
                                  // must also define the class as abstract - or throws erro-The abstract method
                                  // drive in type Vehicle can only be defined by an abstract class

    public void playMusic() {
        System.out.println("Playing Songbird!");
    }
}

/**
 * Car
 */

// if you cant implement a abstract rule defined by parent in this class , then
// this clas must also be marked as Abstract to prevent error
class Car extends Vehicle { // if drive() not defined - throws error -> The type car must implement the
                            // inherited abstract method Vehicle.drive()
    public void drive() {
        System.out.println("Driving...");
    }
}

//this is a concrete class
public class Abstract {

    public static void main(String[] args) {
        // Vehicle obj = new Vehicle(); // abstract cannot be instantiated , only
        // inherited (Cannot instantiate the type
        // Vehicle)
        Car obj1 = new Car();

        obj1.drive();
    }

}
