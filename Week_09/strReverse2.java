//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 87 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] charr = s.toCharArray();

        for (int i = 0; i < len; i = i + 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, len - 1);
            while (left < right) {
                char temp = charr[left];
                charr[left++] = charr[right];
                charr[right--] = temp;
            }
        }

        return String.valueOf(charr);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
