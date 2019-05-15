package leet_sloutions.finished;

import mytools.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list=new ArrayList<>();
        postorderTraversal(root,list);
        return list;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if(root==null) {
            return;
        }
        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.val);

    }
}
