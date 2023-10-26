package services;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    private HttpResponse<String> convert(BigDecimal value, String current, String convertTo) throws IOException, InterruptedException {
        String baseUrl = "https://api.frankfurter.app/latest?";
        String url = baseUrl + "amount=" + value + "&from=" + current + "&to=" + convertTo;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(18))
                .uri(URI.create(url))
                .build();

        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}
