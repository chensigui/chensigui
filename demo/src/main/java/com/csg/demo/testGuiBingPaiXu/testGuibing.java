package com.csg.demo.testGuiBingPaiXu;

import com.alibaba.fastjson.JSON;

public class testGuibing {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 9, 11};
        int[] arr2 = {2, 3, 5, 6, 9, 10,12};
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] arr3 = new int[length1 + length2];
        //设置数组arr1下标
        int i = 0;
        //设置数组arr2下标
        int j = 0;
        //设置新数组arr3下标
        int k = 0;

        while (i < length1 && j < length2) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        //到这里的时候，新数组为{1,2,3,4,5,6,7,8,9,9,10,11}
        //数组1为{1, 4, 7, 8, 9, 11}
        //数组2为{2, 3, 5, 6, 9, 10,12}
        //数组1下标已经计算到5，数组2下标已经计算到5，数组2还剩下下标6，如何将下标6也就是12赋值到新数组的第13位上的0
        //如果i不等于数组1 arr1的长度，那么i肯定还剩下一部分数据，而arr2没有剩下的呢，这时候只需要将arr1剩下的拼到新数组最后面即可
        if (i != length1) {
            while (i < length1) {
                arr3[k] = arr1[i];
                k++;
                i++;
            }
        }
        if (j != length2) {
            while (j < length2) {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }

        System.out.println(JSON.toJSONString(arr3));
    }

}
