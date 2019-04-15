package leet_sloutions.finished;

import java.util.HashMap;
import java.util.Map;

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
    //dvcdf i=3->i=1,len=3
    public static void main(String [] args) {
        String test="dvcdf";
        _3_lengthOfLongestSubstring lengthOfLongestSubstring=new _3_lengthOfLongestSubstring();
        int i=lengthOfLongestSubstring.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
