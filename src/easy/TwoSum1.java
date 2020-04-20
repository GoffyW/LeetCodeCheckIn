package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GoffyGUO
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSum(nums, target));
    }
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /*暴力法*/

    /**
     * 遍历每一个元素x,并查找是否存在一个值与target-x值相等的目标元素
     *
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No");
    }

    /*两遍hash法*/

    /**
     * 第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，
     * 我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No");
    }
}
