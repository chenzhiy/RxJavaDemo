package com.kotlin.rxjavademo.decorator;

public class Decorator extends Pizza {
    @Override
    public double getPrice() {
        return this.getPrice();
    }

    public void show(){
        System.out.println(getName() + "  " + getPrice());
    }

}
