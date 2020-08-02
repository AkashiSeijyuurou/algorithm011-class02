//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划 
// 👍 290 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        //1.子问题 回文串从中间扩散，若中间子串为回文串，则在其两边加上相同字符也为回文子串
        //2.状态矩阵，i为开始位置，j为结束位置 dp[i][j]为str[i, j]是否为回文子串
        //3.dp方程 s[i] == s[j] && (dp[i + 1][j - 1] || j - i < 2) dp[i][j] = true
        //time O(n^2)
        //space O(n^2)
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        int count = 0;

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
