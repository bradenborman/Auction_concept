package com.Shelterinsurance.auction.services;

import java.io.*;

public class AuctionFileManager {


    public static File createIfNecessary() {

        final String PATH = "C:/auction/";
        final String FILENAME = "auction_data.json";

        File file = new File(PATH.concat(FILENAME));

        try {
            if (file.createNewFile())
                System.out.println("File is created!");
        } catch (IOException e) { System.out.println(String.format("Failed to created Directory\nVerify %s is a created directory.", PATH)); }

        return file;

    }

}
