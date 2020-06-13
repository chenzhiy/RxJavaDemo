package com.kotlin.rxjavademo;


//具体观察者
public class User implements Observer{

    private String name;
    private String message;
    public User(String name){
        this.name = name;
    }


    @Override
    public void update(Object msg) {
        this.message = (String)msg;
        read();
    }

    void read(){
        System.out.println(name + "收到了推送消息" + message);
    }
}
