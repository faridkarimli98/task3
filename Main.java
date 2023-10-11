import java.util.ArrayList;

// Engine superclass
class Engine {
    // Common attributes and methods for engines
}

// Subclasses of Engine
class CombustionEngine extends Engine {
    // Specific attributes and methods for CombustionEngine
}

class ElectricEngine extends Engine {
    // Specific attributes and methods for ElectricEngine
}

class HybridEngine extends Engine {
    // Specific attributes and methods for HybridEngine
}

// Manufacture class with setters and getters
class Manufacture {
    private String name;
    private String location;

    public Manufacture(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // Other getters and setters
}


// Vehicle superclass with an abstract method
abstract class Vehicle {
    protected Manufacture manufacture;
    private Engine engine;

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public abstract void showCharacteristics();
}


// Subclasses of Vehicle
class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture, CombustionEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("This is an ICEV.");
        System.out.println("Manufactured by: " + manufacture.getName());
    }
}

class BEV extends Vehicle {
    public BEV(Manufacture manufacture, ElectricEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("This is a BEV.");
        System.out.println("Manufactured by: " + manufacture.getName());
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture, HybridEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void showCharacteristics() {
        System.out.println("This is a Hybrid Vehicle.");
        System.out.println("Manufactured by: " + manufacture.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Manufacture toyota = new Manufacture("Toyota", "Japan");
        Manufacture tesla = new Manufacture("Tesla", "USA");

        CombustionEngine combustionEngine = new CombustionEngine();
        ElectricEngine electricEngine = new ElectricEngine();
        HybridEngine hybridEngine = new HybridEngine();

        ICEV icev = new ICEV(toyota, combustionEngine);
        BEV bev = new BEV(tesla, electricEngine);
        HybridV hybrid = new HybridV(toyota, hybridEngine);

        // Create an array of vehicles
        Vehicle[] vehicles = {icev, bev, hybrid};

        // Use the showCharacteristics method to demonstrate
        for (Vehicle vehicle : vehicles) {
            vehicle.showCharacteristics();
        }
    }
}
