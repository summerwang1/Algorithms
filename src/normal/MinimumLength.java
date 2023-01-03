package normal;

/**
 * 删除字符串两端相同字符后的最短长度
 * 中等
 * 49
 * 相关企业
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 *
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ca"
 * 输出：2
 * 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 * 示例 2：
 *
 * 输入：s = "cabaabac"
 * 输出：0
 * 解释：最优操作序列为：
 * - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
 * - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 * 示例 3：
 *
 * 输入：s = "aabccabba"
 * 输出：3
 * 解释：最优操作序列为：
 * - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
 * - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符 'a'，'b' 和 'c' 。
 */
public class MinimumLength {
    public static void main(String[] args) {
        System.out.println(new MinimumLength().lengthOfLongestSubstring("abcabcbb"));
    }

    public int minimumLength(String s) {
        int length = s.length();
        int l = 0, r = length - 1;
        while (l < r) {
            // 左右平移
            if (s.charAt(l) == s.charAt(r)) {
                // 去重缩近
                while (l + 1 < length && s.charAt(l) == s.charAt(l + 1)) l++;
                while (r > 0 && s.charAt(r) == s.charAt(r - 1)) r--;
                r--;
                l++;
            } else {
                return r - l + 1;
            }
            System.out.println("====" + l + "=====" + r);
        }
        return l == r ? 1 : 0;
    }
    /**给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



     示例 1:

     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: s = "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: s = "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


     提示：

     0 <= s.length <= 5 * 104
     s 由英文字母、数字、符号和空格组成
     */
    public int lengthOfLongestSubstring(String s) {

        int l = 0,r=0; //动态规划，最长不重复，a = 0, b = 0
        int maxLength = 0;
        String max= "";
        String str= "";
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(i,i+1); // 当前字符
            //判断当前字符在不在str内
            int index = str.indexOf(curr);
            if (index >= 0 ){
                // 字符已经存在
                l = l + index + 1;
            }
            r = i + 1;
            str = s.substring(l,r);
            if (maxLength < str.length()){
                maxLength = str.length();
                max = str;
            }
        }
        System.out.println(max);
        return maxLength;
    }
}
