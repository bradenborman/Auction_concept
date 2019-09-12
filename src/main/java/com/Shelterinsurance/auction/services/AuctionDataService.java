package com.Shelterinsurance.auction.services;

import com.Shelterinsurance.auction.utilities.AuctionExpireCalc;
import com.Shelterinsurance.auction.models.Auction;
import com.Shelterinsurance.auction.models.Bid;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AuctionDataService {

    //MOCKING AUCTION ID database var
    private AtomicInteger atomicInteger = new AtomicInteger(1);


    public List<Auction> getData() {

       File auctionDataFile = AuctionFileManager.createIfNecessary();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Auction> data = objectMapper.readValue(auctionDataFile, new TypeReference<List<Auction>>() {});
            data.forEach(auction -> {
                auction.setSecondsLeft(AuctionExpireCalc.calculateSecondsLeft(auction.getExpireTime()));
            })
            ;
            return data;
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<Auction>();
        }

    }


    public void updateAll() {

        List<Auction> currentData = getData();

        currentData.forEach(auction -> {
            if(auction.getAuctionId() == null)
                auction.setAuctionId(String.valueOf(atomicInteger.getAndIncrement()));

            auction.setLastBidTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            auction.setExpireTime(LocalDateTime.now().plusMinutes(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        });

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.writeValue(new FileWriter(AuctionFileManager.createIfNecessary()), currentData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Auction submitBid(Bid bid) {

        Auction auctionToReturn = new Auction();

        List<Auction> currentData = getData();
        currentData.forEach(auction -> {
            if(auction.getAuctionId().equals(bid.getAuctionId())) {
                auction.setBidderId(bid.getBidderId());
                auction.setItemPrice(auction.getItemPrice() + bid.getAmount());
                auction.setLastBidTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                auction.setExpireTime(LocalDateTime.now().plusMinutes(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                auction.setNumberOfBids(auction.getNumberOfBids()+ 1);

                auctionToReturn.setItemPrice(auction.getItemPrice());
                auctionToReturn.setLastBidTime(auction.getLastBidTime());
                auctionToReturn.setExpireTime(auction.getExpireTime());
                auctionToReturn.setNumberOfBids(auction.getNumberOfBids());
                auctionToReturn.setSecondsLeft(AuctionExpireCalc.calculateSecondsLeft(auction.getExpireTime()));
                auctionToReturn.setAuctionId(auction.getAuctionId());
                auctionToReturn.setBidderId(auction.getBidderId());

            }
        });

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileWriter(AuctionFileManager.createIfNecessary()), currentData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return auctionToReturn;
    }


}