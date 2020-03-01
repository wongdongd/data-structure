import DataStructures.binaryTree.binaryTreeImpl.SimpleBinaryTree;
import datastruct.myLinkedList;

public class CommonTest {

    public static void main(String[] args) {
//        Object a = null;
//        System.out.printf(" "+ (a == null));

        myLinkedList linkedList = new myLinkedList();
        linkedList.add("s");
        linkedList.add("a");
        linkedList.addFirst("w");
        linkedList.print();

        linkedList.remove(null);
        linkedList.print();

        System.out.println(linkedList.get(1));

        SimpleBinaryTree tree = new SimpleBinaryTree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);

        tree.insert(1);
        tree.preDisplay(tree.getRoot());
    }
}
