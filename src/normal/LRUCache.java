package normal;

import model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class LRUCache {

    class LruCacheNode{
        int key;
        int value;
        LruCacheNode prev;
        LruCacheNode next;

        public LruCacheNode() {
        }

        public LruCacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,LruCacheNode> map = new HashMap<>();
    int size;
    int capacity = 10;
    LruCacheNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LruCacheNode();
        tail = new LruCacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LruCacheNode node = map.get(key);
        if (node == null)
            return -1;
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(LruCacheNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 循环链表
    private void removeNode(LruCacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LruCacheNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        LruCacheNode node = map.get(key);
        if (node == null){
            LruCacheNode newNode = new LruCacheNode(key, value);
            map.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                LruCacheNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private LruCacheNode removeTail() {
        LruCacheNode res = tail.prev;
        removeNode(res);
        return res;
    }

    /**
     * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
     * @param root
     * @return
     */
    int maxD = 1;
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        // 记录最深层级
        dfs(root,1);
        return hashMap.getOrDefault(maxD,0);
    }
    void dfs(TreeNode root,int d){
        if (root == null)
            return ;

        if (d > maxD) maxD = d;
        int sum = hashMap.getOrDefault(d,0);
        sum += root.val;
        System.out.println("----sun==" + sum + "---d==" + d);
        hashMap.put(d,sum);
        if (root.left != null) dfs(root.left,d++);
        if (root.right != null) dfs(root.right,d++);
    }

    /**
     * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
     *
     * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
     * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
     *
     * @param nums
     * @return
     */
    int[] cnt = new int[100010], sum = new int[100010];
    public int maxEqualFreq(int[] nums) {
        Arrays.fill(cnt,0);
        Arrays.fill(sum,0);
        int n = nums.length,max = 0,ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i], cur = ++cnt[t], len = i + 1;
            sum[cur]++;sum[cur -1]--;
            max = Math.max(max,cur);
            if (max == 1) ans = len;
            if (max  * sum[max] + 1 == len) ans = len;
            if ((max-1) * (sum[max-1] + 1) + 1 == len) ans = len;
        }
        return ans;
    }
}
