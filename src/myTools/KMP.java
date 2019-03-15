package myTools;

import java.util.Arrays;

public class KMP {
    /**
     * 获取子字符串的PMT数组并右移一位
     */
    private int[] getPMT(char[] src) {
        int[] next=new int[src.length];
        next[0]=-1;
        int i=0,j=-1;
        while(i<src.length-1) {
            if(j == -1 || src[i] == src[j]) {
                ++i;
                ++j;
                next[i]=j;
            } else {
                j=next[j];
            }
        }
        return next;
    }
    /**
     * 使用KMP算法在指定字符串中寻找特定子字符串
     */
    public int IndexOf(String src,String symbol) {
        if(symbol.length()==0) {
            return 0;
        }
        char[] charSrc=src.toCharArray();
        char[] charSymbol=symbol.toCharArray();
        int[] next=getPMT(charSymbol);
        int startNum=0;
        int i=0,j=0;
        while( j<charSymbol.length && i<charSrc.length) {
            if(j == -1 || charSrc[i] == charSymbol[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
                if(j == charSymbol.length) {
                    return i-j;
                } else {
                    return -1;
                }
    }

    public static void main(String[] args) {
        KMP kmp=new KMP();
        System.out.println(Arrays.toString(kmp.getPMT("abab".toCharArray())));

    }

}