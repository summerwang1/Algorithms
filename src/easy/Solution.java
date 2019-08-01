package easy;

import com.google.gson.Gson;
import model.ListNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 2019-06-19.
 *
 * @author： sarWang
 * @description：
 */
public class Solution {
    /**
     *
     * @param nums
     * @param target
     * @return给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    /**
     *
     * @param n
     * @return
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     *
     * 输入: 4
     * 输出: "1211"
     */
    public String countAndSay(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('1');
        for (int i = 1; i < n; i++) {
            String append = stringBuffer.toString();
            stringBuffer = new StringBuffer();
            char[] chars = append.toCharArray();
            int beagin = 0;
            for (int j = 0; j < append.length(); j++) {
                if (chars[beagin] == chars[j]){
                    if (j == append.length()-1){
                        stringBuffer.append(j - beagin + 1);
                        stringBuffer.append(chars[beagin]);
                        beagin = j;
                    }
                    continue;
                }else{
                    stringBuffer.append(j - beagin);
                    stringBuffer.append(chars[beagin]);
                    beagin = j;
                    j--;
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     *
     * @param nums
     * @return
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * 🌟🌟🌟🌟🌟
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }
    public int lengthOfLastWord(String s) {
        //从后往前找，遇到不是空格的开始计数，，，遇到空格结束，或者遍历完
        int a = 0;//位数

        for (int i = s.length()-1; i >= 0 ; i--) {
            if (s.charAt(i) != ' '){
                a++;
            }else{
                if (a>0) return a;
            }
        }
        return a;
    }
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

 */
    public int[] plusOne(int[] digits) {
        int a = digits.length -1;
        while (true){
            if (a < 0){
                //数组长度需要改变
                int[] ints = new int[digits.length + 1];
                ints[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    ints[i+1] = digits[i];
                }
                return ints;
            }
            if (digits[a] + 1 > 9 ){
                digits[a] = 0;
                a--;
                continue;
            }else{
                digits[a] = digits[a] + 1;
                return digits;
            }

        }
    }
    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     *
     *     输入为非空字符串且只包含数字 1 和 0。
     *
     *     示例 1:
     *
     *     输入: a = "11", b = "1"
     *     输出: "100"
     *     示例 2:
     *
     *     输入: a = "1010", b = "1011"
     *     输出: "10101"
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuffer = new StringBuilder();
        int ai = a.length()-1;
        int bi = b.length()-1;
        int go = 0; //进制
        while (true){
            if (ai < 0 && bi < 0 && go == 0){
                return stringBuffer.reverse().toString();
            }
            char ac;
            char bc;
            if (ai < 0){
                ac = '0';
            }else{
                ac = a.charAt(ai);
            }
            if (bi < 0){
                bc = '0';
            }else{
                bc = b.charAt(bi);
            }

            int ac2i = Integer.valueOf(ac) - 48;
            int bc2i = Integer.valueOf(bc) - 48;
            stringBuffer.append((ac2i + bc2i + go) %2);
            if ((ac2i + bc2i + go) > 1){
                go = 1;
            }else{
                go = 0;
            }
            ai--;
            bi--;
        }
    }

    /**
     *
     * @param x
     * @return
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     */
    public int mySqrt(int x) {
//        int a = (int) Math.sqrt(x);
        return (int) Math.sqrt(x);
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int[] count = new int[n+1];
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= n; i++) {
            count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }

    /**
     *
     * @param head
     * @return
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode listNodepre = head;
        ListNode listNode = head.next;
        int val = listNodepre.val;//记录上一个val
        while (true){
            ListNode listNode1 = listNode;
            if (listNode1 == null){
                return head;
            }
            if(val == listNode1.val){
                //直接指向下一个
                listNodepre.next = listNode1.next;
                listNode = listNode.next;
            }else{
                //不相等的话。指针都往后挪
                listNodepre = listNodepre.next;
                listNode = listNode.next;
                val = listNodepre.val;
            }

        }
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length-1;
        while (true){
            //如果m.n遍历完就退出
            if (m <= 0 && n <= 0){
                return;
            }
            if (m <= 0 && n > 0){
                nums1[index] = nums2[n-1];
                n--;
                index--;
                continue;
            }
            if (m > 0 && n <= 0){
                nums1[index] = nums1[m-1];
                m--;
                index--;
                continue;
            }
            //对比m.n末置位的数大小
            if (nums1[m-1] > nums2[n-1]){
                nums1[index] = nums1[m-1];
                m--;
            }else{
                nums1[index] = nums2[n-1];
                n--;
            }
            index--;
        }
    }

    /**
     *
     * @param p
     * @param q
     * @return
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * 输出: true
     * 示例 2:
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * 输出: false
     * 示例 3:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * 输出: false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        while (true){
            if (p != null && q != null){
                if (p.val == q.val){
                    return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
                }else{
                    return false;
                }
            }else if (p == null && q == null){
                return true;
            }else{
                return false;
            }
        }

    }

    /**
     *
     * @param root
     * @return
     * 给定一个二叉树，检查它是否是镜像对称的。

     */
    public boolean isSymmetric(TreeNode root) {
        //层序遍历
//        root.left == root.right
//        root.left.left == root.right.right
//        root.left.right == root.right.left
//        root.left.left.left == root.right.right.right
//        root.left.left.right == root.right.right.left
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return  (t1.val == t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    public int maxDepth(TreeNode root) {
        //深度优先搜索
//        if(root == null) {
//            return 0;
//        } else {
//            int left = maxDepth(root.left);
//            int right = maxDepth(root.right);
//            return Math.max(left, right) + 1;
//        }


        int deep = 1;
        if(root == null){
            return 0;
        }
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(root);
        return depth(list1,deep);
    }

    public int depth(List<TreeNode> list, int deep){
        if (list.size() <= 0) return deep;
        List<TreeNode> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).left != null) list1.add(list.get(i).left);
            if (list.get(i).right != null) list1.add(list.get(i).right);
        }
        if (list1.size() > 0) deep++;
        return depth(list1,deep);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root == null){
            return list;
        }
        treeNodes.offer(root);

        return gety(treeNodes,list);
    }

