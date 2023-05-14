package com.example.ex00.dependency.qualifier;

public class Vips implements Restaurant {
    private int steack = Restaurant.steak - 5000;

    @Override
    public boolean isSalad() {
        return false;
    }
}
