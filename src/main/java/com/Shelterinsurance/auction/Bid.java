package com.Shelterinsurance.auction;

public class Bid {

    private double amount;
    private String auctionId;

    public Bid(double amount, String auctionId) {
        this.amount = amount;
        this.auctionId = auctionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }
}
