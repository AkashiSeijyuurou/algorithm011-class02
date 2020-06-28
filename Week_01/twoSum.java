//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;
import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //哈希表存储nums和其下标
        //将nums[i] + nums[j] = target转化为寻找target - nums[i]
		//time O(n)
		//space O(n)
        HashMap<Integer, Integer> hashMap= new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int other = target - nums[i];

            if (hashMap.containsKey(other) && hashMap.get(other) != i) {
                return new int[]{i, hashMap.get(other)};
            }
        }

        throw new IllegalArgumentException("No result");


    }
}