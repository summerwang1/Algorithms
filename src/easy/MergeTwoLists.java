package easy;

import model.ListNode;

/**
 * Created on 2019-06-18.
 *
 * @author： sarWang
 * @description：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        ListNode node = l1;
        ListNode node2 = l2;
        if (l1 == null && l2 == null){

        }else{
            while (true){
                int value = 0;
                if (node == null || node2 == null){
                    if (node == null && node2 != null){
                        value = node2.val;
                        node2 = node2.next;
                    }
                    if (node2 == null && node != null){
                        value = node.val;
                        node = node.next;
                    }
                }else{
                    if (node.val <= node2.val) {
                        value = node.val;
                        node = node.next;
                    }else{
                        value = node2.val;
                        node2 = node2.next;
                    }
                }
                //创建一个新节点，，
                ListNode next1 = new ListNode(value);
                //如果首节点，给result
                //不是首节点，则拼到上个节点后面
                //记录本节点
                if (result == null){
                    result = next1;
                }else{
                    next.next = next1;
                }
                next = next1;

                if (node == null && node2 == null){
                    break;
                }

            }
        }
        return result;
    }
}
