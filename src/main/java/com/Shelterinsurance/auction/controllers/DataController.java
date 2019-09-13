package com.Shelterinsurance.auction.controllers;


import com.Shelterinsurance.auction.models.Auction;
import com.Shelterinsurance.auction.models.Bid;
import com.Shelterinsurance.auction.models.BidReport;
import com.Shelterinsurance.auction.services.AuctionDataService;
import com.Shelterinsurance.auction.services.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
public class DataController {


    @Autowired
    AuctionDataService auctionDataService;

    @Autowired
    BidHistoryService bidHistoryService;

    @GetMapping("/data")
    public List<Auction> welcome() {
       return auctionDataService.getData();
    }

    @RequestMapping(value = "image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        try {
            File serverFile = new File("images/" + imageName);
            return Files.readAllBytes(serverFile.toPath());
        }catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/get-auction-bids/id/{auctionID}")
    public BidReport bidReportByauctionID(@PathVariable String auctionID) {
        BidReport bidReport = new BidReport();
        bidReport.setAuction(auctionDataService.getData().stream().filter(auc -> auc.getAuctionId().equals(auctionID)).findFirst().orElse(new Auction()));
        bidReport.setBidsForItem(bidHistoryService.getAllBidsByAuctionId(auctionID));
        return bidReport;
    }

    @GetMapping("/get-auction-bids/name/{name}")
    public BidReport bidReportByname(@PathVariable String name) {
        BidReport bidReport = new BidReport();
        bidReport.setAuction(auctionDataService.getData().stream().filter(auc -> auc.getItemShortName().equals(name)).findFirst().orElse(new Auction()));
        bidReport.setBidsForItem(bidHistoryService.getAllBidsByAuctionId(bidReport.getAuction().getAuctionId()));
        return bidReport;
    }
}
