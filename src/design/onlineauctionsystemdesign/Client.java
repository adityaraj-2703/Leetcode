package design.onlineauctionsystemdesign;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        AuctionSystem as = AuctionSystem.getInstance();
        User u1 = new User("1", "Aditya", "aditya.3342@gmail.com");
        User u2 = new User("2", "Raj", "aditya.raj@gmail.com");
        as.registerUser(u1);
        as.registerUser(u2);

        AuctionListing al1 = new AuctionListing("1", "Item1", "Description 1", 100.0, 60000, u1, new BiddingDisplay());
        AuctionListing al2 = new AuctionListing("1", "Item2", "Description 2", 50.0, 12000, u2, new BiddingDisplay());

        as.createAuctoinListing(al1);
        as.createAuctoinListing(al2);

        List<AuctionListing> li = as.searchAuctionListing("Item");
        System.out.println("Search Results:");

        for (AuctionListing ali : li) {
            System.out.println(ali.getItemName());

        }

        Bid bid1 = new Bid("1", u2, 150.0);
        Bid bid2 = new Bid("1", u1, 200.0);
        as.placeBid(al1.getId(), bid1);
        as.placeBid(al2.getId(), bid2);

    }

}
