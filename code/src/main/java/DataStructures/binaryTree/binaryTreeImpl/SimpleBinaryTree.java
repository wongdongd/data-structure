package DataStructures.binaryTree.binaryTreeImpl;


public class SimpleBinaryTree {

    static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        //private boolean isDelete;//为了简化删除操作，在每个节点可以定义一个标记符判断是否被删了

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode find(int key){

        TreeNode current = root;
        while (current != null){
            if (current.data > key)
                current = current.left;
            else if (current.data < key)
                current = current.right;
            else
                return current;
        }
        return null;
    }

    public boolean insert(int data){
        TreeNode node = new TreeNode(data);
        if (root == null){
            root = node;
            return true;
        }else {
            TreeNode current = root;
            while (current != null){
                if (current.data > data){
                    TreeNode parent = current;
                    current = parent.left;
                    if (current == null){
                        parent.left = node;
                        return true;
                    }
                }else {
                    TreeNode parent = current;
                    current = parent.right;
                    if (current == null){
                        parent.right = node;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void delete(int data){
        //先查到要删除的节点，同时记录下其父节点
        TreeNode current = root;
        TreeNode parent =root;
        boolean isLeft = false;

        while (current.data != data){
            parent = current;
            if (current.data > data){
                isLeft = true;
                current = current.left;
            }else{
                current = current.right;
            }
            if (current == null)
                return;
        }

        //当找到的节点current没有子节点时
        if (current.left == null && current.right == null){
            if (current == root){
                root = null;
            }
            else if (isLeft){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }
        //当节点有一个子节点时
        if (current.left != null && current.right==null){
            if (current == null){
                root = current.left;
            }else if (isLeft){
                parent.left = current.left;
            }else {
                parent.right = current.left;
            }
        }else {
            if (current == null){
                root = current.right;
            }else if (isLeft){
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }
        }

        TreeNode successor = getSuccessor(current);
        if (current== root){
            root = null;
        }else if (isLeft){
            parent.left = successor;
        }else {
            parent.right = successor;
        }
        successor.left = current.left;

    }
    public TreeNode getSuccessor(TreeNode delNode){
        TreeNode successor = delNode;
        TreeNode successorParent = delNode;
        TreeNode current = delNode.right;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != delNode.right){
            successor.right = delNode.right;
            successorParent.left = successor.right;

        }
        return successor;
    }

    //前序遍历
    public void preDisplay(TreeNode node){
        if (node != null){
            System.out.println(node.data);
            preDisplay(node.left);
            preDisplay(node.right);
        }
    }
    //中序遍历
    public void inDisplay(TreeNode node){
        if (node != null){
            inDisplay(node.left);
            System.out.println(node.data);
            inDisplay(node.right);
        }
    }
    //后序遍历
    public void lastDisplay(TreeNode node){
        if (node != null){
            lastDisplay(node.left);
            lastDisplay(node.right);
            System.out.println(node.data);
        }
    }

    //找最小值
    public int findMin(){
        TreeNode current = root;
        int min = root.data;
        while (current != null){
            min = current.data;
            current = current.left;
        }
        return min;
    }


}
