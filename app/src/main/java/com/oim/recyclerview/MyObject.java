package com.oim.recyclerview;

import java.util.List;

public class MyObject {
    private String city;
    private String pays;
    private String numberOfLiving;
    private String imageUrl;
    public static List<MyObject> capitalsList;

    public MyObject(String city, String pays, String numberOfLiving, String imageUrl) {
        this.city = city;
        this.pays = pays;
        this.numberOfLiving = numberOfLiving;
        this.imageUrl = imageUrl;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumberOfLiving() {
        return numberOfLiving;
    }

    public void setNumberOfLiving(String numberOfLiving) {
        this.numberOfLiving = numberOfLiving;
    }

    public static List<MyObject> getCapitalsList() {
        return capitalsList;
    }

    public static void setCapitalsList(List<MyObject> capitalsList) {
        MyObject.capitalsList = capitalsList;
    }
}
