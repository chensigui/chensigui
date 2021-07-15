package com.csg.demo.testGuiBingPaiXu;

import com.alibaba.fastjson.JSON;

public class testGuibing2 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 9, 10, 11};
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] arr3 = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < length1 && j < length2){
            if (arr1[i]<=arr2[j]){
                arr3[k] = arr1[i];
                k++;
                i++;
            }else{
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }

        if(i != length1){
            while(i < length1){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
        if(j != length1){
            while(j < length2){
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }

        System.out.println(JSON.toJSONString(arr3));

    }

}
