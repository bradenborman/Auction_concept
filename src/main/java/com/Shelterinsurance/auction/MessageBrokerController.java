package com.Shelterinsurance.auction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageBrokerController {

    @Autowired
    AuctionDataService auctionDataService;


    @MessageMapping("/placeBid")
    @SendTo("/topic/incomingBid")
    public Auction placeBid(Bid bid) throws Exception {
        return auctionDataService.submitBid(bid);
    }


}
