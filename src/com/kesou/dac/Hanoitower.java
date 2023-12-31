package com.kesou.dac;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(10,'A','B','C');

    }

    //汉诺塔移动方法
    //使用分治方法
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果我们有n >= 2情况，我们总是可以看做是两个盘1.最下边的盘2.上面的盘
            //1.先把 最上面的盘A->B,移动过程会用的c
            hanoiTower(num - 1, a, c, b);
            //2.把最下边的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3.把B塔所有的盘从B->C 移动过程使用A塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
