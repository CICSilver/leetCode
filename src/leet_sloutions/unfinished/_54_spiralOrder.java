package leet_sloutions.unfinished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class _54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<>();
        int size=matrix[0].length*matrix.length;
        while(size>0){
            int i=0,j=0;
            try{
                if(matrix[i][i]!=Integer.MIN_VALUE) {
                    arr.add(matrix[i][j]);
                    size--;
                }
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }
        return arr;
    }

    private void rowAssignment (int i, int j, int[][] matrix,
                                List<Integer> arr, boolean isOrder) throws ArrayIndexOutOfBoundsException {
        if(isOrder) {
            while (true) {
                arr.add(matrix[i][j]);
                matrix[i][j++]=Integer.MIN_VALUE;
            }
        }else {
            while (true) {
                arr.add(matrix[i][--j]);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                        { 1, 2 ,3 ,4 ,5},
                        {16,17,18,19, 6},
                        {15,24,25,20, 7},
                        {14,23,22,21, 8},
                        {13,12,11,10, 9}
        };
        int[][] matrix2={
                { 1, 2, 3, 4},
                {10,11,12, 5},
                { 9, 8, 7, 6}};
        _54_spiralOrder test=new _54_spiralOrder();
        List<Integer> arr=test.spiralOrder(matrix2);
        System.out.println(Arrays.toString(arr.toArray()));
    }
}
