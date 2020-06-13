package com.kotlin.rxjavademo;

public abstract class AbstractObservableWithUpstream<T,R> extends Observable<R>  {

    protected final ObservableSource<T> source;

    protected AbstractObservableWithUpstream(ObservableSource<T> source) {
        this.source = source;
    }


}