    public List<List<Integer>> gety(Queue<TreeNode> treeNodes,List<List<Integer>> list){

        if (treeNodes.isEmpty()) return list;
        List<Integer> list1 = new ArrayList<>();
        Queue<TreeNode> treeNodes2 = new LinkedList<>();
        while (!treeNodes.isEmpty()){
            TreeNode treeNode = treeNodes.poll();
            if (treeNode != null){
                list1.add(treeNode.val);
            }
            //先进后出
            if (treeNode.left != null) treeNodes2.offer(treeNode.left);
            if (treeNode.right != null) treeNodes2.offer(treeNode.right);
        }
        //添加该层
        list.add(0,list1);
        return gety(treeNodes2, list);
    }
    //
    public int maxProfit(int[] prices) {
        int value = 0;
        int a = 0; // 买入时机
        int b = -1;
        for (int i = 1; i < prices.length; i++) {
            int dex = 0;
           if (prices[1] > prices[a]){
               dex = prices[1] - prices[a];
           }else{
               //第二天价格比第一天低
//               if (a == b){
//                   a =
//               }
               a = i;

           }
           if (dex > value){
               //推迟卖出的时间
               if (value > 0 ){

               }
               value = dex;
           }else{
               //卖出
                b = i;
//                Integer.MAX_VALUE;
           }
        }
        return value;
    }

