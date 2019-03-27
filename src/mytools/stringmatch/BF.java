package mytools.stringmatch;

public class BF {
    /**
     * 暴力匹配算法,若
     * txt.length() == m
     * pat.length() == n
     * 则时间复杂度为O(mn)
     * @param txt 主文本
     * @param pat 模式字符串
     * @return 模式字符串在主文本中开始出现时的位置
     */
    public static int indexOf(String txt,String pat) {
        if(pat.length()==0) {
            return 0;
        }
        if(txt.length()==0) {
            return -1;
        }
        int i=0,j=0;
        while(i<txt.length() && j<pat.length()) {
            if(txt.charAt(i)!=pat.charAt(j)) {
                i=i-j+1;
                j=0;
            } else  {
                i++;
                j++;
            }
        }
        if(j==pat.length()) {
            return i-j;
        }
        return -1;
    }
}
