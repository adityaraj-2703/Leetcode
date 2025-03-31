package design.carrentalsystem;

public class Customer {
    private final String name;
    private final String contactInfo;
    private final String drivingLicenceNumber;

    public Customer(String name, String contactInfo, String drivingLicenceNumber) {
        this.contactInfo = contactInfo;
        this.name = name;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

}
