//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划 
// 👍 298 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        //1.子问题
        //2.dp[i][j] 为前i个元素被分为j段后的最大子数组之和的最小值
        //3.dp[i][j] 枚举前k个元素，被分为j - 1段，第k + 1个元素到i为第j段，从这j段中找最大值，在y与当前dp[i][j]获取最小值
        //dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
        //time O(m * len^2)
        //space O(m * len)
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len + 1][m + 1];

        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        int[] subSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            subSum[i + 1] = subSum[i] + nums[i];
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(m, i); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], subSum[i] - subSum[k]));
                }
            }
        }

        return dp[len][m];
    }
}
