//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 605 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        //1.子问题 grid的最小路径和是右边格子和下边格子的最小路径和之间的最小值
        //2.状态数组 grid[i][j]  从终点遍历，以（i, j）为起点到终点的最小路径和
        //3.dp方程 grid[i][j] += min(grid[i + 1][j], grid[i][j]);
        //time O(mn)
        //space O(1)
        
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        for (int i = m - 2; i >= 0; i--) {
            grid[i][n - 1] += grid[i + 1][n - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            grid[m - 1][i] += grid[m - 1][i + 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
    }
}
