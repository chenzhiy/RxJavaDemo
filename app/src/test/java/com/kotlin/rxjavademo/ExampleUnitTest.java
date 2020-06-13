package com.kotlin.rxjavademo;

import com.kotlin.rxjavademo.decorator.BasePizza;
import com.kotlin.rxjavademo.decorator.Pizza;
import com.kotlin.rxjavademo.decorator.PizzaA;
import com.kotlin.rxjavademo.decorator.PizzaB;
import com.kotlin.rxjavademo.decorator.PizzaC;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void pizzaTest(){
        Pizza x = new BasePizza();
        PizzaA p = new PizzaA(new PizzaB(new PizzaC(x)));
        p.show();
    }

    @Test
    public void client(){
        Observable server = new WechatServer();

        //创建用户（观察者）
        Observer jett = new User("jett");
        Observer av = new User("av");
        Observer lance = new User("lance");
        Observer leo = new User("leo");

        //订阅
        server.add(jett);
        server.add(av);
        server.add(lance);
        server.add(leo);

        ((WechatServer)server).pushMessage("大家好！！！");
    }
}