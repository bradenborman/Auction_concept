package com.Shelterinsurance.auction.services;

import com.Shelterinsurance.auction.models.Bid;
import com.Shelterinsurance.auction.models.BidHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BidHistoryService {


    public void recordNewBid(Bid bid) {
        BidHistory bidHistory = getAllBids();
        bidHistory.getAllBids().add(bid);
        writeToFile(bidHistory);
    }


    private BidHistory getAllBids() {
        File bidHistoryFile = AuctionFileManager.createBidHistoryIfNecessary();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(bidHistoryFile, BidHistory.class);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new BidHistory();
        }
    }

    private void writeToFile(BidHistory bidHistory) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileWriter(AuctionFileManager.createBidHistoryIfNecessary()), bidHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Bid> getAllBidsByAuctionId(String auctionToGet) {
        return getAllBids().getAllBids().stream()
                .filter(bid -> bid.getAuctionId().equals(auctionToGet)).collect(Collectors.toList());
    }

}

