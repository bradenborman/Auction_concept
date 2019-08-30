package com.Shelterinsurance.auction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {

    @Autowired
    AuctionDataService auctionDataService;


    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("data", auctionDataService.getData());
        return "home";
    }

}