    String json = "{\"code\":200,\"data\":[{\"createTime\":1559285258000,\"deleted\":false,\"enabled\":true,\"id\":41,\"list\":[{\"createTime\":1559293018000,\"deleted\":false,\"enabled\":true,\"id\":50,\"list\":[\n" +
            "{\n" +
            "\"createTime\":1559293018000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":50,\n" +
            "\"list\":[\n" +
            "],\n" +
            "\"name\":\"台式电脑\",\n" +
            "\"path\":\"办公电脑,台式电脑\",\n" +
            "\"pathId\":\"41,50\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":103,\n" +
            "\"updateTime\":1560495692000,\n" +
            "\"version\":5\n" +
            "},\n" +
            "{\n" +
            "\"createTime\":1559285265000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":42,\n" +
            "\"list\":[\n" +
            "],\n" +
            "\"name\":\"笔记本\",\n" +
            "\"path\":\"办公电脑,笔记本\",\n" +
            "\"pathId\":\"41,42\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":101,\n" +
            "\"updateTime\":1560495650000,\n" +
            "\"version\":3\n" +
            "},\n" +
            "{\n" +
            "\"createTime\":1560824945000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":62,\n" +
            "\"list\":[\n" +
            "],\n" +
            "\"name\":\"一体机\",\n" +
            "\"path\":\"办公电脑,一体机\",\n" +
            "\"pathId\":\"41,62\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":100,\n" +
            "\"updateTime\":1560824945000,\n" +
            "\"version\":1\n" +
            "},\n" +
            "{\n" +
            "\"createTime\":1560824956000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":61,\n" +
            "\"list\":[\n" +
            "],\n" +
            "\"name\":\"单主机\",\n" +
            "\"path\":\"办公电脑,单主机\",\n" +
            "\"pathId\":\"41,63\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":100,\n" +
            "\"updateTime\":1560824955000,\n" +
            "\"version\":1\n" +
            "},\n" +
            "{\n" +
            "\"createTime\":1560824965000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":67,\n" +
            "\"list\":[\n" +
            "{\n" +
            "\"createTime\":1560824965000,\n" +
            "\"deleted\":false,\n" +
            "\"enabled\":true,\n" +
            "\"id\":60,\n" +
            "\"list\":[\n" +
            "],\n" +
            "\"name\":\"显示器\",\n" +
            "\"path\":\"办公电脑,显示器\",\n" +
            "\"pathId\":\"41,64\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":100,\n" +
            "\"updateTime\":1560824964000,\n" +
            "\"version\":1\n" +
            "}\n" +
            "],\n" +
            "\"name\":\"显示器\",\n" +
            "\"path\":\"办公电脑,显示器\",\n" +
            "\"pathId\":\"41,64\",\n" +
            "\"pid\":41,\n" +
            "\"sort\":100,\n" +
            "\"updateTime\":1560824964000,\n" +
            "\"version\":1\n" +
            "}\n" +
            "],\"name\":\"台式电脑\",\"path\":\"办公电脑,台式电脑\",\"pathId\":\"41,50\",\"pid\":41,\"sort\":103,\"updateTime\":1560495692000,\"version\":5},{\"createTime\":1559285265000,\"deleted\":false,\"enabled\":true,\"id\":42,\"list\":[],\"name\":\"笔记本\",\"path\":\"办公电脑,笔记本\",\"pathId\":\"41,42\",\"pid\":41,\"sort\":101,\"updateTime\":1560495650000,\"version\":3},{\"createTime\":1560824945000,\"deleted\":false,\"enabled\":true,\"id\":62,\"list\":[],\"name\":\"一体机\",\"path\":\"办公电脑,一体机\",\"pathId\":\"41,62\",\"pid\":41,\"sort\":100,\"updateTime\":1560824945000,\"version\":1},{\"createTime\":1560824956000,\"deleted\":false,\"enabled\":true,\"id\":63,\"list\":[],\"name\":\"单主机\",\"path\":\"办公电脑,单主机\",\"pathId\":\"41,63\",\"pid\":41,\"sort\":100,\"updateTime\":1560824955000,\"version\":1},{\"createTime\":1560824965000,\"deleted\":false,\"enabled\":true,\"id\":64,\"list\":[],\"name\":\"显示器\",\"path\":\"办公电脑,显示器\",\"pathId\":\"41,64\",\"pid\":41,\"sort\":100,\"updateTime\":1560824964000,\"version\":1}],\"name\":\"办公电脑\",\"path\":\"办公电脑\",\"pathId\":\"41\",\"pid\":0,\"sort\":100,\"updateTime\":1559293005000,\"version\":2},{\"createTime\":1559615846000,\"deleted\":false,\"enabled\":true,\"id\":58,\"list\":[{\"createTime\":1559615855000,\"deleted\":false,\"enabled\":true,\"id\":59,\"list\":[],\"name\":\"打印机\",\"path\":\"办公设备,打印机\",\"pathId\":\"58,59\",\"pid\":58,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1559615862000,\"deleted\":false,\"enabled\":true,\"id\":60,\"list\":[],\"name\":\"投影仪\",\"path\":\"办公设备,投影仪\",\"pathId\":\"58,60\",\"pid\":58,\"sort\":100,\"updateTime\":1560825002000,\"version\":3},{\"createTime\":1559615878000,\"deleted\":false,\"enabled\":true,\"id\":61,\"list\":[],\"name\":\"办公桌椅\",\"path\":\"办公设备,办公桌椅\",\"pathId\":\"58,61\",\"pid\":58,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1560825079000,\"deleted\":false,\"enabled\":true,\"id\":65,\"list\":[],\"name\":\"平板\",\"path\":\"办公设备,平板\",\"pathId\":\"58,65\",\"pid\":58,\"sort\":100,\"updateTime\":1560825078000,\"version\":1},{\"createTime\":1560825086000,\"deleted\":false,\"enabled\":true,\"id\":66,\"list\":[],\"name\":\"手机\",\"path\":\"办公设备,手机\",\"pathId\":\"58,66\",\"pid\":58,\"sort\":100,\"updateTime\":1560825085000,\"version\":1},{\"createTime\":1560825093000,\"deleted\":false,\"enabled\":true,\"id\":67,\"list\":[],\"name\":\"配件\",\"path\":\"办公设备,配件\",\"pathId\":\"58,67\",\"pid\":58,\"sort\":100,\"updateTime\":1560825093000,\"version\":1}],\"name\":\"办公设备\",\"path\":\"办公设备\",\"pathId\":\"58\",\"pid\":0,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1560825106000,\"deleted\":false,\"enabled\":true,\"id\":68,\"list\":[{\"createTime\":1560825122000,\"deleted\":false,\"enabled\":true,\"id\":69,\"list\":[],\"name\":\"安装升级\",\"path\":\"增值服务,安装升级\",\"pathId\":\"68,69\",\"pid\":68,\"sort\":100,\"updateTime\":1560825121000,\"version\":1},{\"createTime\":1560825132000,\"deleted\":false,\"enabled\":true,\"id\":70,\"list\":[],\"name\":\"软件预装\",\"path\":\"增值服务,软件预装\",\"pathId\":\"68,70\",\"pid\":68,\"sort\":100,\"updateTime\":1560825131000,\"version\":1},{\"createTime\":1560825146000,\"deleted\":false,\"enabled\":true,\"id\":71,\"list\":[],\"name\":\"上门维修\",\"path\":\"增值服务,上门维修\",\"pathId\":\"68,71\",\"pid\":68,\"sort\":100,\"updateTime\":1560825146000,\"version\":1}],\"name\":\"增值服务\",\"path\":\"增值服务\",\"pathId\":\"68\",\"pid\":0,\"sort\":100,\"updateTime\":1560825105000,\"version\":1}],\"message\":\"SUCCESS\"}";

