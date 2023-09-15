package com.kesou.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包容量
        int n = val.length;//物品个数


        //创建二维数组,表
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录商品放入情况，创建二维数组
        int[][] path = new int[n + 1][m + 1];
        //初始化第一行和第一列，在本程序中可以不去处理，因为默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置为0
        }
        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {//不处理第一行
            for (int j = 1; j < v[0].length; j++) {//不处理第一列
                //公式
                if (w[i - 1] > j) {//因为i从1开始，所以
                    v[i][j] = v[i - 1][j];
                } else {
                    //因为i是从1开始的
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能简单地使用公式，需要使用if-else来处理
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        //输出v，看看目前情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================");
        //输出我们最后放入哪些商品
        //遍历path,这样会冗余，我们只需要最后的放入情况
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.printf("第%d个商品放入到背包", i);
//                }
//            }
//        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {//从path的最后开始遍历
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包", i);
                j -= w[i - 1];//w[i-1]
            }
            i--;
        }
    }
}
