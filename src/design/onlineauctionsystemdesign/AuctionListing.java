package design.onlineauctionsystemdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuctionListing {
    private final String id;
    private final String itemName;
    private final String description;
    private final double startingPrice;
    private final long duration;
    private final User seller;
    private AuctionStatus status;
    private double currentHighestBid;
    private User currentHighestUser;
    private final List<Bid> bids;
    private final BiddingObserver observer;

    public AuctionListing(String id, String itemName, String description, double startPrice, long duration,
            User seller, BiddingObserver observer) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startPrice;
        this.duration = duration;
        this.seller = seller;
        this.bids = new CopyOnWriteArrayList<>();
        this.observer = new BiddingDisplay();
        this.status = AuctionStatus.ACTIVE;
    }

    public synchronized void placeBid(Bid bid) {
        if (status == AuctionStatus.ACTIVE && bid.getAmount() > currentHighestBid) {
            bids.add(bid);
            currentHighestBid = bid.getAmount();
            currentHighestUser = bid.getBidder();
            notifyObserver("Bid by user: " + currentHighestUser.getId());
        }
    }

    public void closeAuction() {
        if (this.status == AuctionStatus.ACTIVE) {
            this.status = AuctionStatus.CLOSED;
        }
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public long getDuration() {
        return duration;
    }

    public void notifyObserver(String s) {
        observer.update(s);
    }

}
