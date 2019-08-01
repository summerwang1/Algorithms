package easy;

/**
 * Created on 2019-06-12.
 *
 * @author： sarWang
 * @description：两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumAdd {
    public static void main(String[] strs){
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] ret = twoSum(nums,target);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            int del = target - nums[j];
            if (nums[i] == del){
                re[1] = i;
                break;
            }
            if (i == nums.length-1 && re[1] == 0){
                j++;
                i = j;
            }
        }
        re[0] = j;
        return re;
    }
}
