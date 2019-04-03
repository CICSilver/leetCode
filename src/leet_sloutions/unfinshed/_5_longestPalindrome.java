package leet_sloutions.unfinshed;

import java.util.*;

public class _5_longestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     *         长度最大为1000的字符串
     *         ababd,jkkjijkljlhjik,jpki ikoj ikpj
     *         jkiu uikj
     */
    public String longestPalindrome(String s){
        char front,cur,next;
        int longestPalinLength=0;
        int startPos=s.length()-1;
        for(int curIndex=1;curIndex<s.length()-1;curIndex++){
            int frontIndex=curIndex-1;
            int nextIndex=curIndex+1;
            front=s.charAt(frontIndex);
            cur=s.charAt(curIndex);
            next=s.charAt(nextIndex);
            if(front==next) {
                int[] lap=lenAndPos(frontIndex,nextIndex,3,s);
                if(longestPalinLength<lap[0]) {
                    longestPalinLength=lap[0];
                    startPos=lap[1];
                }
            } else if(front==cur){
                front=s.charAt(frontIndex-1);
                if(front==next) {
                    int[] lap=lenAndPos(frontIndex-1,nextIndex,2,s);
                    if(longestPalinLength<lap[0]) {
                        longestPalinLength=lap[0];
                        startPos=lap[1];
                    }
                }
                longestPalinLength=longestPalinLength<2? 2:longestPalinLength;
            }

        }
        if(s.charAt(s.length()-1)==s.charAt(s.length()-2)) {
            longestPalinLength=longestPalinLength<2? 2:longestPalinLength;
        }
        if(longestPalinLength==0) {
            return null;
        } else {
            char[] result=new char[longestPalinLength];
            System.arraycopy(s.toCharArray(),startPos,result,0,longestPalinLength);
            return Arrays.toString(result);
        }

    }

    /**
     *
     * @param indexFro 前一个字符的下标
     * @param indexNex 后一个字符的下标
     * @param curLen 当前最大回文子串长度
     * @param s 主串
     * @return [当前回文子串长度，回文子串的起始位置]
     */
    private int[] lenAndPos(int indexFro, int indexNex, int curLen,String s) {
        int startPos=0;
        int[] lenAndPos=new int[2];
        char front,next;
        while(indexFro>0&&indexNex<s.length()) {
            front=s.charAt(indexFro--);
            next=s.charAt(indexNex++);
            if(front==next) {
                curLen+=2;
                startPos=indexFro;
            } else {
                break;
            }
        }
        lenAndPos[0]=curLen;
        lenAndPos[1]=startPos;
        return lenAndPos;
    }

    public static void main(String[] args) {
        String test="abbbcde";
        _5_longestPalindrome longestPalindrome=new _5_longestPalindrome();
        char[] result = new char[test.length()];
        System.out.println(longestPalindrome.longestPalindrome(test));
    }
}
