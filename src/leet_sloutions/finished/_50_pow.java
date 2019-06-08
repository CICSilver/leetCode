package leet_sloutions.finished;


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class _50_pow {
    public int count=0;
    public double myPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        double cur=myPow(x,n/2);
        count++;
        if(n%2==0) {
            return cur*cur;
        }
        if(n>0) {
            return cur*cur*x;
        }
        return cur*cur/x;
    }

    public static void main(String[] s){
        _50_pow te=new _50_pow();
        System.out.println(te.myPow(2,10000)+" ,计算次数为："+te.count);
        //System.out.println(logAlgorithm.log(1000,10));

    }


}
