package com.example;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;    

public class Main {

    final static String URL = "http://api.open-notify.org/iss-now.json"; // address of API Endpoint

    public static void main(String[] args) {

        // Ref: https://www.baeldung.com/java-9-http-client

        System.out.println("Making request to ISS API - please wait as response may take some time.....");
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder() // build an HTTP request
                    .uri(URI.create(URL))
                    .timeout(Duration.of(10, SECONDS))
                    .GET()
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Check the response code returned from the API endpoint
                // A code of 200 indicates success
                if (response.statusCode() == 200) {
                    // get the body (the data payload) from the HTTP response object
                    String jsonResponseString = response.body();
                    if (jsonResponseString != null) {
                        // convert JSON String into a JSONObject (root object)
                        JSONObject jsonObjectRoot = new JSONObject(jsonResponseString);

                        IssPosition IssPosition = new IssPosition();
                        IssPosition.setLatitude(jsonObjectRoot.getJSONObject("iss_position").getString("latitude"));
                        IssPosition.setLongitude(jsonObjectRoot.getJSONObject("iss_position").getString("longitude"));
                        IssPosition.setTimestamp(jsonObjectRoot.getLong("timestamp"));
                        IssPosition.setMessage(jsonObjectRoot.getString("message"));

                        System.out.println(IssPosition.toString());
                    } else {
                        System.out.println("Json String was empty.");
                    }
                } else {
                    System.out.println("HTTP Request failed - Status code returned = " + response.statusCode());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}