package com.learn.playground.rx.transformer;

public class Order {

    public static final String JSON_EXAMPLE = "{\"id\":\"123232\", \"total\":199.9}";

    private String id;

    private double total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
