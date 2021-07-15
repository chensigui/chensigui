package com.csg.demo.testAnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        TestRun testRun = new TestRun();
        testRun.run();
        Class aClass = Class.forName("com.csg.demo.testAnotation.TestRun");
        Method[] methods = aClass.getMethods();
        for (Method m:methods){
            if (m.isAnnotationPresent(TestAnnotaion.class)){
                System.out.println("该方法上有注解");
                TestAnnotaion annotation = (TestAnnotaion)aClass.getAnnotation(TestAnnotaion.class);
                System.out.println("执行注解");
            }
        }
//        if(aClass.isAnnotationPresent(TestAnnotaion.class)){
//            System.out.println("该类有注解");
//            TestAnnotaion annotation = (TestAnnotaion)aClass.getAnnotation(TestAnnotaion.class);
//            System.out.println("执行注解");
//        }
    }

}
