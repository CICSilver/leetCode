import mytools.node.TreeNode;

public class binarySortTree {

    class Node{
        private int val;
        private Node left;
        private Node right;

        Node(int val,Node left,Node right) {
            this.val=val;
            this.left=left;
            this.right=right;
        }

        public void beLeftOf(Node fath) {
            fath.left=this;
        }

        public void beRightOf(Node fath) {
            fath.right=this;
        }
    }
    private int size;

    public binarySortTree(){
        this.size=0;
    }

    public binarySortTree(int[] nums) {
        if(nums == null) {
            size=0;
            return;
        }
        if (nums.length == 1) {
            size=1;
            Node root=new Node(nums[0],null,null);
            return;
        }

        Node root=new Node(nums[0],null,null);
        for(int i=1;i<nums.length;i++) {

        }
    }
}
