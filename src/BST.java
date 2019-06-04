
public class BST<Value extends Comparable<Value>> {
    public int searchCounts;

    private Node root;
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

    public void put(Value val) {
        if(val==null) {
            return;
        }
        root=put(root,val);
    }

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

    public int size() {return size(root);}

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean contains(Value val) {
        searchCounts=0;
        return contains(root,val);
    }

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



    public static void main(String[] s){
        BST<Integer> bst=new BST<>();
        int[] nums={54,18,12,81,99,36,12,76,57,6,66,40};
        for(int i:nums) {
            bst.put(i);
        }
        System.out.println(bst.contains(36)+","+bst.searchCounts);
    }
}
