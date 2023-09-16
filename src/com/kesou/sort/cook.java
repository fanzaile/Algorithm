/*package com.kesou.sort;

public class cook {
    int maxAns;

    public static void main(String[] args) {
        int[] materials = {3, 2, 4, 1, 2};
        int[][] cookbooks = {{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}};
        int[][] attribute = {{3, 2}, {2, 4}, {7, 6}};
        int limit = 5;



    }


    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.maxAns = -1;
        boolean[] exists = new boolean[cookbooks.length];

        dfs(materials,cookbooks,attribute,limit,0,0);
        return this.maxAns;
    }


    public void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] exists, int sumx, int sumy) {
        if (sumy>=limit) this.maxAns = Math.max(maxAns,sumx);
        int len = cookbooks.length;
        for (int i = 0; i < len; i++) {
//            第i道料理 如果已经做了那就不做
            if (exists[i]) continue;
//            检查有没有材料可以做下一道
            int[] need = cookbooks[i];
            boolean can = true;
            for (int j = 0; j < need.length; j++) {
                if (materials[j]<need[j]){
                    can = false;
                    break;
                }
            }
            if (can){
                exists[i] = true;
                for (int j = 0; j < need.length; j++) {
                    materials[j]-=need[j];
                }
                dfs(materials,cookbooks,attribute,limit,exists,sumx+attribute[i][0],sumy+attribute[i][1]);
                for (int j = 0; j < need.length; j++) {
                    materials[j] +=need[j];
                }
                exists[i] = false;
            }
        }
    }
}


*/
