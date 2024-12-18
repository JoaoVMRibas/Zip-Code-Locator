package com.myproject.zipcodelocator.models;

public record AddressViaCEP(String cep, String logradouro, String bairro, String localidade, String estado, int ddd) {
}
