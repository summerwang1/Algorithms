package model;

/**
 * Created on 2019-06-18.
 *
 * @author： sarWang
 * @description：
 */
public class ListNode {
    public int val;
    public ListNode next;


//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }

    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
