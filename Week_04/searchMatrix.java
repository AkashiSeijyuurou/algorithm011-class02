//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 210 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分查找
        //time O(log n) n为元素个数
        //space O(n)  n为一行的个数
        if (matrix.length == 0) {
            return false;
        }
        int[] row = getRow(matrix, target);
        return findTarget(row, target);
    }

    private int[] getRow(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (top < bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][col] < target) {
                top = mid + 1;
            } else {
                bottom = mid;
            }
        }

        return matrix[top];
    }

    private boolean findTarget(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
