package com.company;

import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException {

        int version = 2;


        int depth = 3;
        String link = "https://www.google.ru/";

        if(version == 1) {
            Crawler crawler = new Crawler(new URLDepth(link, 1, 1), depth );
        }
        else{
            URLPool pool = new URLPool(depth);
            pool.addPair(new URLDepth(link, 1));
            int numThread = 20;

            for (int m = 0; m < numThread; m++) {
                Thread thread = new Thread(new AsyncCrawler(pool));
                thread.start();
            }
        }
    }
}
