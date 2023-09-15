package com.kesou.homework;

public class Car {
    private String make;
    private String model;
    private int year;
    private boolean isRunning;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRunning = false;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        isRunning = true;
        System.out.println("汽车已启动。");
    }

    public void stop() {
        isRunning = false;
        System.out.println("汽车已停止。");
    }
}

