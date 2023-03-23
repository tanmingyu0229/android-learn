import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 两数之和算法 简单难度（leetcode no.1）
 */
public class TwoSumNumbers {

    public static void main(String[] args) {
        final  int[] nums = { 2, 7, 11, 15 };
        final int target = 13;
        
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // 输出 [0, 1]

    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }
    
}

