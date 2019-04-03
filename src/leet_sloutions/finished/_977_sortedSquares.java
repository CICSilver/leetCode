package leet_sloutions.finished;

import mytools.sort.Sort;

public class _977_sortedSquares {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求
     * 也按非递减顺序排序。
     */
    public int[] sortedSquares(int[] A) {
        if(A.length == 0) {
            return A;
        }
        for(int i=0;i<A.length;i++) {
            A[i]*=A[i];
        }
        return Sort.quickSort(A);
    }
}
