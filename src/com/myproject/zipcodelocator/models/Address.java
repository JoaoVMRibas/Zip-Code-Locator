package com.myproject.zipcodelocator.models;

public class Address {
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private int ddd;

    public Address(AddressViaCEP addressViaCEP){
        this.cep = addressViaCEP.cep();
        this.street = addressViaCEP.logradouro();
        this.city = addressViaCEP.localidade();
        this.neighborhood = addressViaCEP.bairro();
        this.state = addressViaCEP.estado();
        this.ddd = addressViaCEP.ddd();
    }

    @Override
    public String toString() {
        return """
               Address data:
               CEP: %s
               Street: %s
               Neighborhood: %s
               City: %s
               State: %s
               DDD: %s
               """.formatted(cep,street,neighborhood,city,state,ddd);
    }
}
