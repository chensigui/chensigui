package com.csg.demo.testDP.testSingleTon;

import com.csg.demo.testDP.testSingleTon.Singleton;

public class testSingleton {

    //测试单例模式，这是懒汉式单例
    public static Singleton singleton = null ;

    public static Singleton test(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton test = test();
        System.out.println(test);
    }

}
