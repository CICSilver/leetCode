package leet_sloutions.finished;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class _59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1, j = 0;
        while (count <= n * n) {

            for (int i = j; i < n - j; i++)
            {
                arr[j][i] = count++;
            }

            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = count++;
            }

            for (int i = n - j - 2; i >= j; i--) {
                arr[n - j - 1][i] = count++;
            }

            for (int i = n -j - 2; i > j; i--) {
                arr[i][j] = count++;
            }
            j++;
        }
        return arr;
    }

    public static void main(String[] s) {
        _59_generateMatrix test=new _59_generateMatrix();
        int[][] matrix=test.generateMatrix(5);
        for (int[] row:matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
