//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 453 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        //1.子问题
        //2.状态数组  dp[i] str(0 - i)的解码方法总数
        //3.dp方程
        //（1）dp[i] = dp[i - 2] 当str[i] == '0' str[i] == '1' or '2'
        //(2)dp[i] = dp[i - 1] + dp[i - 2] 当str[i - 1] == '1'  or str[i - 1] == '2' && str[i] == '1' - '6'
        //time = O(n);
        //space = O(n);
        int len = s.length();

        if (len == 0) {
            return 0;
        }

//        if (len == 1 && s.charAt(0) != '0') {
//            return 1;
////        }

        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (s.charAt(0) == '0') {
            return 0;
        }

        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1'|| s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                }
            } else if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
