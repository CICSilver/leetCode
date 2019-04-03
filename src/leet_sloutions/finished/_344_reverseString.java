package leet_sloutions.finished;

public class _344_reverseString {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[]
     * 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1)
     * 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     */
    public String reverseString(String s) {
        if(s==null) return s;
        char[] c=s.toCharArray();
        int len=c.length;
        for(int i=0;i<len/2;i++) {
            char temp=c[i];
            c[i]=c[len-1-i];
            c[len-1-i]=temp;
        }
        return String.valueOf(c);
    }
}
