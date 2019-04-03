package leet_sloutions.finished;

/**
 * 用KMP算法实现
 */
public class _28_strStr {

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
    public int indexOf(String src, String symbol) {
        if(symbol.length()==0) {
            return 0;
        }
        char[] charSrc=src.toCharArray();
        char[] charSymbol=symbol.toCharArray();
        int[] next=getPMT(charSymbol);
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

    public int strStr(String haystack, String needle) {
        if(haystack.length()==0&&needle.length()==0) {
            return 0;
        } else
        if(haystack.length()==0&&needle.length()!=0) {
            return -1;
        } else {
            return indexOf(haystack, needle);
        }
    }
}
