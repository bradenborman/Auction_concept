package com.Shelterinsurance.auction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class ViewController {

    @Autowired
    AuctionDataService auctionDataService;


    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("data", auctionDataService.getData());
        return "home";
    }

    @GetMapping("/save")
    public String saveDates() {
        auctionDataService.updateAll();
        return "redirect:/";
    }

    @RequestMapping(value = "/bid", method = RequestMethod.POST)
    public ResponseEntity<Bid> bid(@RequestParam Map<String, String> body){
        Bid bid = new Bid(Double.valueOf(body.get("amountToIncrease")), body.get("auctionId"));
        auctionDataService.submitBid(bid);
        return ResponseEntity.ok(bid);
    }
}
