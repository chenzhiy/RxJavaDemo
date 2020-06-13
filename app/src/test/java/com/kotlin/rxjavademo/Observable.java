package com.kotlin.rxjavademo;

//抽象被观察者
public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    //通知观察者，消息已经发出来
    void notifyObservers();
}
