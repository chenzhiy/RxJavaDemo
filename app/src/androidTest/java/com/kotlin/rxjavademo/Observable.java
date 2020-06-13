package com.kotlin.rxjavademo;

//具体的被观察者
public abstract class Observable<T> implements ObservableSource {


    @Override
    public void subscribe(Observer observer) {
        //把这个订阅的功能让Observable的子类去完成
        subscribeActual(observer);
    }

    //
    protected abstract void subscribeActual(Observer<T> observer);

    //创造被观察者的实例
    public static<T> Observable<T> create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<T>(source);
    }

    //创建被观察者
    public<U> Observable<U> map(Function<T,U> function){
        return new ObservableMap<>(this,function);
    }
}
