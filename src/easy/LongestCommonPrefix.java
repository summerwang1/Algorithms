package easy;

/**
 * Created on 2019-06-17.
 *
 * @author： sarWang
 * @description：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //初始化前缀
        String pre = "";
        if(strs.length > 0 && strs[0].length() > 0){
            for (int i = 0; i < strs[0].length(); i++) {
                pre = strs[0].substring(0,i+1);
                for (int j = 1; j < strs.length; j++) {
                    if ((strs[j].indexOf(pre) != 0)){
                        return pre.substring(0,pre.length()-1);
                    }
                }
            }
        }else {
            return "";
        }

        return pre;
    }


}
