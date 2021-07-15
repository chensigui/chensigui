package com.csg.demo.testThreadLocal;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class testThreadLocal {

    static ThreadLocal<ThreadUser> userThreadLocal = new ThreadLocal<>();

    /***
     * 测试在一个线程中，多个方法间传递同一对象
     * @param args
     */
    public static void main(String[] args) {
        try{
            new Thread(() ->{
                ThreadUser user = new ThreadUser();
                user.setCode(1);
                user.setName("刘林");
                userThreadLocal.set(user);
                changeUser1();
                changeUser2();
                changeUser3();
            }).start();
            new Thread(() ->{
                ThreadUser user = new ThreadUser();
                user.setCode(1);
                user.setName("刘林");
                userThreadLocal.set(user);
                changeUser1();
                changeUser2();
                changeUser3();
            }).start();
            log.info("----主线程结束,{}",Thread.currentThread());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userThreadLocal.remove();
        }
    }

    private static void changeUser3() {
        log.info("-----------执行方法3-------");
        log.info("-----------当前线程号,{}",Thread.currentThread());
        ThreadUser threadUser = userThreadLocal.get();
        log.info("-----------当前ThreadUser,{}", JSON.toJSONString(threadUser));
        threadUser.setName("333");
        threadUser.setCode(333);
        log.info("---方法3,{}---",threadUser);
    }

    private static void changeUser2() {
        log.info("-----------执行方法2-------");
        log.info("-----------当前线程号,{}",Thread.currentThread());
        ThreadUser threadUser = userThreadLocal.get();
        log.info("-----------当前ThreadUser,{}", JSON.toJSONString(threadUser));
//        threadUser.setName("222");
//        threadUser.setCode(222);
        log.info("---方法2,{}---",threadUser);
    }

    private static void changeUser1() {
        log.info("-----------执行方法1-------");
        log.info("-----------当前线程号,{}",Thread.currentThread());
        ThreadUser threadUser = userThreadLocal.get();
        log.info("-----------当前ThreadUser,{}", JSON.toJSONString(threadUser));
        threadUser.setName("111");
        threadUser.setCode(111);
        log.info("---方法1,{}---",threadUser);
    }

}
