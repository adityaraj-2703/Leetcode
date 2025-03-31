package design.onlineauctionsystemdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionSystem {
    private static AuctionSystem instance;
    private final Map<String, User> users;
    private final Map<String, AuctionListing> auctionListings;

    private AuctionSystem() {
        users = new ConcurrentHashMap<>();
        auctionListings = new ConcurrentHashMap<>();
    }

    public static synchronized AuctionSystem getInstance() {
        if (instance == null) {
            instance = new AuctionSystem();
        }
        return instance;
    }

    public void registerUser(User u) {
        this.users.put(u.getId(), u);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void createAuctoinListing(AuctionListing a) {
        auctionListings.put(a.getId(), a);
        startAuctionTimer(a);
    }

    public List<AuctionListing> searchAuctionListing(String keyWord) {
        List<AuctionListing> matchedListing = new ArrayList<>();
        for (AuctionListing a : auctionListings.values()) {
            if (a.getDescription().contains(keyWord) || a.getItemName().contains(keyWord)) {
                matchedListing.add(a);
            }
        }
        return matchedListing;
    }

    public void placeBid(String auctionLListingId, Bid bid) {
        AuctionListing a = auctionListings.get(auctionLListingId);
        if (a != null) {
            a.placeBid(bid);
        }
    }

    public void startAuctionTimer(AuctionListing a) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                a.closeAuction();
            }
        }, a.getDuration());
    }

}
