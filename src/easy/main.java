package easy;

import model.ListNode;
import model.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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
//        new Solution().doJson();

       /* Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));
        System.out.println(skiplist.search(1));*/

//        new main().solveEquation("x+5-3+x=6+x-2");
//        System.out.println(new main().reformat("covid201129"));
//        System.out.println("hello".indexOf(""));
//        System.out.println(new main().canBeEqual(new int[]{1,2,3,4},new int[]{4,2,3,1}));
//        System.out.println(new main().removeNthFromEnd(listNodel1,1));

    }
    public String fractionAddition(String expression) {
        long d = 0, m = 1;
        int index = 0,n = expression.length();
        while (index < n){
            // 读取分子
            long d1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                d1 = d1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            d1 = sign * d1;
            index++;

            // 读取分母
            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            d = d * numerator1 + d1 * m;
            m *= numerator1;

        }
        if (d == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(d), m); // 获取最大公约数
        return Long.toString(d / g) + "/" + Long.toString(m / g);

    }
    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
    public int[] arrayRankTransform(int[] arr) {
        int[] clone  = arr.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> hashMap = new HashMap<>();
        int length = arr.length,idx = 0;
        for (int i : clone) {
            if (!hashMap.containsKey(i)){
                hashMap.put(i,++idx);
            }
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = hashMap.get(arr[i]);
        }
        return ans;
    }
    long len = -1;
    public boolean validSquare(int[] a,int[] b,int[] c,int[] d){
        return calc(a, b, c) && calc(a, b, d) && calc(a, c, d) && calc(b, c, d);
    }
    public boolean calc(int[] a,int[] b,int[] c){
        long l1 = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        long l2 = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
        long l3 = (b[0] - c[0]) * (b[0] - c[0]) + (b[1] - c[1]) * (b[1] - c[1]);
        boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
        if (!ok) return false;
        if (len == -1) len = Math.min(l1, l2);
        else if (len == 0 || len != Math.min(l1, l2)) return false;
        return true;

    }

    static int N = 20010;
    static int[] p = new int[N], sz = new int[N];
    int res = 1;
    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int a, int b) {
        if (find(a) == find(b)) return ;
        sz[find(a)] += sz[find(b)];
        p[find(b)] = p[find(a)];
        res = Math.max(res, sz[find(a)]);
    }

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = 2; j * j <= cur; j++) {
                if (cur % j == 0) add(map, j, i);
                while (cur % j == 0) cur /= j;
            }
            if (cur > 1) add(map, cur, i);

        }
        for (int i = 0; i <= n ; i++) {
            p[i] = i;
            sz[i] = 1;
        }

        for (int key : map.keySet()){
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                union(list.get(0), list.get(i));
            }
        }
        return res;
    }

    void add(Map<Integer, List<Integer>> map, int key, int val) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(val);
        map.put(key, list);
    }

    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int res = 0;
        int max = Integer.MIN_VALUE;
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size(),cur = 0;
            while(size-- > 0){
                TreeNode t = deque.pollLast();
                if (t.left != null) deque.addFirst(t.left);
                if (t.right != null) deque.addFirst(t.right);
                cur += t.val;
            }
            if (cur > max){
                max = cur;
                res = level;
            }
            level++;
        }
        return res;
    }

    public String orderlyQueue(String s, int k) {
       char[] cs = s.toCharArray();
       if (k == 1){
           int i = 0,j = 1, k1 = 0,n = cs.length;
           while (i < n && j < n && k1 < n){
               char a = cs[(i + k1) % n], b = cs[(j + k1) % n];
               if (a == b) k1++;
               else {
                   if (a > b) i += k1 + 1;
                   else j += k1 + 1;
                   if (i == j) i++;
                   k1 = 0;
               }
           }
           i = Math.min(i,j);
           return s.substring(i) + s.substring(0,i);
       } else {
           Arrays.sort(cs);
           return String.valueOf(cs);
       }
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0,cur = 0,idx = nums.length -1;
        for(int i: nums) sum += i;
        List<Integer> list = new ArrayList<>();
        while(cur <= sum){
            cur += nums[idx];
            sum -= nums[idx];
            list.add(nums[idx--]);
        }
        return list;
    }

    /**
     * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
     *
     * 注意，根节点 root 位于深度 1 。
     *
     * 加法规则如下:
     *
     * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
     * cur 原来的左子树应该是新的左子树根的左子树。
     * cur 原来的右子树应该是新的右子树根的右子树。
     * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-one-row-to-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        int d = 1;// 深度
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while(size-- > 0){
                TreeNode t = deque.pollFirst();
                if (d == depth -1){
                    TreeNode a = new TreeNode(val),b = new TreeNode(val);
                    a.left = t.left; b.right = t.right;
                    t.left = a;t.right = b;
                }else{
                    if (t.left != null) deque.addLast(t.left);
                    if (t.right != null) deque.addLast(t.right);
                }
            }
            d++;
        }
        return root;
    }
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length && i != j; j++) {
                System.out.println("---" + words[j] + "----" + words[i]);
                if(words[j].indexOf(words[i]) >= 0){
                    res.add(words[i]);
                    break;
                }
            }

        }
        return res;
    }

    /**
     * 输入：n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
     * 输出：[8]
     * 解释：
     * 函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，并递归调用它自身。
     * 函数 0（递归调用）在时间戳 2 的起始开始执行，执行 4 个单位时间。
     * 函数 0（初始调用）恢复执行，并立刻再次调用它自身。
     * 函数 0（第二次递归调用）在时间戳 6 的起始开始执行，执行 1 个单位时间。
     * 函数 0（初始调用）在时间戳 7 的起始恢复执行，执行 1 个单位时间。
     * 所以函数 0 总共执行 2 + 4 + 1 + 1 = 8 个单位时间。
     *
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int cur = -1;
        for (String log:logs) {
            String[] ss = log.split(":");
            int idx = Integer.parseInt(ss[0]), ts = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")){
                if (!deque.isEmpty()) ans[deque.peekLast()] += ts - cur;
                deque.addLast(idx);
                cur = ts;
            } else {
                int func = deque.pollLast();
                ans[func] += ts - cur + 1;
                cur = ts + 1;
            }
        }
        return ans;
    }
    public String makeLargestSpecial(String s) {
        if(s.length() == 0){
            return "";
        }
        List<String> list = new ArrayList<>();
        int count = 0,last = 0;
        for (int i = 0,cur = 0; i < s.length(); i++,cur++) {
            if (s.charAt(i) == '1'){
                count++;
            }else{
                count--;
            }

            if (count == 0){
                String str = "1" + makeLargestSpecial(s.substring(last + 1, cur)) + "0";
                System.out.println("str===" + str);
                list.add(str);
                last = cur + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String lis:list){
            sb.append(lis);
        }
        return sb.toString();
    }
    public int minStartValue(int[] nums) {
        int num = 0,min = 0;
        for (int i : nums) {
            num += i;
            min = Math.min(min,num);
        }
        if (min > 0) return 0;
        return Math.abs(min) + 1;
    }

    /**
     * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
     *
     * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
     *
     * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
     *
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        String[] e = equation.split("=");
        int x = 0 ,num = 0, n = equation.length();
        char[] cs = equation.toCharArray();
        for (int i = 0, op = 1; i < n;){
            if (cs[i] == '+'){
                op = 1; i++;
            } else if (cs[i] == '-'){
                op = -1; i++;
            } else if (cs[i] == '='){
                x *= -1; num *= -1; op = 1; i++;
            } else{
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(equation.substring(i, j)) * op;
                i = j;
            }
        }
        if(x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }

    public String reformat(String num){
        StringBuilder letter = new StringBuilder(), nums = new StringBuilder();
        for (char s : num.toCharArray()){
            if (s >= 'a' && s <= 'z'){
                letter.append(s);
            }else{
                nums.append(s);
            }
        }
        if (Math.abs(letter.length() - nums.length()) > 1) return "";
        StringBuilder ans = new StringBuilder();
        boolean first = nums.length() > letter.length();
        int a = 0, b = 0;
        while (a < letter.length() || b < num.length()){
            if (first){
                if (b < nums.length()){
                    ans.append(nums.charAt(b));
                }
                if (a < letter.length()){
                    ans.append(letter.charAt(a));
                }
            }else{
                if (a < letter.length()){
                    ans.append(letter.charAt(a));
                }
                if (b < nums.length()){
                    ans.append(nums.charAt(b));
                }
            }
            a++;
            b++;
        }
        return ans.toString();
    }

    int count = 0;
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 1){
            list.add(n % 10);
            n = n/10;
        }
        int sum = 0;
        for (Integer i : list) {
            sum += Math.pow(i,2);
        }
        if (sum == 1) return true;
        count++;
        if (count > 1000) return false;


        return isHappy(sum);
    }

    public List<String> fizzBuzz(int n) {
        String s3 = "Fizz",s5  = "Buzz";
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0){
                str = s3;
            }
            if (i % 5 == 0){
                str = str + s5;
            }
            if (str.length() > 0){
                list.add(str);
            }else{
                list.add(i + "");
            }
        }
        return list;

    }

    /**
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0; // 剩余油量
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare){
                minSpare = spare;
                minIndex = i;
            }
            
        }
        return minSpare > 0? (minIndex + 1) % len : -1;
    }

    Map<Integer,Integer> memo = new HashMap<>();
    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }
    int dp(int k, int n){
        if (!memo.containsKey(n*100 + k) ){
            int ans;
            if (n == 0){
                ans = 0;
            }else if (k == 1){
                ans = n;
            }else {
                int lo = 1, hi = n;
                while (lo + 1 < n){
                    int x = (lo + hi) /2;
                    int t1 = dp(k -1 , x -1);
                    int t2 = dp(k , n - x);

                    if (t1 < t2){
                        lo = x;
                    } else if (t1 > t2){
                        hi = x;
                    }else {
                        lo = hi = x;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(k-1,lo-1),dp(k,n -lo)),Math.max(dp(k-1,hi-1),dp(k,n-hi)));
            }
            memo.put(n * 100 + k,ans);
        }
        return memo.get(n * 100 + k);
    }

    /**
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
     *
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     *
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
     *
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime){
                if (endTime[i] >= queryTime){
                    ans++;
                    continue;
                }
            }
        }
        return ans;
    }

    /*public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length - 1);
    }
    TreeNode build(int[] nums,int l, int r){
        if (l > r) return null;
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) idx = i;
        }
        TreeNode ans = new TreeNode(nums[idx]);
        ans.left = build(nums,l,idx-1);
        ans.right = build(nums,idx + 1,r);
        return ans;
    }*/

    TreeNode[] stk = new TreeNode[1010];
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int he = 0,ta = 0;
        for (int x:
             nums) {
           TreeNode node = new TreeNode(x);
           while (he < ta && stk[ta - 1].val < x) node.left = stk[--ta];
           if (he < ta) stk[ta - 1].right = node;
           stk[ta++] = node;
        }
        return stk[0];
    }
    int h,m,n;
    List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        dfs1(root,0);
        m = h + 1;n = (1 << (h+1)) - 1;
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cur.add("");
            }
            ans.add(cur);
        }
        dfs2(root,0,(n-1)/2);
        return ans;
    }

    private void dfs2(TreeNode root, int x, int y) {
        if (root == null) return;
        ans.get(x).set(y,String.valueOf(root.val));
        dfs2(root.left,x+1,y - (1 << (h - x- 1)));
        dfs2(root.right,x+1,y + (1 << (h - x- 1)));
    }

    private void dfs1(TreeNode root, int i) {
        if (root == null) return ;
        h = Math.max(h,i);
        dfs1(root.left,i+1);
        dfs1(root.right,i+1);
    }

    public boolean isPalindrome(String s) {
        int a = 0,b = s.length() -1;
        while(a < b){
            while(a < b && !Character.isLetterOrDigit(s.charAt(a))){
                a++;
            }
            while(a < b && !Character.isLetterOrDigit(s.charAt(b))){
                b--;
            }
            if (Character.toLowerCase(s.charAt(a)) == Character.toLowerCase(s.charAt(b))){
                a++;
                b--;
            }else{
                return false;
            }
        }
        return true;
    }
    List<List<String>> res1 = new ArrayList<>();
    List<String> path = new ArrayList<>();
    //回文串判断表 isPalindrome[i][j]=s[i...j]
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 单个字符位置
            isPalindrome[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (j - i < 3){
                    isPalindrome[i][j] = arr[i] == arr[j];
                }else{
                    isPalindrome[i][j] = arr[i] == arr[j] && isPalindrome[i+1][j-1];
                }
            }
        }
        DFS(s,0,s.length() -1,isPalindrome);
        return res1;

    }

    private void DFS(String s, int start, int end, boolean[][] isPalindrome) {
        if (start > end){
            List<String> l = new ArrayList<>();
            l.addAll(path);
            res1.add(l);
            return;
        }
        for (int i = 1; i <= end - start + 1 ; i++) {
            if (!isPalindrome[start][start+i -1]) continue;
            path.add(s.substring(start,start+i));
            DFS(s,start+i,end,isPalindrome);
            path.remove(path.size() -1);

        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }

//    public List<String> wordBreak2(String s, List<String> wordDict) {
//
//
//    }

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k;
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     * 1。动态dp 二维 0 是现金，1是股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[][] dp = new int[len][2]; // 从x-> y的利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
//        找出dp
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums,0,length -1);
        reverse(nums,0,k-1);
        reverse(nums,k,length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end--];
            nums[start] = nums[start++] - nums[end];
        }
    }
    public boolean containsDuplicate(int[] nums) {

        return IntStream.of(nums).distinct().count() != nums.length;
    }
    public int singleNumber(int[] nums) {
        int res = 1;
        for (int i: nums
             ) {
            res ^= i;

        }
        return res;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 0，1，0，3，12
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int quick = 0,slow=0; // 指针
        while(quick < len){
            while (slow <= quick && nums[slow] != 0) slow++;
            if (quick > slow && nums[quick] != 0){
                nums[slow++] = nums[quick];
                nums[quick++] = 0;
                continue;
            }
            quick++;
        }
    }

    /**
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.'){
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i/3][j/3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i/3][j/3][index] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len/2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                int m = len - j - 1;
                int n = len - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
    public void reverseString(char[] s) {
        int left = 0,right = s.length;
        while (left < right){
            char a = s[left];
            s[left] = s[right];
            s[right] = a;
        }
    }

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] a = new int[26];
        Arrays.fill(a,0);
        char[] sc = s.toCharArray();
        // 统计个数
        for (char ch: sc) {
            a[ch - 'a']++;
        }
        for (int i = 0; i < sc.length; i++) {
            if (a[sc[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int snums = 0,tnums = 0;
        for (char sc:
             s.toCharArray()) {
            snums += sc;
        }
        for (char sc:
             t.toCharArray()) {
            tnums += sc;

        }
        return s.length() == t.length() && snums == tnums;

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }

    public int myAtoi(String s) {
        s = s.trim();
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(s);
        int value = 0;
        if (m.find()){
            try {
                value = Integer.parseInt(s.substring(m.start(),m.end()));
            }catch (Exception e){
                value = s.charAt(0) == '-'?Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy,slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return sortedArrayToBST(nums,0,len-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if (left >= right) return null;
        int mid = (right + left) /2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums,left,mid -1 );
        node.right = sortedArrayToBST(nums,mid + 1,right);
        return node;
    }


}


