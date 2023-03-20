package professions;

public class Driver {
    private String fio;
    private int drivingExpirience;
    private int mileage;
    private double mileageInYear;

    public Driver(String fio, int drivingExpirience, int mileage) {
        this.fio = fio;
        this.drivingExpirience = drivingExpirience;
        this.mileage = mileage;
        try {
            mileageInYear = mileage / drivingExpirience;
        } catch (ArithmeticException e) {
            System.out.println(e + " Значение пробега в год приравнено к пробегу.");
            mileageInYear = mileage;
        }
    }

    public int getDrivingExpirience() {
        return drivingExpirience;
    }

    public String getFio() {
        return fio;
    }

    public double getMileageInYear() {
        return mileageInYear;
    }
}
