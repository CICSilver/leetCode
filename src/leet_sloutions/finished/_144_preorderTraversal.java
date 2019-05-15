package leet_sloutions.finished;


import mytools.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_preorderTraversal {
    //递归版先序
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        return new ArrayList<>() {
            {
                if (root != null) {
                    add(root.val);
                    addAll(preorderTraversalRecursive(root.left));
                    addAll(preorderTraversalRecursive(root.right));
                }
            }
        };
    }
    //非递归版先序
    public List<Integer> preorderTraversalNoRecursive(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node=stack.pop();
            res.add(node.val);
            if(node.right!=null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    private boolean isLeaf(TreeNode x) {
        return x.left==null&&x.right==null;
    }
}
