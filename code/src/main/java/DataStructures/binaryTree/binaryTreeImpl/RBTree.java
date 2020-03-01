package DataStructures.binaryTree.binaryTreeImpl;


/**
 *  红黑树
 *      特点：
 *         1.每个节点或者是红色，或者是黑色
 *         2.根节点是黑色
 *         3.如果节点是红色的，它的子节点一定是黑色的(反之，不一定)，也就是没有连续的两个红色节点
 *         4.从根节点到叶节点或者空子节点的每条路径，必须包含相同数目的黑色节点。
 *      注意：为满足规则4，新插入的节点都是红色的，这样对于规则4的影响比较小
 *
 *      保持平衡机制：
 *          1.改变颜色
 *              新增一个红色节点，如果其父节点是红色，就把父节点以及父节点的兄弟节点都变成黑色，祖父节点如果不是根节点，就换成红色。
 *          2.左旋
 *              以一个节点作为旋转的顶端，该节点的右子节点替换该节点位置，该节点位于新节点的左子节点，该节点的右节点是原右子节点的左子节点。
 *              要求：旋转的节点必须有右子节点
 *          3.右旋
 *              要求：旋转的节点必须有左子节点
 */
public class RBTree {

    class RBNode{
        private RBNode left;
        private RBNode right;
        private RBNode parent;
        private boolean red;
        private int data;

        public RBNode(RBNode left, RBNode right, RBNode parent, boolean red, int data) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.red = red;
            this.data = data;
        }
    }

    private RBNode root;
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    public void leftRotate(RBNode x){
        RBNode y = x.right;
        //将y的左子节点赋给x的右子节点
        x.right = y.left;
        //将x赋给y左子节点的父节点(y左子节点非空时)
        if (y.left != null){
            y.left.parent = x;
        }
        //x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        if (x.parent == null){
            root = y;
        }else {
            if (x == x.parent.left)
                x.parent.left = y;
            else
                x.parent.right = y;
        }
        //将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /*
     * 右旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    public void rightRotate(RBNode y){
        RBNode x = y.left;
        //将x的右子节点赋给y的左子节点，并将y赋给x的右子节点的父节点(x的右子节点非空)
        if (x.right != null){
            x.right.parent = y;
        }

        //将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x
        x.parent = y.parent;
        if (y.parent == null){
            root = x;
        }else {
            if (y == y.parent.left)
                y.parent.left = x;
            else
                y.parent.right = y;
        }
        //将x的右子节点设为y，将y的父节点设为x
        x.right = y;
        y.parent = x;
    }

    /**
     * 先插再平衡
     * @param value
     */
    public void insert(int value){
        RBNode node = new RBNode(null,null,null,true,value);
        if (node != null){
            insert(node);
        }
    }

    public void insert(RBNode node){
        RBNode parent = root;//插入的node的父节点
        RBNode x = root;
        while (x!=null){
            parent = x;
            if (x.data > node.data){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        node.parent = parent;//找到的插入位置

        //插入parent子节点
        if (parent != null){
            if (node.data > parent.data){
                parent.right = node;
            }else {
                parent.left = node;
            }
        }else {
            root = node;
        }

        //平衡
        insertFixUp(node);
    }


    /**
     * 如果是第一次插入，由于原树为空，所以只会违反红-黑树的规则2，所以只要把根节点涂黑即可；
     * 如果插入节点的父节点是黑色的，那不会违背红-黑树的规则，什么也不需要做；
     * 但是遇到如下三种情况，我们就要开始变色和旋转了：---父节点是红色
     *      1.插入节点的父节点和其叔叔节点（祖父节点的另一个子节点）均为红色。
     *      2.插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点。
     *      3.插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的左子节点。
     * @param node
     */
    public void insertFixUp(RBNode node){
        RBNode parent,gparent;

        while((parent = node.parent)!=null && parent.red){
            //父节点是祖父节点左节点
            if (parent == parent.parent.left){
                //叔叔节点是红色
                RBNode uncle = parent.parent.right;
                if ( uncle != null && uncle.red) {
                    uncle.red = false;//把父节点和叔叔节点涂黑
                    parent.red = false;
                    parent.parent.red = true;//把祖父节点涂红
                    node = parent;//类似递归，看祖父节点的上一个是不是红色以及是红色之后祖叔叔节点情况，以此类推
                }

                //叔叔节点是黑色，且插入到右子节点
                if (node == parent.right){
                    leftRotate(parent);
                    RBNode tmp = parent;//对换node以及parent的值，准备右旋
                    parent = node;
                    node = tmp;
                }

                //叔叔节点是黑色，且插入到左子节点
                parent.red = true;
                parent.parent.red = false;
                rightRotate(parent.parent);

            }else {//父节点是祖父节点右节点,与上述完全相反
                RBNode uncle = parent.parent.left;

                if (uncle!= null && uncle.red){
                    uncle.red = false;
                    parent.red = false;
                    parent.parent.red = true;
                    continue;
                }

                if (node == parent.left){
                    rightRotate(parent);
                    RBNode tmp = parent;
                    parent = node;
                    node = tmp;
                }

                parent.red = true;
                parent.parent.red = false;
                leftRotate(parent.parent);
            }
        }
        //第一次插入
        root.red = false;
    }

}
