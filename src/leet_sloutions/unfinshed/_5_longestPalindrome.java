package leet_sloutions.unfinshed;

import java.util.ArrayList;
import java.util.List;

public class _5_longestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     *         长度最大为1000的字符串
     *         ababd,jkkjijkljlhjik,jpki ikoj ikpj
     *         jkiu uikj
     */
    public String longestPalindrome(String s) {
        if(s.length()<=0||s.length()>1000) {return null;}
        char[] arrayS=s.toCharArray();
        int start=0,end=1;
        List<Integer> len=new ArrayList();
        int[] id=new int[s.length()];
        for(int i=0;i<s.length();i++) {
            id[i]=i;
        }
        for(;start<s.length();start++) {
            if(arrayS[start]==arrayS[end])
            {
                len.add(end-start);
            }
        }
        return s;
    }
}
