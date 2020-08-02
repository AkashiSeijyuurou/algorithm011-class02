//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 1020 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //1.子问题
        //2.状态矩阵 行为word1字符， 列为word 2字符，dp[i][j]为从word1的0-i子串到word20-j子串需要的最少步数
        //3.dp方程
        //if word1[i] == word2[j] dp[i][j] = dp[i - 1][j - 1];
        //else dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
        //time O(mn)
        //space O(mn)

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1]; //还有空字符串变换也要考虑，所以长度+1
        dp[0][0] = 0;

        for (int i = 1; i <= len1; i++) {
            dp[i][0] += dp[i - 1][0] + 1;

        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] += dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}

