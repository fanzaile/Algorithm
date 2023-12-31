package com.kesou;

public class Solution {
    int[][] memo;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] num2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        System.out.println(twoEggDrop(100));
        String s = "leeetcode";
        System.out.println(makeFancyString(s));

    }

    //动态规划解决打家劫舍问题
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        /*int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];*/
//        改良
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;

       /* int value1 = 0;//统计从0开始
        int value2 = 0;//统计从1开始
        int max = 0;
        boolean type = nums.length % 2 == 0; //判断该数组的总数是奇数还是偶数 如果是奇数则为true
        if (!type) {

            for (int i = 0; i < nums.length; i += 2) {
                value1 += nums[i];
            }
            for (int i = 1; i < nums.length; i += 2) {
                value2 += nums[i];
            }
            max=value1>value2?value1:value2;
        }
        if (type) {
            for (int i = 0; i < nums.length - 1; i += 2) {
                value1 += nums[i];
            }
            for (int i = 1; i < nums.length; i += 2) {
                value2 += nums[i];
            }
            max=value1>value2?value1:value2;
        }
        return max;此方法不能判断头尾相加的情况[2,1,1,2]

*/


    }

    //    动态规划解决鸡蛋掉落
    public static int twoEggDrop(int n) {
        int[][] dp = new int[n + 1][3];
        for (int j = 1; j <= 2; j++) {
            dp[1][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][2] = Integer.MAX_VALUE;
            for (int p = 1; p <= i; p++) {
                int curr = Math.max(dp[p - 1][1], dp[i - p][2]) + 1;
                dp[i][2] = Math.min(dp[i][2], curr);
            }
        }
        return dp[n][2];
    }

    // 删除连续三个出现的字母
    public static String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c : chars) {
            if (builder.length() > 0 && builder.charAt(builder.length() - 1) == c) {
                count++;
            } else
                count = 1;
            if (count < 3) {
                builder.append(c);
            }
        }
        return builder.toString();

    }

    //    贪心算法解决三元组问题
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean one = false, two = false, three = false;
        for (int i = 0; i < triplets.length; i++) {
            if (target[0] == triplets[i][0] && target[1] >= triplets[i][1] && target[2] >= triplets[i][2]) {
                one = true;
            }
            if (target[0] >= triplets[i][0] && target[1] == triplets[i][1] && target[2] >= triplets[i][2]) {
                two = true;
            }
            if (target[0] >= triplets[i][0] && target[1] >= triplets[i][1] && target[2] == triplets[i][2]) {
                three = true;
            }
        }
        if (one && two && three) {
            return true;
        }
        return false;
    }

    public int maxProductDifference(int[] nums) {
        int[] max = new int[2];
        int[] min = new int[2];
        min[1] = max[0] = Math.max(nums[0], nums[1]);
        max[1] = min[0] = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max[0]) {
                max[1] = max[0];
                max[0] = nums[i];
            } else if (nums[i] > max[1]) max[1] = nums[i];
            if (nums[i] < min[0]) {
                min[1] = min[0];
                min[0] = nums[i];
            } else if (nums[i] < min[1]) min[1] = nums[i];
        }
        return max[0] * max[1] - min[0] * min[1];
    }

}
