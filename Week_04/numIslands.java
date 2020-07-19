//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 661 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int row;
    private int col;
    public int numIslands(char[][] grid) {
        //dfs
        //time O(row * col)
        //time O(1)
        row = grid.length;

        if (row == 0) {
            return 0;
        }

        col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    solve(grid, i, j);
                }
            }
        }

        return count;
    }

    public void solve(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '0';
        solve(grid, x + 1, y);
        solve(grid, x, y + 1);
        solve(grid, x - 1, y);
        solve(grid, x, y - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
