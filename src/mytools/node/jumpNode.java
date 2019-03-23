package mytools.node;

public class jumpNode {
    public int right=0;
    public int left=0;
    jumpNode(int left,int right) {
        this.left=left;
        this.right=right;
    }
    public static jumpNode add(int left,int right) {
        jumpNode jn=new jumpNode(left,right);
        return jn;
    }
}
