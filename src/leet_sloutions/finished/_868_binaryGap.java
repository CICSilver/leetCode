package leet_sloutions.finished;

public class _868_binaryGap {
    /**
     * 给定一个正整数 N，找到并返回 N
     *的二进制表示中两个连续的 1 之间的最长距离。
     * 如果没有两个连续的 1，返回 0 。
     * @param N 正整数，[1,10^9]
     * @return 二进制的N中连续两个1之间最长距离
     * 101001101101
     */
    public int binaryGap(int N) {
        String strByte=Integer.toBinaryString(N);
        int resultLength=0;
        int curLength=0;
        int strLength=strByte.length();
        for(int i=0;i<strLength;i++) {
            if(strByte.charAt(i)!='1') {
                if(i==strLength-1) {
                    break;
                }
                curLength++;
            }
            else {
                if(i==0) {
                    continue;
                }
                curLength++;
                if(curLength>=resultLength) {
                    resultLength=curLength;
                }
                curLength=0;
            }

        }

        return resultLength;
    }
}
