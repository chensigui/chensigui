package com.csg.demo.testTreeSet;

import com.alibaba.fastjson.JSON;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");
        System.out.println(JSON.toJSONString(set));
    }

}
