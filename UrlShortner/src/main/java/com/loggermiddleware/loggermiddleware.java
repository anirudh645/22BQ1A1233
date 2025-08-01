package com.loggermiddleware;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class loggermiddleware {

    public static void log(LogEntry log1) throws IOException, InterruptedException {
        
        String jsonBody = "{"
            + "\"stack\": \"" + log1.getStack() + "\","
            + "\"level\": \"" + log1.getLevel() + "\","
            + "\"package\": \"" + log1.getPackage1() + "\","
            + "\"message\": \"" + log1.getMessage() + "\""
            + "}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://20.244.56.144/evaluation-service/logs")) // Replace with your actual endpoint
                .header("Content-Type", "application/json") // Essential header
                .header("Authorization","Bearer ")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: \n" + response.body());
    }
}
