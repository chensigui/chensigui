package com.csg.demo.testString;

public class testString {

    public static void main(String[] args) {
        int num = 100000;
        addTime(num);
        concatTime(num);
        stringBufferTime(num);
        stringBuilderTime(num);
    }

    /***
     * 测试String的+拼接字符串
     * @param num
     */
    public static void addTime(int num) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < num; i++) {
            str += i;
        }
        System.out.println("字符串拼接使用 + 耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    /***
     * 测试String的concat拼接字符串
     * @param num
     */
    public static void concatTime(int num) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < num; i++) {
            str.concat(String.valueOf(i));
        }
        System.out.println("字符串拼接使用 concat 耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    /***
     * 测试StringBuffer拼接字符串
     * @param num
     */
    public static void stringBufferTime(int num) {
        long start = System.currentTimeMillis();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < num; i++) {
            str.append(String.valueOf(i));
        }
        System.out.println("字符串拼接使用 StringBuffer 耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    /***
     * 测试StringBuilder拼接字符串
     * @param num
     */
    public static void stringBuilderTime(int num) {
        long start = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num; i++) {
            str.append(String.valueOf(i));
        }
        System.out.println("字符串拼接使用 StringBuilder 耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
