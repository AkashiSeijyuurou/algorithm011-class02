//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 494 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        //1.子问题
        //2.状态数组/矩阵  以(i, j)为右下角的正方形最大边长
        //3.dp方程  dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
        //time O(mn)
        //space O(mn)
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxEdge = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] - '0';
                maxEdge = Math.max(maxEdge, dp[i][j]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxEdge = Math.max(dp[i][j], maxEdge);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxEdge * maxEdge;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
