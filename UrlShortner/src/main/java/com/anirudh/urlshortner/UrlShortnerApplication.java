package com.anirudh.urlshortner;

import com.loggermiddleware.LogEntry;
import com.loggermiddleware.loggermiddleware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class UrlShortnerApplication {
    private static LogEntry logEntry = new LogEntry("Started Application","info","backend","com.anirudh.urlshortner");
    private static loggermiddleware logger = new loggermiddleware();
    public static void main(String[] args) throws IOException, InterruptedException {
        logger.log(logEntry);
        SpringApplication.run(UrlShortnerApplication.class, args);
    }

}
