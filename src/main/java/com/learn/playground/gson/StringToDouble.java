package com.learn.playground.gson;

import com.google.gson.Gson;

public class StringToDouble {

    public Gift parserGift(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Gift.class);
    }

    public GiftLongPrice parseGift(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, GiftLongPrice.class);
    }

    public static class Gift{
        private String name;

        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class GiftLongPrice{
        private String name;

        private long price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }
    }

}
