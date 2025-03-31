package design.carrentalsystem;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String licencePlate;
    private final double rentalPricePerDay;
    private boolean available;

    public Car(String make, String model, int year, String licencePlate, double rentalPricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licencePlate = licencePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = true;

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
