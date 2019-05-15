package leet_sloutions.finished;

/**编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
输出: "fl"

 示例 2:

 输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。


 说明:

 所有输入只包含小写字母 a-z 。**/
public class _14_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        }
        String prefix=strs[0];
        StringBuilder tempPrefix=new StringBuilder();
        for(int i=1;i<strs.length;i++) {
            for(int j=0;j<strs[i].length();j++) {

                if(j==prefix.length()||prefix.charAt(j)!=strs[i].charAt(j)) {
                    break;
                }
                tempPrefix.append(prefix.charAt(j));
            }
            prefix=tempPrefix.toString();
            tempPrefix.delete(0,tempPrefix.length());
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str={"dog","racecar","car"};
        _14_longestCommonPrefix test=new _14_longestCommonPrefix();
        System.out.println(test.longestCommonPrefix(str));
    }

}
