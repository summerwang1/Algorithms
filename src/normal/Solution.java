package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Solution {
    public static void main(String[] args) {
//        int[] a = {1,2,3,4,5,7};
//        for (int i = 0; i < 10; i++) {
//            int [] s = new Solution(a).shuffle();
//            System.out.println("---------------");
//        }
//        int[] a1 = {1,1,3,2};
//        int[] a2 = {3,2};
//        int[] a3 = {3};
//        List<Integer> as = new Solution(a).twoOutOfThree(a1,a2,a3);
//        System.out.println(as);

    }

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null){
            return null;
        }
        int[] a = nums.clone();
        for (int i = 1; i < a.length; i++) {
            int j = random.nextInt(i+1);
            swap(a,i,j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j){
            a[i] ^= a[j];
            a[j] ^= a[i];
            a[i] ^= a[j];
        }
    }

    /**
     * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
     * 输出：[3,2]
     * 解释：至少在两个数组中出现的所有值为：
     * - 3 ，在全部三个数组中都出现过。
     * - 2 ，在数组 nums1 和 nums2 中出现过。
     * 示例 2：
     *
     * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
     * 输出：[2,3,1]
     * 解释：至少在两个数组中出现的所有值为：
     * - 2 ，在数组 nums2 和 nums3 中出现过。
     * - 3 ，在数组 nums1 和 nums2 中出现过。
     * - 1 ，在数组 nums1 和 nums3 中出现过。
     * 示例 3：
     *
     * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
     * 输出：[]
     * 解释：不存在至少在两个数组中出现的值。
     *
     *
     * 提示：
     *
     * 1 <= nums1.length, nums2.length, nums3.length <= 100
     * 1 <= nums1[i], nums2[j], nums3[k] <= 100
     */

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            map.put(i,1);
        }for (int i : nums2) {
            map.put(i,map.getOrDefault(i,0) | 2);
        }for (int i : nums3) {
            map.put(i,map.getOrDefault(i,0) | 4);
        }
        for (int i :map.keySet()){
            int v = map.get(i);
            if ((v & (v -1)) != 0){
                res.add(i);
            }
        }
        return res;
    }

}