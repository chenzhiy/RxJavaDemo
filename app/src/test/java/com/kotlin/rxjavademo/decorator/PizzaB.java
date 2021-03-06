package com.kotlin.rxjavademo.decorator;

/**
 *
 */
public class PizzaB extends Decorator {
    private  Pizza pizza;

    public PizzaB(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + "+ 牛肉";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20;
    }


}
