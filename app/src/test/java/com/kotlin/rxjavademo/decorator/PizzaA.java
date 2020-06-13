package com.kotlin.rxjavademo.decorator;

/**
 *
 */
public class PizzaA extends Decorator {
    private  Pizza pizza;

    public PizzaA(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + "+ 菠萝";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }


}
