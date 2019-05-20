package com.ngocvt698.baitaplon;

public class Food {
    private String name;
    private String address;
    private String image;
    private int km;
    private int price;

    public Food() {
        name = "bun";
        address = "ha noi";
        image = "haha";
        km = 1;
        price = 15000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
