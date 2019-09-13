package com.Shelterinsurance.auction.controllers;


import com.Shelterinsurance.auction.models.Auction;
import com.Shelterinsurance.auction.models.Bid;
import com.Shelterinsurance.auction.services.AuctionDataService;
import com.Shelterinsurance.auction.services.BidHistoryService;
import com.Shelterinsurance.auction.services.BidTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageBrokerController {

    @Autowired
    AuctionDataService auctionDataService;

    @Autowired
    BidHistoryService bidHistoryService;

    @Autowired
    BidTimeService bidTimeService;

    @MessageMapping("/placeBid")
    @SendTo("/topic/incomingBid")
    public Auction placeBid(Bid bid) throws Exception {

        bidTimeService.updateTimeOfBid(bid);
        bidHistoryService.recordNewBid(bid);
        return auctionDataService.submitBid(bid);

    }


}
