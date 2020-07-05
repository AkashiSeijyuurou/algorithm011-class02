//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 383 👎 0



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //使用哈希表存储排序后的字符串当作key，并将后续字符串根据排序后的key分组
        //time O(n*klog k)   n为strs长度， k为最大字符串长度
        //space O(n*k)
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> ans = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
    }
}

