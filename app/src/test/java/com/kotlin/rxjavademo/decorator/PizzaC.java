package com.kotlin.rxjavademo.decorator;

/**
 *
 */
public class PizzaC extends Decorator {
    private  Pizza pizza;

    public PizzaC(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + "+ 猪肉";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 30;
    }


}
