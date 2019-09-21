
public class BST<Value extends Comparable<Value>> {
    public int searchCounts;
    private Node root;

    /**
     * 内部结点类
     */
    class Node{
        private Value val;
        private Node left,right;

        /**
         * 该节点为根的树中的节点个数
         */
        private int size;

        Node(Value val,int size) {
            this.val=val;
            this.size=size;
        }

    }

    public BST(){}

    /**
     * 有序插入值
     * @param val 所需插入的值
     */
    public void put(Value val) {
        if(val==null) {
            return;
        }
        root=put(root,val);
    }

    /**
     * 辅助方法，递归查找适合的插入位置，递归出口即当前结点为null，此时的结点位置即适合插入的位置
     * @param x 当前结点位置
     * @param val   需要插入的值
     * @return  合适或逼近合适的结点位置
     */
    private Node put(Node x,Value val) {
        if(x==null) {
            return new Node(val,1);
        }
        int cmp=val.compareTo(x.val);
        if(cmp<0) {
            x.left=put(x.left,val);
        }
        if(cmp>0) {
            x.right=put(x.right,val);
        }
        x.size=size(x.left)+size(x.right)+1;
        return x;
    }

    /**
     * 获取二叉树的当前大小
     * @return  大小
     */
    public int size() {return size(root);}

    /**
     * 获取指定结点为根结点时，其子结点个数
     * @param node  指定结点
     * @return  子结点个数
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    /**
     * 查找某指定值是否存在于二叉树中
     * @param val   指定值
     * @return  true or false
     */
    public boolean contains(Value val) {
        searchCounts=0;
        return contains(root,val);
    }

    /**
     * 遍历查找各指定结点的值是否等于指定值,递归出口为当前结点与cmp值，若结点为null则该分支未找到，
     * 若cmp==0则该结点即所需查找的值
     * @param x 指定结点
     * @param val   指定值
     * @return  true or false
     */
    private boolean contains(Node x, Value val) {
        searchCounts++;
        if(x==null) {
            return false;
        }
        int cmp=val.compareTo(x.val);
        if(cmp<0) {
            return  contains(x.left,val);
        }else if(cmp>0){
            return  contains(x.right,val);
        }else {
            return true;
        }
    }


    /**
     * 测试
     */
    public static void main(String[] s){
        BST<Integer> bst=new BST<>();
        int[] nums={54,18,12,81,99,36,12,76,57,6,66,40};
        for(int i:nums) {
            bst.put(i);
        }
        System.out.println(bst.contains(36)+","+bst.searchCounts);
    }
}
