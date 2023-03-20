package vehicles;

import details.Engine;
import professions.Driver;

import java.io.FileWriter;
import java.io.IOException;

public class Truck extends Car implements Writeable {

    private int loadCapacity;

    public Truck(String type, int weight, Driver driver, Engine engine, int loadCapacity) {
        super(type, weight, driver, engine);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        String fileLocation = "src/main/resources/TruckInfo.txt";
        String truckInfo = "Truck info:" + "\n"
                + "Type: " + getType() + "; "
                + "Weight: " + getWeight() + "; "
                + "Engine manufacturer: " + engine.getManufacturer() + "; "
                + "Engine power: " + engine.getPower() + "; "
                + "loadCapacity: " + loadCapacity;
        writeToFile(truckInfo, fileLocation);
        return truckInfo;
    }

    @Override
    public void writeToFile(String fileText, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(fileText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
