package DataStructures.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class Traversal {

    /**
     * 前序遍历递归
     *
     * @param root
     */
    public void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    /**
     * 前序遍历非递归
     *
     * @param root
     */
    public void preOderNoRecursive(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    /**
     * 中序遍历递归
     *
     * @param root
     */
    public void inOderRecursive(TreeNode root) {
        if (root != null) {
            inOderRecursive(root.left);
            System.out.println(root);
            inOderRecursive(root.right);
        }
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     */
    public void inOrderNoRecursive(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    /**
     * 后序遍历递归
     *
     * @param root
     */
    public void postOrderRecursive(TreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 后序遍历非递归
     */
    public void postOrderNoRecursive(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) { // 找出后序遍历的逆序存在s2中
            TreeNode node = s1.pop();
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
            s2.push(node);
        }
        while (!s2.isEmpty()) {
            TreeNode node = s2.pop();
            System.out.println(node.val);
        }
    }

    /**
     * 层序遍历
     */
    public void levelTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }
}
