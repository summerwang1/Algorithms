package normal;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public MinStack() {

    }

    public int countPrimes(int n) {
        boolean[] arr = new  boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) continue;
            cnt++;
            for (int j = i; j < n; j+=i) {
                arr[j] = true;
            }
        }
        return cnt;
    }

    /**
     * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        //寻找最接近x的位置
        int left = 0,right = len -1; //初始化左右指针
        int min = Integer.MAX_VALUE;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if (arr[mid] <= x){
                left = mid;
            }else {
                right = mid -1;
            }
        }
        right = right + 1 < len && Math.abs(arr[right + 1] - x) < Math.abs(arr[right] - x) ? right+ 1 : right;
        int i = right - 1 ,j = right + 1;
        while (j - i  - 1 < k) {
            if (i >= 0 && j < len){
                if (Math.abs(arr[j] - x) < Math.abs(arr[i] -x)) {
                    j++;
                }else{
                    i--;
                }
            }else if (i >= 0){
                i--;
            }else{
                j++;
            }
        }
        for (int l = i + 1; l <= j -1 ; l++) {
            res.add(arr[l]);
        }
        return res;

    }
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ans = 0;
        while (res != 0){
            ans += ans & 1;
            ans = ans >>> 1;
        }
        return ans;
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int sum1 = len * (len + 1) /2;
        for (int n : nums) {
            sum += n;
        }
        return sum1 - sum;

    }

}
