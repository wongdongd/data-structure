package datastruct;

/**
 * Doubly-linked list implementation of the List and Deque interfaces.
 * Implements all optional list operations, and permits all elements (including null).
 *
 * List和Deque接口的 双向链表实现，实现了list的所有操作，并且允许包含null在内的所有元素。
 *
 * All of the operations perform as could be expected for a doubly-linked list.
 * Operations that index into the list will traverse the list from the beginning or the end,
 * whichever is closer to the specified index.
 *
 * 所有的操作都可以像双向链表一样进行。
 * 对list中index的操作将从离该index更近的头部或者尾部来遍历list。
 */
public class myLinkedList {

    static class Node{
        private Node prev;
        private Node next;
        private Object data;

        public Node(Node prev, Node next, Object data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(Object obj){
        Node newNode = new Node(obj);
        if (first == null){
            first = newNode;
            last = newNode;
        }else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(Object obj){
        Node node = new Node(obj);
        if (last == null){
            first = node;
            last = node;
        }else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * 默认向链表后添加元素
     * @param obj
     */
    public void add(Object obj){
        addLast(obj);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * 如果存在指定元素，移除首次出现的该元素。
     * If this list does not contain the element, it is unchanged.
     * 如果不存在，list不变
     * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))
     * (if such an element exists).
     * 更正式的来讲，就是如果存在o，就移除满足条件(o==null ? get(i)==null : o.equals(get(i))最小的下标i
     * Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
     * 如果list包含指定元素返回true
     * @param o
     */
    public boolean remove(Object o){
        if (o == null){
            for (Node n =first; n!= null; n = n.next){
                if (n.data == null){
                    unlink(n);
                    return true;
                }
            }
        }
        for (Node n =first; n!= null; n = n.next){
            if (n.data.equals(o)){
                unlink(n);
                return true;
            }
        }
        return false;
    }

    public void unlink(Node n){
        Node prev = n.prev;
        Node next = n.next;

        if (prev == null){
            first = next;
        }else {
            prev.next = next;
        }

        if (next == null){
            last = prev;
        }else {
            next.prev = prev;
        }
        size--;
    }

    /**
     * 按照索引大小选择查找方向
     * @param index
     * @return
     */
    public Object get(int index){
        if (index < 0 || index >=size)
            throw new IndexOutOfBoundsException();
        if (index < (size >> 1)){
            Node x = first;
            for (int i=0; i<index;i++)
                x = x.next;
            return x.data;
        }else {
            Node x = last;
            for (int i=size-1;i>index;i--)
                x = x.prev;
            return x.data;
        }
    }
    public void print(){
        for (Node n =first; n!= null; n = n.next){
            System.out.printf(n.data.toString());
        }
    }
}
