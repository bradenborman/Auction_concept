package com.Shelterinsurance.auction.models;

import java.util.ArrayList;
import java.util.List;

public class BidHistory {


    private List<Bid> allBids = new ArrayList<Bid>();

    public List<Bid> getAllBids() {
        return allBids;
    }

    public void setAllBids(List<Bid> allBids) {
        this.allBids = allBids;
    }
}
