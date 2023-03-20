package vehicles;

import details.Engine;
import exception.NoSuchQualificationException;
import professions.Driver;

import java.io.FileWriter;
import java.io.IOException;

public class SportCar extends Car implements Writeable {

    private final int MINIMAL_DRIVING_EXPERIENCE = 10;

    public SportCar(String type, int weight, Driver driver, Engine engine) {
        super(type, weight, driver, engine);
    }

    @Override
    public String start() throws NoSuchQualificationException {
        if (driver.getDrivingExpirience() < MINIMAL_DRIVING_EXPERIENCE) {
            String drivingExperienceExceptionText = driver.getFio() +
                    " недостаточно квалифицирован, требуемый стаж: " + MINIMAL_DRIVING_EXPERIENCE +
                    ", стаж водителя: " + driver.getDrivingExpirience();
            String fileLocation = "src/main/resources/DriverWithOutQualificationInfo.txt";
            writeToFile(drivingExperienceExceptionText, fileLocation);
            throw new NoSuchQualificationException(drivingExperienceExceptionText);
        }
        return super.start();
    }

    @Override
    public void writeToFile(String fileText, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(fileText);
        } catch (IOException e) {
            System.out.println(e + " Проверь файл " + fileName);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e + " Ошибка закрытия файла");
                }
            }
        }
    }

}