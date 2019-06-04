package leet_sloutions.finished;

import java.util.*;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class _976_LargestPerimeterTriangle {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int res=0;
        for(int i=A.length-1;i>=2;i--) {
            if(isTriangle(A[i],A[i-1],A[i-2])) {
                res=Math.max(res,(A[i]+A[i-1]+A[i-2]));
            }
        }
        return res;
    }

    private boolean isTriangle(int c,int b,int a){
        return a+b>c && a+c>b && b+c>a;
    }

    public static void main(String[] s) {
        int[] temp={3,9,2,5,2,19};
        _976_LargestPerimeterTriangle test=new _976_LargestPerimeterTriangle();
        System.out.println(test.largestPerimeter(temp));
    }
}
