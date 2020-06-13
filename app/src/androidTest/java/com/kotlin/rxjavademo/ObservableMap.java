package com.kotlin.rxjavademo;

public class ObservableMap<T,U> extends AbstractObservableWithUpstream<T,U> {

    final Function<T,U> function;

    public ObservableMap(ObservableSource<T> source,Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        source.subscribe(new MapObserver<>(observer,function));
    }

    static final class MapObserver<T,U> extends BaseFuseableObserver<T,U>{

        final  Function<T,U> mapper;
        protected MapObserver(Observer<U> actual, Function<T, U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            U apply = mapper.apply(t);
            actual.onNext(apply);
        }
    }
}
