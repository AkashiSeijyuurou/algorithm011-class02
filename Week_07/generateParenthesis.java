//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1221 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //回溯法，剪枝
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, "", ans);
        return ans;
    }

    public void generate(int left, int right, int nums, String s, List<String> list){
        if (left == nums && right == nums) {
            list.add(s);
        }

        if (left < nums) {
            generate(left + 1, right, nums, s + "(", list);
        }

        if (right < left) {
            generate(left, right + 1, nums, s + ")", list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
