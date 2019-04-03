package leet_sloutions.finished;

public class _362_isPowerOfThree {
    /**
     * 判断参数是否为3的幂次方
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;
    }
}
