package com.csg.demo.testThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class TestController {

    @Autowired
    @Qualifier("executorTask")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/test1")
    public void test1() throws InterruptedException {
        System.out.println("这是第一个controller");
        System.out.println(Thread.currentThread());
        int i = 0;
        while(true){
            System.out.println(i++);
            Thread.sleep(20000);
        }
    }

    @GetMapping("/test2")
    public void test2() throws InterruptedException {
        System.out.println("这是第二个controller");
        System.out.println(Thread.currentThread());
        int i = 0;
        while(true){
            System.out.println(i++);
            Thread.sleep(20000);
        }
    }

    @GetMapping("/test3")
    public void testInvoke() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.csg.demo.testThread.TestController");
        TestController testController = (TestController)aClass.newInstance();
        Method test4 = testController.getClass().getMethod("test4");
        test4.invoke(this);
        return;
    }

    public void test4(){
        System.out.println("----我通过反射调用-----");
    }


}
