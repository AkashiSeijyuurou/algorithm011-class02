//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 39 👎 0


import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import sun.misc.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
//堆解法
//time O(1)
//space 常数空间存储 1690 个丑数，和堆中不超过 1690×2 的元素和哈希表中不超过 1690×3 的元素
class Ugly {
    public int[] nums = new int[1690];

    public Ugly() {
        Set<Long> seen = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();
        ((HashSet) seen).add(1L);
        ((PriorityQueue) heap).add(1L);

        long curUgly;
        long newUgly;

        int[] prime = new int[]{2, 3, 5};

        for (int i = 0; i < 1690; i++) {
            curUgly = heap.poll();
            nums[i] = (int)curUgly;

            for (int j : prime) {
                newUgly = curUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}
class Solution {
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.nums[n - 1];
		
		
		//动态规划
		//time  O(n)
		//space O(n)
        /*int a = 0;
        int b = 0;
        int c = 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int aNum = dp[a] * 2;
            int bNum = dp[b] * 3;
            int cNum = dp[c] * 5;

            dp[i] = Math.min(Math.min(aNum, bNum), cNum);

            if (dp[i] == aNum) {
                a++;
            }
            if (dp[i] == bNum) {
                b++;
            }
            if (dp[i] == cNum) {
                c++;
            }
        }

        return dp[n - 1];*/
    }
}

