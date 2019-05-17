package leet_sloutions.finished;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class _70_climbStairs {
    public int climbStairs(int n) {
        int[] arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=-1;
        }
        return climbStairs(n,arr);
    }

    private int climbStairs(int n,int[] arr) {
        int subScript=n-1;
        if(n<=2) {
            arr[subScript]=n;
        }
        if(arr[subScript] == -1) {
            arr[subScript] = climbStairs(n - 2, arr) + climbStairs(n - 1, arr);
        }
        return arr[subScript];
    }

    public static void main(String[] args) {
        _70_climbStairs test=new _70_climbStairs();
        System.out.println(test.climbStairs(10));
    }
}