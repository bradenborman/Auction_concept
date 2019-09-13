package com.Shelterinsurance.auction.services;

import com.Shelterinsurance.auction.models.Bid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BidTimeService {


    public void updateTimeOfBid(Bid bid) {
        LocalDateTime timeOfBid = LocalDateTime.now();
        bid.setTimeBidWasPlaced(timeOfBid.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
