package com.kotlin.rxjavademo;


//定义发送消息的API
public interface Emitter<T> {
    //发送消息
    void onNext(T t);

    //发送异常
    void onError(Throwable e);

    //发送完成的信号
    void onComplete();
}
