package normal;

import model.ListNode;

class MyCircularQueue {

    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int size;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        ListNode listNode = new ListNode(value);
        if (head == null){
            head = tail = listNode;
        }else{
            tail.next = listNode;
            tail = listNode;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        ListNode node = head;
        head = node.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return head.val;
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */