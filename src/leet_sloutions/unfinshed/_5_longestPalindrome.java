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
        if(s==null) {
            return null;
        }
        if(s.length()<=1){
            return s;
        }
        if(s.length()==2) {
            if(s.charAt(0)==s.charAt(1)) {
                return s;
            }else {
                return Character.toString(s.charAt(0));
            }
        }
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
            } else if(front==cur) {
                if (frontIndex != 0) {
                    front = s.charAt(frontIndex - 1);
                    if (front == next) {
                        int[] lap = lenAndPos(frontIndex - 1, nextIndex, 2, s);
                        if (longestPalinLength < lap[0]) {
                            longestPalinLength = lap[0];
                            startPos = lap[1];
                        }
                    }
                    startPos = frontIndex;
                    longestPalinLength = longestPalinLength < 2 ? 2 : longestPalinLength;
                } else {
                    longestPalinLength=2;
                    startPos=frontIndex;
                }
            }

        }
        if(s.charAt(s.length()-2)==s.charAt(s.length()-1)) {
            if(longestPalinLength<2) {
                longestPalinLength=2;
                startPos=s.length()-2;
            }
        }
        if(longestPalinLength==0) {
            return Character.toString(s.charAt(0));
        } else {
            char[] result=new char[longestPalinLength];
            System.arraycopy(s.toCharArray(),startPos,result,0,longestPalinLength);
            return this.toString(result);
        }

    }

    private String toString(char[] result) {
        StringBuilder stringBuilder=new StringBuilder();
        for (char c:result) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
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
        int startPos=indexFro;
        int[] lenAndPos=new int[2];
        char front,next,cur;
        cur=s.charAt(indexFro+1);
        int tempfro=0,tempNex=0;
        while(indexFro>0&&indexNex<s.length()-1) {
            front=s.charAt(--indexFro);
            next=s.charAt(++indexNex);
            //tempfro=indexFro;
            //tempNex=indexNex;
            if(front==next) {
                curLen+=2;
                startPos=indexFro;
            } else {
                break;
            }
        }
        if(indexNex!=s.length()-1) {
            while(indexNex<s.length()-1) {
                if(s.charAt(++indexNex)==cur) {
                    curLen++;
                }
            }
        }else {
            while(indexFro>0) {
                if(s.charAt(--indexFro)==cur) {
                    curLen++;
                    startPos=indexFro;
                }
            }
        }
        lenAndPos[0]=curLen;
        lenAndPos[1]=startPos;
        return lenAndPos;
    }

    public static void main(String[] args) {
        String test="ccccca";
        _5_longestPalindrome longestPalindrome=new _5_longestPalindrome();
        char[] result = new char[test.length()];
        System.out.println(longestPalindrome.longestPalindrome(test));
    }
}
