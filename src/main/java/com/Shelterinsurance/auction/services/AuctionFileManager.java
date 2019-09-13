package com.Shelterinsurance.auction.services;

import java.io.*;

public class AuctionFileManager {

    private static final String PATH = "C:/auction/";


    public static File createAuctionDataIfNecessary() {
        final String FILENAME = "auction_data.json";
        return createFile(FILENAME);
    }

    public static File createBidHistoryIfNecessary() {
        final String FILENAME = "bid_history.json";
        return createFile(FILENAME);

    }

    private static File createFile(String fileName) {

        File file = new File(PATH.concat(fileName));

        try {
            if (file.createNewFile())
                System.out.println("File is created!");
        } catch (IOException e) {
            System.out.println(String.format("Failed to created Directory\nVerify %s is a created directory.", PATH));
        }

        return file;
    }


}
