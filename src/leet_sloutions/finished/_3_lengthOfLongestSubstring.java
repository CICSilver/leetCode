package leet_sloutions.finished;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  示例 1:
 *
 *  输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 *  示例 2:
 *
 *  输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 *  示例 3:
 *
 *  输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复子序列"wke"长度为3.
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */
public class _3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Map<Character,Integer> charMap=new HashMap<>(26);
        int len=0;
        int maxLen=1;
        for(int i=0;i<s.length();i++) {
            if(!charMap.containsKey(s.charAt(i))) {
                len++;
            } else {
                maxLen=Math.max(len,maxLen);
                i-=len-1;
                len=1;
                charMap.clear();
            }
            charMap.put(s.charAt(i),i);
        }
        maxLen=Math.max(len,maxLen);
        return maxLen;
    }
    public static void main(String [] args) {
        String test="dvcdf";
        _3_lengthOfLongestSubstring lengthOfLongestSubstring=new _3_lengthOfLongestSubstring();
        int i=lengthOfLongestSubstring.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
