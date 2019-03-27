package mytools.stringmatch;

public class KMP {
    /**
     * 获取子字符串的PMT数组并右移一位
     * PMT数组:即子字符串与自己进行匹配，取前缀与后缀交集的字符串的最大长度，即为该位的
     * PMT值，向右一位即
     * 得到next数组
     * next数组的第一位设定为-1仅为调用方便，无特殊含义
     */
    private static int[] getNext(char[] src) {
        int[] next=new int[src.length];
        next[0]=-1;
        int i=0,j=-1;
        while(i<src.length-1) {
            if(j == -1 || src[i] == src[j]) {
                next[++i]=++j;
            } else {
                j=next[j];
            }
        }
        return next;
    }

    /**
     * 适合字符种类较少，重复度高的字符串匹配算法。
     * 文本指针无需回退，也常用于字节流
     */
    public static int indexOf(String src, String symbol) {
        if(symbol.length()==0) {
            return 0;
        }
        if(src.length()==0) {
            return  -1;
        }
        char[] txt=src.toCharArray();
        char[] pat=symbol.toCharArray();
        int[] next= getNext(pat);
        int i=0,j=0;
        while( j<pat.length && i<txt.length) {
            if(j == -1 || txt[i] == pat[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == pat.length) {
            return i-j;
        } else {
            return -1;
        }
    }


}