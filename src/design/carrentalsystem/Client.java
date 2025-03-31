package design.carrentalsystem;

import java.time.LocalDate;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();
        rentalSystem.addCar(new Car("Toyota", "Camry", 2022, "ABC123", 50.0));
        rentalSystem.addCar(new Car("Honda", "Civic", 2021, "XYZ789", 45.0));
        rentalSystem.addCar(new Car("Ford", "Mustang", 2023, "DEF456", 80.0));

        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(3);

        List<Car> availableCars = rentalSystem.searchCar("Toyota", "Camry", start, end);
        if (!availableCars.isEmpty()) {
            Car selectedcar = availableCars.get(0);
            Reservation r = rentalSystem.makeReservation(customer1, selectedcar, start, end);
            if (r != null) {
                boolean paymentSuccess = rentalSystem.processPayment(r);
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + r.getReservationId());

                } else {
                    System.out.println("Payment Failed");
                    rentalSystem.cancelReservation(r.getReservationId());
                }
            } else {
                System.out.println("selected car not available in given dates");
            }
        } else {
            System.out.println("no available cars found in this criteria");
        }

    }

}
