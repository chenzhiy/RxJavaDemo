package com.kotlin.rxjavademo;

import java.util.ArrayList;
import java.util.List;

//具体的被观察者
public class WechatServer implements Observable{

    //观察者清单
    private List<Observer> list;
    //发送给用户的消息
    private String message;

    public WechatServer(){
        list = new ArrayList();
    }

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    //消息发布
    public void pushMessage(String msg){
        this.message = msg;
        System.out.println("微信服务号更新了一条消息："+ msg);

        //通知所有关注了本服务号的用户
        notifyObservers();
    }

    //消息通知
    @Override
    public void notifyObservers() {
        for (Observer observer : list) {
            observer.update(message);
        }
    }
}
