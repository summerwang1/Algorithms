package easy;

import model.TreeNode;

import java.util.*;

/**
 * 排序
 *
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {2,1,0};
        int[] b = {2,1,0};
//        System.out.println("----" + new Sort().validateStackSequences(a,b));
        System.out.println(new Sort().maximumSwap(9927));
        ;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        TreeNode prev = null,cur = root;
        while (cur != null && cur.val > val){
            prev = cur;
            cur = cur.right;
        }
        if (prev == null){
            insert.left = cur;
            return insert;
        } else {
            prev.right = insert;
            insert.left = cur;
            return root;
        }
    }

    /**
     * ：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * 判断（popped）是不是（pushed）的循环就可以
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> dF = new ArrayDeque<>();
        for (int i = 0, j = 0; i < popped.length; i++) {
            dF.addLast(pushed[i]);
            while (!dF.isEmpty() && dF.peekLast() == popped[j] && ++j >= 0) dF.pollLast();
        }

        return dF.isEmpty();
    }
    public String reorderSpaces(String text) {
        int n = text.length(), cnt = 0; // 空格个数
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (text.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && text.charAt(j) != ' ') j++;
            list.add(text.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) k += " ";
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();

    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * --1。排序，从中值找2。一个数找另外两个3，暴力查找
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 枚举第一个值
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int right = n - 1;
            int target = -nums[i];
            // 降级为两数之和，目标数targt
            for (int j = i + 1; j < n; ++j) {
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (j < right && nums[j] + nums[right] > target) {
                    --right;
                }

                if (j == right){
                    break;
                }

                if (nums[j] + nums[right] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[right]);
                    res.add(list);

                }

            }

        }
        return res;
    }

    /**
     * int[] ans = new int[n];
     *         int i = 0;
     *         //p从小到大 q从大到小
     *         int p = 1, q = n;
     *         //构造前k个数组 k-1个不同的整数
     *         //奇数位从大到小，偶数位从小到大
     *         for (int j = 0; j < k; j++) {
     *             if (j % 2 == 0) {
     *                 ans[i++] = p++;
     *             } else {
     *                 ans[i++] = q--;
     *             }
     *         }
     *         //构造剩下的绝对值为1的序列
     *         if (k % 2 == 0) {
     *             //偶数时，降序
     *             while (i < n) {
     *                 ans[i++] = q--;
     *             }
     *         } else {
     *             //奇数时，升序
     *             while (i < n) {
     *                 ans[i++] = p++;
     *             }
     *         }
     *         return ans;
     *

     * @param n
     * @param k
     * @return
     */
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String s1 = String.valueOf(s);
            if (!map.containsKey(s1)){
                map.put(s1,new ArrayList<>());
            }
            map.get(s1).add(str);
        }
        return new ArrayList<>(map.values());
    }
//    给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
//    示例 1 :

//    输入: 2736
//    输出: 7236
//    解释: 交换数字2和数字7。

//    List<Integer> list = new ArrayList<>();
//        while (num != 0) {
//        list.add(num % 10); num /= 10;
//    }
//    int n = list.size(), ans = 0;
//    int[] idx = new int[n];
//        for (int i = 0, j = 0; i < n; i++) {
//        if (list.get(i) > list.get(j)) j = i;
//        idx[i] = j;
//    }
//        for (int i = n - 1; i >= 0; i--) {
//        if (list.get(idx[i]) != list.get(i)) {
//            int c = list.get(idx[i]);
//            list.set(idx[i], list.get(i));
//            list.set(i, c);
//            break;
//        }
//    }
//        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + list.get(i);
//        return ans;
//
//    作者：AC_OIer
//    链接：https://leetcode.cn/problems/maximum-swap/solution/by-ac_oier-jxmh/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//  9927
//
    public int maximumSwap(int num) {
        List<Integer> list= new ArrayList<>();
        while(num != 0){
            list.add(num % 10);
            num /= 10;
        }
        int n = list.size(),ans = 0;
        int[] idx = new int[n];
        for (int i = 0,j=0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }
        for (int i = n -1; i >= 0 ; i--) {
            if (list.get(idx[i]) != list.get(i)){
                int c = list.get(idx[i]);
                list.set(idx[i],list.get(i));
                list.set(i,c);
                break;
            }
        }
        for (int i = n -1; i >= 0 ; i--) {
            ans = ans * 10 + list.get(i);
        }
        return ans;
    }

}
