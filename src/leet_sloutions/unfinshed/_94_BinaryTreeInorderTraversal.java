package leet_sloutions.unfinshed;

import mytools.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {
    /**
     * 后序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) {
            return null;
        }
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null|| !stack.isEmpty()) {
            if(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            } else {
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(cur!=null || !stack.isEmpty()) {
            if(cur!=null) {
                stack.push(cur);
                list.add(cur.val);
                cur=cur.left;
            } else {
                cur=stack.pop();
                cur=cur.right;
            }
        }
        return list;
    }

    public static void main(String[] args){

        _94_BinaryTreeInorderTraversal test=new _94_BinaryTreeInorderTraversal();
        TreeNode root=new TreeNode(1);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t5.left=t7;
        t5.right=t8;
        t3.right=t6;

        System.out.println(test.preorderTraversal(t1));
    }
}
