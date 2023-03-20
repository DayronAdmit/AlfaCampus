package vehicles;

import details.Engine;
import exception.NoSuchQualificationException;
import professions.Driver;

public class Car {
    private String type;
    private int weight;
    Driver driver;
    Engine engine;

    public Car(String type, int weight, Driver driver, Engine engine) {
        this.type = type;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String start() throws NoSuchQualificationException {
        return "поехали";
    }

    public String stop() {
        return "останавливаемся";
    }

    public String turnRight() {
        return "поворот направо";
    }

    public String turnLeft() {
        return "поворот налево";
    }

}
