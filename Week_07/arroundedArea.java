//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 273 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    public int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    public int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    public boolean isConnected (int node1, int node2) {
        return find(node1) == find(node2);
    }
}
class Solution {
    //并查集
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(i * cols + j, dummyNode);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union(i * cols + j, (i - 1) * cols + j);
                        }

                        if (i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.union(i * cols + j, (i + 1) * cols + j);
                        }

                        if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(i * cols + j, i * cols + (j - 1));
                        }

                        if (j < cols - 1 && board[i][j + 1] == 'O') {
                            uf.union(i * cols + j, i * cols + (j + 1));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!uf.isConnected(i * cols + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
