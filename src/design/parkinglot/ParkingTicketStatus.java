package design.parkinglot;

public enum ParkingTicketStatus {
    ACTIVE("Active"),
    PAID("Paid"),
    LOST("Lost");

    private String description;

    ParkingTicketStatus(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }

    public boolean isPaid() {
        return this == PAID;
    }

}
