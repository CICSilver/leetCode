package leet_sloutions.finished;

public class _832_flipAndInvertImage {
    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1,
     * 0, 0]。
     * @param A 整型二维数组
     * @return 先水平翻转再反转
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length!=A[0].length) {
            return A;
        }
        if(A == null) {
            return A;
        }
        int left=0;
        int right=A[0].length-1;
        for (int[] ints : A) {
            while (left < right) {
                exch(left, right, ints);
                left++;
                right--;
            }
            left = 0;
            right = A[0].length - 1;
        }
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
                if(A[i][j]==0) {
                    A[i][j]=1;
                } else {
                    A[i][j]=0;
                }
            }
        }
        return A;
    }
    private void exch(int i,int j,int[] num) {
        int temp;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
