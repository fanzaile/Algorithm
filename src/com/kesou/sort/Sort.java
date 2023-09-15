package com.kesou.sort;

import java.util.HashMap;
import java.util.Map;

public class Sort {
    public static void main(String[] args) {
        int[] a = {5, 6, 8, 7, 12, 3};
        //findKey(a, 12);
        int[] gem =  {3, 1, 2};
        int[][] operations = {{0, 2}, {2, 1}, {2, 0}};
        System.out.println(giveGem(gem,operations));


    }
    public static void findKey(int[] a, int value) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            map.put(i, a[i]);
        }
        int numb = 0;
        for (Integer getkey : map.keySet()) {
            if (map.get(getkey).equals(value)) {
                int index = getkey;
                System.out.println(index);
                numb++;
            }
        }
        if (numb == 0) {
            System.out.println(-1);
        }

    }


    public static int giveGem(int[] gem, int[][] operations) {
        int max = 0;
        int min = 9999;
        for (int i = 0; i < operations.length; i++) {
            int a = operations[i][0];
            int b = operations[i][1];
            int value = gem[a]/2;
            gem[a] -=gem[a]/2;
            gem[b] +=value;
        }
        for (int i = 0; i < gem.length; i++) {
            if (gem[i]>max){
                max = gem[i];

            }
            if (gem[i]<min){
                min = gem[i];
            }
        }
        return max-min;
    }
}

