package com.Shelterinsurance.auction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
class AuctionDataService {




    List<Auction> getData() {

       File auctionDataFile = AuctionFileManager.createIfNecessary();
        Random rand = new Random();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Auction> data = objectMapper.readValue(auctionDataFile, new TypeReference<List<Auction>>() {});
            data.forEach(auction -> {
                auction.setSecondsLeft(rand.nextInt(150));
                auction.setAuctionId(String.valueOf(rand.nextInt(1000)));
            })
            ;
            return data;
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<Auction>();
        }

    }

}