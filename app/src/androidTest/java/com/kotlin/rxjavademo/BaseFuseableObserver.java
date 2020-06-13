package com.kotlin.rxjavademo;

public abstract class BaseFuseableObserver<T,R> implements Observer<T> {
    //观察者
    protected final Observer<R> actual;

    protected BaseFuseableObserver(Observer<R> actual) {
        this.actual = actual;
    }

    @Override
    public void onSubscribe() {
        actual.onSubscribe();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        actual.onError(e);
    }

    @Override
    public void onComplete() {
        actual.onComplete();
    }
}
