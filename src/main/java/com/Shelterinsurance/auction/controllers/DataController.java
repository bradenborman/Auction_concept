package com.Shelterinsurance.auction.controllers;


import com.Shelterinsurance.auction.models.Auction;
import com.Shelterinsurance.auction.services.AuctionDataService;
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

}