    String str1 = "{\"code\":200,\"data\":[{\"createTime\":1559285258000,\"deleted\":false,\"enabled\":true,\"id\":41,\"list\":[{\"createTime\":1559293018000,\"deleted\":false,\"enabled\":true,\"id\":50,\"list\":[],\"name\":\"台式电脑\",\"path\":\"办公电脑,台式电脑\",\"pathId\":\"41,50\",\"pid\":41,\"sort\":103,\"updateTime\":1560495692000,\"version\":5},{\"createTime\":1559285265000,\"deleted\":false,\"enabled\":true,\"id\":42,\"list\":[],\"name\":\"笔记本\",\"path\":\"办公电脑,笔记本\",\"pathId\":\"41,42\",\"pid\":41,\"sort\":101,\"updateTime\":1560495650000,\"version\":3},{\"createTime\":1560824945000,\"deleted\":false,\"enabled\":true,\"id\":62,\"list\":[],\"name\":\"一体机\",\"path\":\"办公电脑,一体机\",\"pathId\":\"41,62\",\"pid\":41,\"sort\":100,\"updateTime\":1560824945000,\"version\":1},{\"createTime\":1560824956000,\"deleted\":false,\"enabled\":true,\"id\":63,\"list\":[],\"name\":\"单主机\",\"path\":\"办公电脑,单主机\",\"pathId\":\"41,63\",\"pid\":41,\"sort\":100,\"updateTime\":1560824955000,\"version\":1},{\"createTime\":1560824965000,\"deleted\":false,\"enabled\":true,\"id\":64,\"list\":[],\"name\":\"显示器\",\"path\":\"办公电脑,显示器\",\"pathId\":\"41,64\",\"pid\":41,\"sort\":100,\"updateTime\":1560824964000,\"version\":1}],\"name\":\"办公电脑\",\"path\":\"办公电脑\",\"pathId\":\"41\",\"pid\":0,\"sort\":100,\"updateTime\":1559293005000,\"version\":2},{\"createTime\":1559615846000,\"deleted\":false,\"enabled\":true,\"id\":58,\"list\":[{\"createTime\":1559615855000,\"deleted\":false,\"enabled\":true,\"id\":59,\"list\":[],\"name\":\"打印机\",\"path\":\"办公设备,打印机\",\"pathId\":\"58,59\",\"pid\":58,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1559615862000,\"deleted\":false,\"enabled\":true,\"id\":60,\"list\":[],\"name\":\"投影仪\",\"path\":\"办公设备,投影仪\",\"pathId\":\"58,60\",\"pid\":58,\"sort\":100,\"updateTime\":1560825002000,\"version\":3},{\"createTime\":1559615878000,\"deleted\":false,\"enabled\":true,\"id\":61,\"list\":[],\"name\":\"办公桌椅\",\"path\":\"办公设备,办公桌椅\",\"pathId\":\"58,61\",\"pid\":58,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1560825079000,\"deleted\":false,\"enabled\":true,\"id\":65,\"list\":[],\"name\":\"平板\",\"path\":\"办公设备,平板\",\"pathId\":\"58,65\",\"pid\":58,\"sort\":100,\"updateTime\":1560825078000,\"version\":1},{\"createTime\":1560825086000,\"deleted\":false,\"enabled\":true,\"id\":66,\"list\":[],\"name\":\"手机\",\"path\":\"办公设备,手机\",\"pathId\":\"58,66\",\"pid\":58,\"sort\":100,\"updateTime\":1560825085000,\"version\":1},{\"createTime\":1560825093000,\"deleted\":false,\"enabled\":true,\"id\":67,\"list\":[],\"name\":\"配件\",\"path\":\"办公设备,配件\",\"pathId\":\"58,67\",\"pid\":58,\"sort\":100,\"updateTime\":1560825093000,\"version\":1}],\"name\":\"办公设备\",\"path\":\"办公设备\",\"pathId\":\"58\",\"pid\":0,\"sort\":100,\"updateTime\":1560824988000,\"version\":2},{\"createTime\":1560825106000,\"deleted\":false,\"enabled\":true,\"id\":68,\"list\":[{\"createTime\":1560825122000,\"deleted\":false,\"enabled\":true,\"id\":69,\"list\":[],\"name\":\"安装升级\",\"path\":\"增值服务,安装升级\",\"pathId\":\"68,69\",\"pid\":68,\"sort\":100,\"updateTime\":1560825121000,\"version\":1},{\"createTime\":1560825132000,\"deleted\":false,\"enabled\":true,\"id\":70,\"list\":[],\"name\":\"软件预装\",\"path\":\"增值服务,软件预装\",\"pathId\":\"68,70\",\"pid\":68,\"sort\":100,\"updateTime\":1560825131000,\"version\":1},{\"createTime\":1560825146000,\"deleted\":false,\"enabled\":true,\"id\":71,\"list\":[],\"name\":\"上门维修\",\"path\":\"增值服务,上门维修\",\"pathId\":\"68,71\",\"pid\":68,\"sort\":100,\"updateTime\":1560825146000,\"version\":1}],\"name\":\"增值服务\",\"path\":\"增值服务\",\"pathId\":\"68\",\"pid\":0,\"sort\":100,\"updateTime\":1560825105000,\"version\":1}],\"message\":\"SUCCESS\"}";
    public void doJson() {
//        System.out.print(json);
        TestBean testBean = new Gson().fromJson(json,TestBean.class);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (TestBean.DataBean dataBean:testBean.getData()){
            if (checkItemList60(dataBean.getList(), arrayList) == 60) {
                arrayList.add(dataBean.getId());
            }
        }

        for (Integer integer:arrayList){
            System.out.println("------"+integer);
        }
    }

    public int checkItemList60(List<TestBean.DataBean.ListBean> listBeans,ArrayList<Integer> arrayList){
        int returnId = 0;
        // 空返回
        if (listBeans.size() <= 0) return 0;

        // 非空便利
        for (TestBean.DataBean.ListBean listBean: listBeans){
            // 往下找有60返回，并添加上一级id---找子list
            if(checkItemList60(listBean.getList(),arrayList) == 60){
                arrayList.add(listBean.getId());
                return 60;
            }
            // 找到60，就往里面加 ------ 找本list
            if (listBean.getId() == 60){
                arrayList.add(listBean.getId());
                return listBean.getId();
            }
        }
        return returnId;
    }

}
