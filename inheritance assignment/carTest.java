class Car {
    private String brand;
    private String model;
    private int year;

    // No-argument constructor
    public Car() {
        this("Unknown"); // Calls the one-argument constructor
    }

    // One-argument constructor
    public Car(String brand) {
        this(brand, "Not specified", 0); // Calls the three-argument constructor
    }

    // Three-argument constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("---------------------------");
    }
}

// Main class
public class carTest {
    public static void main(String[] args) {
        // Using no-argument constructor
        Car car1 = new Car();
        car1.displayInfo();

        // Using one-argument constructor
        Car car2 = new Car("Toyota");
        car2.displayInfo();

        // Using three-argument constructor
        Car car3 = new Car("Honda", "Civic", 2022);
        car3.displayInfo();
    }
}

