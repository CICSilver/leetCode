/**
 * 默认该稀疏矩阵仅存储int型数据
 * 该结构以数组下标存储行信息，以链表结点属性存储列信息与元素信息
 * 链表头结点存储于行数组中
 */
public class sparseMatrix {
    /**
     * 列结点定义
     */
    class colNode{
        //列属性
        int col;
        //值
        int val;
        colNode next;
        colNode(int col,int val){
            this.col=col;
            this.val=val;
        }
    }
    /**
     * 矩阵转化为按行单链表
     * @param matrix 输入矩阵
     * @return 按行的单链表头结点数组
     */
    private colNode[] toArray(int[][] matrix) {
        int rowLen=matrix.length,colLen=matrix[0].length;
        //按行头结点数组定义
        colNode[] row=new colNode[matrix.length];
        //构造初始的头结点数组
        for(int i=0;i<rowLen;i++) {
            for(int j=0;j<colLen;j++) {
                //在该行找到第一个不为0的元素并生成其对应的结点
                if(matrix[i][j]!=0) {
                    row[i]=new colNode(j,matrix[i][j]);
                    break;
                }
                //处理整行都未空情况，生成一个值为0的结点
                if(j==colLen-1&&matrix[i][j]==0) {
                    row[i]=new colNode(j,0);
                }
            }
        }
        //逐行连接后续节点
        for(int i=0;i<matrix.length;i++) {
            linkCols(row[i],matrix[i].length,matrix[i]);
        }
        return row;
    }

    /**
     * 连接指定行所有不为0的元素，返回最后一个不为0的元素结点
     * @param head 这一行第一个不为0的元素，即指定行的头结点
     * @param len 行长度
     * @param rowOfMatrix 指定行元素序列
     * @return 最后一个不为0的元素结点
     */
    private void linkCols(colNode head,int len,int[] rowOfMatrix) {
        int curCol=head.col;
        //判断该结点是否为该行最后一个元素，不是就列指针后移一位
        if(head.col == len-1) {
            return;
        }else {
            curCol+=1;
        }
        //判断当前行是否存在数据
        if(head.val==0) {
            return;
        }

        //定义当前结点指针
        colNode curNode=head;
        int val;
        //遍历当前行，找到头结点之后每个不为0的元素，每找到一个就连接一个
        for(;curCol<len;curCol++) {
            val=rowOfMatrix[curCol];
            if(val!=0) {
                curNode.next=new colNode(curCol,val);
                curNode=curNode.next;
            }
        }
    }

    /**
     * 两个矩阵相加
     * @param matrix1 矩阵1
     * @param matrix2 矩阵2
     * @return 相加结果
     */
    public int[][] addTwoMatrix(int[][] matrix1,int[][]matrix2) {
        colNode[] rows1=toArray(matrix1);
        colNode[] rows2=toArray(matrix2);
        int[][] result=new int[matrix1.length][matrix1[0].length];
        if(rows1.length!=rows2.length) {
            throw new IllegalArgumentException("无效参数");
        }
        for(int i=0;i<rows1.length;i++) {
            for(int j=0;j<matrix1[0].length;j++) {
                int val1=0,val2=0;
                if(rows1[i]!=null&&rows1[i].col==j) {
                    val1=rows1[i].val;
                    rows1[i]=rows1[i].next;
                }
                if(rows2[i]!=null&&rows2[i].col==j) {
                    val2=rows2[i].val;
                    rows2[i]=rows2[i].next;
                }
                result[i][j]=val1+val2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {0,0,0,0,0,5,0,0},
                {0,10,0,9,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,17,0,0},
                {0,0,0,0,0,0,0,0},
                {0,21,0,34,0,0,0,75},
                {0,0,0,0,0,0,0,0}};
        sparseMatrix sparseMatrix=new sparseMatrix();
        colNode[] res=sparseMatrix.toArray(matrix);
    }

}
