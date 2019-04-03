package leet_sloutions.finished;

public class _461_hammingDistance {
    /**
     * 汉明距离：两数二进制位不同位的个数
     * @param x 整数
     * @param y 整数
     * @return 两数的汉明距离
     */
    public int hammingDistance(int x, int y) {
        String str=Integer.toBinaryString(x^y);
        int count=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='1') {
                count++;
            }
        }
        return count;
    }
}
