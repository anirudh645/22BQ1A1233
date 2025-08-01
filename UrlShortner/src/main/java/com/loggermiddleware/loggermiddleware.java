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
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJhbmlydWRoMjY4NDA5QGdtYWlsLmNvbSIsImV4cCI6MTc1NDAyNTgxNiwiaWF0IjoxNzU0MDI0OTE2LCJpc3MiOiJBZmZvcmQgTWVkaWNhbCBUZWNobm9sb2dpZXMgUHJpdmF0ZSBMaW1pdGVkIiwianRpIjoiNDYyNTIyOWItNzc3NC00MzZkLWFiNzktMjc0YWNmZmUzOGM3IiwibG9jYWxlIjoiZW4tSU4iLCJuYW1lIjoiY2h1bmR1cnUga2VzYXZhIG1vaGFuIGdhbmVzaCBhbmlydWRoIiwic3ViIjoiNDU0YjRiMjQtYWQ5Ny00Nzk4LTg1MTgtYTljMzFjMTYyMzcwIn0sImVtYWlsIjoiYW5pcnVkaDI2ODQwOUBnbWFpbC5jb20iLCJuYW1lIjoiY2h1bmR1cnUga2VzYXZhIG1vaGFuIGdhbmVzaCBhbmlydWRoIiwicm9sbE5vIjoiMjJicTFhMTIzMyIsImFjY2Vzc0NvZGUiOiJQblZCRlYiLCJjbGllbnRJRCI6IjQ1NGI0YjI0LWFkOTctNDc5OC04NTE4LWE5YzMxYzE2MjM3MCIsImNsaWVudFNlY3JldCI6IkNKanhITmt1Um5wUnp6a24ifQ.bdpdS80BxYTfZhAxUfFAco2Htxzp7Bz0hCicMllowCY")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: \n" + response.body());
    }
}