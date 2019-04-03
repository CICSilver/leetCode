package leet_sloutions.finished;

public class _48_rotate {

    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个
     * 矩阵来旋转图像。
     */
    public void rotate(int[][] matrix) {
        if(!isSquare(matrix)) {
            return;
        }
        int len=matrix.length;
        if(len==1) {
            return;
        }
        int col=len-1;
        int row=0;
        //降序排行，确定对角线位置
        while (row<(len/2)) {
            exchaArray(matrix[row], matrix[col]);
            row++;
            col--;
        }
        for (col = 0; col < len-1; col++) {
            for (row = col+1; row < len; row++) {
                exchDoubleArray(matrix, col, row, row, col);
            }
        }

    }

    /**
     * 判断是否为矩阵
     */
    private boolean isSquare(int[][] matrix) {
        int sum=0;
        for (int[] matrix1 : matrix) {
            if (matrix1.length != matrix.length) {
                return false;
            }
            sum ^= matrix1.length;
        }
        return sum == 0 || sum == matrix[0].length;
    }

    /**
     * 交换两个数组数据
     */
    private void exchaArray(int[] a, int[] b){
        if(a.length!=b.length) {
            return;
        }
        int[] temp;
        temp=a.clone();
        for(int i=0;i<a.length;i++) {
            a[i]=b[i];
            b[i]=temp[i];
        }
    }

    /**
     * 交换二维数组数据
     */
    private void exchDoubleArray(int[][] a, int i1, int j1, int i2, int j2) {
        int temp;
        temp=a[i1][j1];
        a[i1][j1]=a[i2][j2];
        a[i2][j2]=temp;
    }
}
