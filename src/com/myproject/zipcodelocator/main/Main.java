package com.myproject.zipcodelocator.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myproject.zipcodelocator.api.AddressSearcher;
import com.myproject.zipcodelocator.models.Address;
import com.myproject.zipcodelocator.models.AddressViaCEP;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressSearcher addressSearcher = new AddressSearcher();
        AddressViaCEP addressViaCEP;
        Address address;
        String jsonAddress;
        Scanner scanner = new Scanner(System.in);
        String cep;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println("Enter the zip code of the address you want to search for:");
        cep = scanner.nextLine();

        jsonAddress = addressSearcher.getAddress(cep);
        addressViaCEP = gson.fromJson(jsonAddress,AddressViaCEP.class);
        address = new Address(addressViaCEP);
        System.out.println(address);

        try(FileWriter writer = new FileWriter("Address.json")){
            writer.write(jsonAddress);
        }catch (IOException e){
            System.err.println("Error writing file. Error message: " + e.getMessage());
        }
    }
}