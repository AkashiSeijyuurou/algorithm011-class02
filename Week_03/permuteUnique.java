//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 345 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        /*HashSet<List<Integer>> hashSet = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        for (int num : nums) {
            cur.add(num);
        }

        int len = nums.length;
        helper(hashSet, cur, 0, len);

        return new ArrayList<>(hashSet);*/
        //time O(n * n!)
        //space O(n * n!)
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if (len == 0) {
            return ans;
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, ans, path, used, 0, len);

        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, Deque<Integer> path, boolean[] used, int depth, int length) {
        //递归终止条件
        if (depth == length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        //
        for (int i = 0; i < length; i++) {
            //当前层逻辑
            //剪枝
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            //探索下一层
            dfs(nums, ans, path, used, depth + 1, length);

            //恢复当前层
            used[i] = false;
            path.removeLast();
        }
    }

    /*public void helper(HashSet<List<Integer>> set, List<Integer> cur, int first, int length) {
        if (first == length && !set.contains(cur)) {
            set.add(new ArrayList<>(cur));
            return;
        }

        for (int i = first; i < length; i++) {
            Collections.swap(cur, first, i);
            helper(set, cur, first + 1, length);
            Collections.swap(cur, first, i);
        }

    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
