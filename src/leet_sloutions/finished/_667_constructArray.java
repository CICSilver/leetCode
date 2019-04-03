package leet_sloutions.finished;

public class _667_constructArray {
    /**
     * 给定两个整数 n 和 k，你需要实现一个数组，这个数组
     * 包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
     * ① 如果这个数组是 [a1, a2, a3, ... , an]
     * ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... ,
     * |an-1 - an|] 中应该有且仅有 k 个不同整数；.
     * ② 如果存在多种答案，你只需实现并返回其中任意一种.
     *
     * 示例 1:
     *
     * 输入: n = 3, k = 1
     * 输出: [1, 2, 3]
     * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1
     * 个不同整数 : 1
     */
    public int[] constructArray(int n, int k) {
        if(n==k||k<0||n<0) {
            return null;
        }
        int[] result=new int[n];
        int temp=1;
        int loop=k+1;
        int count=0;
        while(temp<=loop) {
            if(count%2==0) {
                result[count]=temp++;
            }
            else {
                result[count]=loop--;
            }
            count++;
        }
        temp=k+2;
        while(count<n) {
            result[count++]=temp++;
        }
        return result;
    }
}
