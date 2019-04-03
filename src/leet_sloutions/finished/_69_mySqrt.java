package leet_sloutions.finished;

public class _69_mySqrt {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部
     * 分将被舍去。
     * @param x 非负整数
     * @return 平方根
     */
    public int mySqrt(int x) {
        if(x==0) {
            return 0;
        }
        return (int)Math.sqrt(x);

    }
}
