package normal;

import java.util.Random;

public class Skiplist {

    int level = 10;
    class Node {
        int val;
        Node[] nodes = new Node[level];
        Node(int _val){
            val = _val;
        }
    }
    Random random = new Random();
    Node he = new Node(-1);
    public Skiplist() {

    }

    void find(int t,Node[] nodes){
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.nodes[i] != null && cur.nodes[i].val < t) {
                cur = cur.nodes[i];
            }
            nodes[i] = cur;

        }
    }

    public boolean search(int target) {
        Node[] ns = new Node[level];
        find(target,ns);
        return ns[0].nodes[0] != null && ns[0].nodes[0].val == target;

    }

    public void add(int num) {
        Node[] ns = new Node[level];
        find(num,ns);
        Node node = new Node(num);
        for (int i = 0; i < level; i++) {
            node.nodes[i] = ns[i].nodes[i];
            ns[i].nodes[i] = node;
            if (random.nextInt(2) == 0) break;
        }
    }

    public boolean erase(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = ns[0].nodes[0];
        if (node == null || node.val != num) return false;
        for (int i = 0; i < level && ns[i].nodes[i] == node; i++) ns[i].nodes[i] = ns[i].nodes[i].nodes[i];
        return true;
    }
}
