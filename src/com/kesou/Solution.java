package com.kesou;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] num2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if ( nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length ==1){
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
}