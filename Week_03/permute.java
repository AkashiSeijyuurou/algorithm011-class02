//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 783 👎 0


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //time O(n * n!)
        //space O(n)
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int num : nums) {
            cur.add(num);
        }

        int len = nums.length;
        helper(ans, cur, 0, len);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> cur, int first, int len) {
        //递归终止
        if (first == len) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = first; i < len; i++) {
            //当前层逻辑
            Collections.swap(cur, first, i);
            
            //探索下一层
            helper(ans, cur, first + 1, len);
            
            //恢复当前层
            Collections.swap(cur, first, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
