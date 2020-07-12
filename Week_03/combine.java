//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 310 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //time O(k Cnk)
    //space O(Cnk)  Cnk 组合数
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(),1, n, k);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> mid, int first, int n, int k) {
        //终止条件
        if (mid.size() == k) {
            //ans.add(mid);
            ans.add(new ArrayList<>(mid));
            return;
        }

        //当前层逻辑
        for (int i = first; i <= n; i++) {
            mid.add(i);

            //探索下一层
            helper(ans, mid, i + 1, n, k);

            //恢复当前层
            mid.remove(mid.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
