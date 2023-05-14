package com.example.ex00.dependency.qualifier;

public class Outback implements Restaurant {
    public int steak = Restaurant.steak - 9000;

    @Override
    public boolean isSalad() {
        return false;
    }
}
