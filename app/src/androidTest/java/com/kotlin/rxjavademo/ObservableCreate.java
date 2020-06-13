package com.kotlin.rxjavademo;

public class ObservableCreate<T> extends Observable {
    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source){
        this.source = source;
    }

    @Override
    public void subscribe(Observer observer) {
        super.subscribe(observer);
    }

    //如果订阅功能要实现，在这里要通知Observer消息要更新
    @Override
    protected void subscribeActual(Observer observer) {

        CreateEmitter<T> parent = new CreateEmitter<>(observer);
        observer.onSubscribe();

        //把发送器和被观察者绑定在一起
        source.subscribe(parent);
    }

    static final class CreateEmitter<T> implements Emitter<T>{

        Observer<T> observer;

        public CreateEmitter(Observer<T> observer){
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);

        }

        @Override
        public void onError(Throwable e) {

            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();

        }
    }
}
