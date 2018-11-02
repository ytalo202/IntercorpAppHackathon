package com.example.yoshino.intercorpapp;

public class Contact2 {

    private String Name;
    private String Phone;
    private int Photo;


    private int nOro;
    private int nPlata;
    private int nCobre;


    public Contact2() {
    }

    public Contact2(String name, String phone, int photo, int nOro, int nPlata, int nCobre) {
        Name = name;
        Phone = phone;
        Photo = photo;
        this.nOro = nOro;
        this.nPlata = nPlata;
        this.nCobre = nCobre;
    }


    public int getnOro() {
        return nOro;
    }

    public void setnOro(int nOro) {
        this.nOro = nOro;
    }

    public int getnPlata() {
        return nPlata;
    }

    public void setnPlata(int nPlata) {
        this.nPlata = nPlata;
    }

    public int getnCobre() {
        return nCobre;
    }

    public void setnCobre(int nCobre) {
        this.nCobre = nCobre;
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
