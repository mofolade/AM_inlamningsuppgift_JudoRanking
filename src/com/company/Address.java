package com.company;

public class Address {
    private String address;
    private Integer addressType = 1;//1: email, 2: Linkedin

    Address(String address, Integer addressType){
        this.address = address;
        this.addressType = addressType;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }
}
