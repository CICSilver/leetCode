package mytools.stringmatch;

public class BM {
    private static int[] getTable(String str) {
        int[] table=new int[256];
        for(int i=0;i<str.length();i++) {
            table[str.charAt(i)]=i;
        }
        return table;
    }

    /**
     * boyer-moore算法，后指针启发式匹配算法，时间复杂度一般为亚线性
     * 若txt长度为M，pat长度为N，则时间与MN成正比
     */
    public static int bm(String txt,String pat) {
        if(pat.length()==0) {
            return 0;
        }
        if(txt.length()==0) {
            return -1;
        }
        int[] table=getTable(pat);
        int txtLen=txt.length();
        int patLen=pat.length();
        int i=txtLen-1,j=patLen-1;
        while (i<txtLen) {
            while(j>=0) {
                if(pat.charAt(j)==txt.charAt(i)) {
                    return i-j;
                } else {
                    i+=table[j];
                    j=patLen-1;
                }
            }
        }
        return -1;
    }

}
