//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 875 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        //1.子问题:左右括号匹配，并获得有效括号的字符串长度
        //2.状态数组：dp[i] 为 以i为终点的有效括号长度
        //3.dp方程
        //if s[i] == '(' dp[i] = 0
        //if s[i] == ')' if s[i - 1] == '(' dp[i] = dp[i - 2] + 2;
        //if s[i] == ')' if s[i - 1] == ')' && s[i - dp[i - 1] - 1] == '(' dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
        //time O(n)
        //space O(n)
        int len = s.length();

        int[] dp = new int[len];

        int ans = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }

            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}

