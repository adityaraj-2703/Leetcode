package design.carrentalsystem;

import design.carrentalsystem.payment.CreditCardPaymentProcessor;
import design.carrentalsystem.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RentalSystem {
    private static RentalSystem instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

    private RentalSystem() {
        cars = new HashMap<>();
        reservations = new HashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();

    }

    public static synchronized RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public void addCar(Car c) {
        cars.put(c.getLicencePlate(), c);
    }

    public void removeCar(Car c) {
        cars.remove(c.getLicencePlate());
    }

    public List<Car> searchCar(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                if (isAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }

            }
        }
        return availableCars;
    }

    public boolean isAvailable(Car car, LocalDate start, LocalDate end) {
        for (Reservation r : reservations.values()) {
            if (r.getCar().equals(car)) {
                if (start.isBefore(r.getEndDate()) && end.isAfter(r.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer c, Car car, LocalDate start, LocalDate end) {
        if (isAvailable(car, start, end)) {
            String reservationId = generatereservationId();
            Reservation r = new Reservation(reservationId, c, car, start, end);
            reservations.put(reservationId, r);
            car.setAvailable(false);
            return r;
        }
        return null;

    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation r = reservations.remove(reservationId);
        if (r != null) {
            r.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation r) {
        return paymentProcessor.processPayment(r.calculateTotalPrice());
    }

    public String generatereservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
