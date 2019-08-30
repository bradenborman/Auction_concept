package com.Shelterinsurance.auction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {


    @Autowired
    AuctionDataService auctionDataService;


    @GetMapping("/data")
    public List<Auction> welcome() {
       return auctionDataService.getData();
    }

}
