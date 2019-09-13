package com.Shelterinsurance.auction.models;

public class Bid {

    private double amount;
    private String auctionId;
    private String bidderId;
    private String timeBidWasPlaced;


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

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public String getTimeBidWasPlaced() {
        return timeBidWasPlaced;
    }

    public void setTimeBidWasPlaced(String timeBidWasPlaced) {
        this.timeBidWasPlaced = timeBidWasPlaced;
    }
}
