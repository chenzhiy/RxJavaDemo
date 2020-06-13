package com.kotlin.rxjavademo;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.kotlin.rxjavademo", appContext.getPackageName());

        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("网络连接成功 + ");
            }
        }).map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return s + "数据库验证成功 + ";
            }
        }).map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return s + "文件系统验证成功 + ";
            }
        }).map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return s + "用户名密码正确 + ";
            }
        }).subscribe(new Observer(){

            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("可以登录！:" + (String)o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

}