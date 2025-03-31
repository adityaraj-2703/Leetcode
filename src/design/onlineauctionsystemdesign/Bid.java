package design.onlineauctionsystemdesign;

import java.time.LocalDateTime;

public class Bid {
    private final String id;
    private final User bidder;
    private final double amount;
    private final LocalDateTime timeStamp;

    public Bid(String id, User bidder, double amount) {
        this.id = id;
        this.bidder = bidder;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public User getBidder() {
        return bidder;
    }

    public double getAmount() {
        return amount;
    }

}
