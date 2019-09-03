package com.Shelterinsurance.auction;

import java.time.LocalDateTime;

public class Auction {

    private String auctionId;
    private String itemShortName;
    private String itemDescription;
    private double itemPrice;
    private int numberOfBids;
    private LocalDateTime lastBidTime;
    private int secondsLeft;
    private String photoName;


    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getItemShortName() {
        return itemShortName;
    }

    public void setItemShortName(String itemShortName) {
        this.itemShortName = itemShortName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(int numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public LocalDateTime getLastBidTime() {
        return lastBidTime;
    }

    public void setLastBidTime(LocalDateTime lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
