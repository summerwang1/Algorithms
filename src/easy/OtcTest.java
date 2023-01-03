package easy;

import java.util.*;

public class OtcTest {
    public static void main(String[] args) {

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        set.add(1L);
        while (n-- > 0){
            long x = q.poll();
            if (n == 0) return (int) x;
            for(int k:primes){
                if (!set.contains(k*x)){
                    set.add(k * x);
                    q.add(k*x);
                }
            }
        }
        return -1;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n-2;) {
            int j = i, d = nums[i+1] - nums[i];
            while (j + 1 < n && nums[j+1] - nums[j] == d) j++;
            int len = j - i +1;
            int a1 = 1,an = len - 3 + 1;
            int cnt = (a1 + an) * an/2;
            ans+=cnt;
            i = j;
        }
        return ans;
    }
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        List<Map<Long,Integer>> f = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Long,Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                Long d = nums[i] * 1L - nums[i];
                Map<Long,Integer> prev = f.get(j);
                int cnt = cur.getOrDefault(d,0);
                cnt += prev.getOrDefault(d,0);
                cnt++;
                cur.put(d,cnt);
            }
            f.add(cur);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long,Integer> cur = f.get(i);
            for(Long key : cur.keySet()) ans += cur.get(key);
        }
        int a1 = 0, an = n - 1;
        int cnt = (a1 + an) * n / 2;
        return ans - cnt;

    }



}
