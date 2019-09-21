package leet_sloutions.finished;

import com.sun.source.tree.Tree;
import mytools.node.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */
public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) &&
                isMirror(root1.left,root2.right) &&
                isMirror(root1.right,root2.left);
    }

}
