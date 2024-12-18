package com.myproject.zipcodelocator.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class AddressSearcher {
    private String jsonAddress;

    public String getAddress(String cep){
        String encodedCEP = URLEncoder.encode(cep,StandardCharsets.UTF_8);
        String uri = String.format("https://viacep.com.br/ws/%s/json/",encodedCEP);
        try(HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            this.jsonAddress = response.body();
        }catch (IOException | InterruptedException e){
            System.err.println("Error in the request process. Error message: " + e.getMessage());
        }
        return this.jsonAddress;
    }
}
