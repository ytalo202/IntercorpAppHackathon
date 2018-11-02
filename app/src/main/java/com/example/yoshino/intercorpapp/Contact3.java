package com.example.yoshino.intercorpapp;

public class Contact3 {

    private String Name;
    private String Phone;
    private int Photo;

    public Contact3() {
    }

    public Contact3(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
