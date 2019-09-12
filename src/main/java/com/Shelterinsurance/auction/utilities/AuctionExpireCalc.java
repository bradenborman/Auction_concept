package com.Shelterinsurance.auction.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AuctionExpireCalc {


    public static int calculateSecondsLeft(String expireTimeStr) {
        if(expireTimeStr == null)
            return 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime expireTime = LocalDateTime.parse(expireTimeStr, formatter);
        long mins = LocalDateTime.now().until(expireTime, ChronoUnit.SECONDS);

        return (int) mins;
    }

}
