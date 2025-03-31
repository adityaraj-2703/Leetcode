package design.parkinglot;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private static ParkingLot instance;
    private String name;
    // private Address address;
    // private ParkingRate parkingRate;
    private Map<String, ParkingFloor> parkingFloors;
    private Map<String, EntrancePanel> entrances;
    private Map<String, ExitPanel> exits;
    private Map<String, ParkingTicket> activeTickets;
    private Map<String, Map<String, Integer>> parkingSpotsAvailable = new HashMap<>();
    private Map<ParkingTicket, Integer> payments;
    private Display display;

    private ParkingLot(Display d) {
        this.display = d;
    }

    public static ParkingLot getInstance(Display d) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(d);

                }
            }
        }
        return instance;
    }

    public boolean assignParkingSpots(String floor, Map<String, Integer> spots) {
        this.parkingSpotsAvailable = new HashMap<>();
        parkingSpotsAvailable.put(floor, spots);
        return false;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle, ParkingFloor f) {
        Map<String, Integer> pk = parkingSpotsAvailable.get(f.getFloor());

        ParkingSpotType p = getParkingSpot(vehicle);

        System.out.println(p);
        if (pk.isEmpty() || pk.get(p.toString()) == 0) {
            display.update("Floor Full");
        }
        int t = pk.get(p.toString());
        pk.put(vehicle.getVehicleType().toString(), t - 1);
        parkingSpotsAvailable.put(f.getFloor(), pk);
        ParkingSpot p11 = new ParkingSpot(p);
        ParkingTicket p1 = new ParkingTicket(vehicle, new Date(), p11);
        System.out.println(p1.getStartTime());
        return p1;

    }

    public ParkingSpotType getParkingSpot(Vehicle vehicle) {
        if (vehicle.getVehicleType() == VehicleType.Cars) {
            return ParkingSpotType.Compact;
        } else if (vehicle.getVehicleType() == VehicleType.Trucks) {
            return ParkingSpotType.Large;
        } else {
            return ParkingSpotType.Motorcycle;
        }
    }

    private ParkingSpotType getParkingSpotType(VehicleType vehicleType) {

        return null;
    }

    public void processPayment(Vehicle vehicle, ParkingTicket ticket, PaymentStrategy p) {
        double tax = vehicle.getVehicleType().getTax(vehicle.getVehicleType());
        double cost = calculatePayment(tax, ticket);

    }

    public double calculatePayment(double tax, ParkingTicket ticket) {
        // int hours = Date.now() - ticket.getStartTime();
        Date now = new Date();
        long currentTimeMillis = now.getTime() - ticket.getStartTime().getTime();

        int hours = (int) TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
        if (hours == 0) {
            return tax + 50;
        }
        return hours * 100 + tax;
    }

    public double getTax(VehicleType t) {
        switch (t) {
            case Cars:
                return 0.1;
            case Trucks:
                return 0.4;
            default:
                return 0.3;
        }
    }

    public static void main(String[] args) {
        Display d = new Display();
        ParkingLot p = ParkingLot.getInstance(d);
        Vehicle v = new Vehicle(VehicleType.Cars, "1234");
        ParkingFloor f = new ParkingFloor("1");
        Map<String, Integer> m = new HashMap<>();
        m.put(ParkingSpotType.Large.toString(), 3);
        p.assignParkingSpots(f.getFloor(), m);
        p.getNewParkingTicket(v, f);
    }

}
