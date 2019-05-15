package leet_sloutions.finished;


import mytools.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _94_inorderTraversal {
    //使用递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list=new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    private void inorderTraversal(TreeNode root,ArrayList<Integer> list) {
        if(root==null) {
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);

    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.left=node5;
        node4.right=node6;
        node6.right=node7;
        _94_inorderTraversal test=new _94_inorderTraversal();
        System.out.println(test.inorderTraversal(node1));
    }
}
