public class sparseMatrix {
    class colNode{
        int col;
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
        int val=0;
        colNode[] head=new colNode[matrix.length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]!=0) {
                    head[i]=new colNode(j,matrix[i][j]);
                    break;
                }
                if(j==matrix[0].length-1&&matrix[i][j]==0) {
                    head[i]=new colNode(j,0);
                }
            }
        }

        for(int i=0;i<matrix.length;i++) {
            linkCols(i,head[i],matrix[i].length,matrix[i]);
        }
        return head;
    }

    /**
     * 连接指定行所有不为0的元素，返回最后一个不为0的元素结点
     * @param row 指定行
     * @param head 这一行第一个不为0的元素，即指定行的头结点
     * @param len 行长度
     * @param rowOfMatrix 指定行元素序列
     * @return 最后一个部位0的元素结点
     */
    private colNode linkCols(int row,colNode head,int len,int[] rowOfMatrix) {
        int curCol=head.col;
        if(head.col!=len-1) {
            curCol+=1;
        }
        if(head.val==0) {
            return head;
        }
        colNode curNode=head;
        int val;
        for(;curCol<len;curCol++) {
            val=rowOfMatrix[curCol];
            if(val!=0) {
                curNode.next=new colNode(curCol,val);
                curNode=curNode.next;
            }
        }
        return curNode;
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
        int[][] matrix={{0,1,0,0,1},{1,0,2,3,0},{0,0,0,2,0},{0,0,0,0,0}};
        int[][] matrix2={{1,0,1,1,0},{2,3,1,0,3},{2,2,2,0,2}};
        sparseMatrix sparseMatrix=new sparseMatrix();
        colNode[] test=sparseMatrix.toArray(matrix2);
        int[][] result=sparseMatrix.addTwoMatrix(matrix,matrix2);
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println();
        }
    }

}
