package com.kesou.sfcode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(a));
    }


    public static int maxArea(int[] height) {

        int i  = 0;
        int j = height.length-1;
        int res = 0;
        while (i<j){
            res = height[i]<height[j] ?
                    Math.max(res,(j - i) * height[i++]):
                    Math.max(res,(j - i) * height[i--]);   //(j - i) * height[i++]
        }
        return res;
        /*int max = 0;
        if (height == null) {
            return 0;
        }

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {

                if (height[i] * height[j] > max) {
                    max = height[i] * height[j];
                } else if (height[j] > height[i]) {
                    max = (j - i) * height[j];
                } else if (height[i] > height[j]) {
                    max = (j - i) * height[i];
                }

            }
        }
        return max;
    }*/
    }
}