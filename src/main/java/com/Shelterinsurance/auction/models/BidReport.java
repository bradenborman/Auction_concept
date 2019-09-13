package com.Shelterinsurance.auction.models;

import java.util.List;

public class BidReport {

    Auction auction;
    List<Bid> bidsForItem;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<Bid> getBidsForItem() {
        return bidsForItem;
    }

    public void setBidsForItem(List<Bid> bidsForItem) {
        this.bidsForItem = bidsForItem;
    }
}
