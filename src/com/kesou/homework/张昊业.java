package com.kesou.homework;

import java.util.Scanner;

public class 张昊业 {
    public static void main(String[] args) {
        /*System.out.println("请输入你的分数");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if (i < 100 && i >= 90) {
            System.out.println("优秀");
        } else if (i <= 89 && i >= 80) {
            System.out.println("不错");
        } else if (i <= 79 && i >= 70) {
            System.out.println("还行");
        } else if (i <= 69 && i >= 60) {
            System.out.println("及格");
        } else if (i < 60) {
            System.out.println("你是班级里潜力最大的学生之一");
        } else {
            System.out.println("分数有误");
        }*/
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i > j) {
                    System.out.printf("%d*%d=%d\t", i, j, i * j);
                    System.out.printf("\t");
                } else if (i == j) {
                    System.out.printf("%d*%d=%d\t", i, j, i * j);
                    System.out.println();
                }
            }
        }
    }
}
