package mytools.stringmatch;

public class BF {
    /**
     * 暴力匹配算法,若
     * txt.length() == m
     * pat.length() == n
     * 则时间复杂度为O(mn)
     * 返回趟数、比较次数、匹配位置
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
        int count=0;
        int i=0,j=0;
        while(i<txt.length() && j<pat.length()) {

            //System.out.println("在主文本中，当前匹配位置为:"+txt.charAt(i)+","+"index:"+i+"\n"+"  模式串中位置为"+pat.charAt(j)+","+"index:"+j);

            if(txt.charAt(i)!=pat.charAt(j)) {
                i=i-j+1;
                j=0;
            } else  {
                i++;
                j++;
            }
            count++;
        }
        if(j==pat.length()) {
            System.out.println("比较的趟数为:"+count);
            return i-j;
        }
        return -1;
    }
}
