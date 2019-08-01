package easy;

import model.ListNode;

/**
 * Created on 2019-06-12.
 *
 * @author： sarWang
 * @description： https://leetcode-cn.com/problemset/all/
 */
public class main {
    public static void main(String[] strs){
//        int re = RommanTOInt.rommanTOInt("III");
//        int re = ResverInt.reverse(-123);
       /* System.out.println("==III=="+RommanTOInt.rommanTOInt("III"));
        System.out.println("==IV=="+RommanTOInt.rommanTOInt("IV"));
        System.out.println("==IX=="+RommanTOInt.rommanTOInt("IX"));
        System.out.println("==LVIII=="+RommanTOInt.rommanTOInt("LVIII"));
        System.out.println("==MCMXCIV=="+RommanTOInt.rommanTOInt("MCMXCIV"));
        System.out.println("==DCXXI=="+RommanTOInt.rommanTOInt("DCXXI"));*/
//        String[] strings = {"c","ccc","ccc"};
//        System.out.println("=="+LongestCommonPrefix.longestCommonPrefix(strings));
//        System.out.println("=="+IsValid.isValid("(([]){})"));
//        System.out.println("=="+IsValid.isValid("()[]{}"));
//        System.out.println("=="+IsValid.isValid("(]"));
//        System.out.println("=="+IsValid.isValid("([)]"));
//        System.out.println("=="+IsValid.isValid("{[]}"));
        ListNode listNodel1 = new ListNode(1);
        ListNode listNodel2 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNodel1.next = listNodel2;
        listNodel2.next = listNode2;
        listNode2.next = listNode4;

//        listNodel2.next = listNode3;
//        listNode3.next = listNode4;
//        System.out.println("=="+MergeTwoLists.mergeTwoLists(listNodel1,listNodel2));
        ListNode listNode = new Solution().deleteDuplicates(listNodel1);
        System.out.println("==");
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;
//        System.out.println("==" + new RemoveElement().removeElement(nums,val));
//        for (int i = 1; i < 10; i++) {
//            System.out.println("==" + new Solution().lengthOfLastWord("      "));
//        int[] a = new Solution().plusOne(new int[]{9, 9, 9, 9});
//            System.out.println("==" + new Solution().addBinary("1010","1011"));
//            System.out.println("==" + new Solution().mySqrt(0));
//            System.out.println("==" + new Solution().climbStairs(2));
//        }
        int[] aa = {7,1,5,3,6,4};
//        System.out.println("==" + new Solution().maxProfit(aa));
        new Solution().doJson();
    }
}
