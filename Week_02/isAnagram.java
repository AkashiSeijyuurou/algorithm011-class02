//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 210 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        /*if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0) + 1);
        }

        if (!sMap.isEmpty() && sMap.equals(tMap)) {
            return true;
        } else {
            return false;
        }*/
		//哈希表原理，数组下标为小写字母索引，元素为频次
        //time O(n)
        //space O(1)
        if (s.length() != t.length()) {
            return false;
        }

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
            if (map[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }
}