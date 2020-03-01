package datastruct;

import java.util.*;

/**
 * Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements,
 * including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array
 * that is used internally to store the list. (This class is roughly equivalent to Vector, except that it is unsynchronized.)
 * The size, isEmpty, get, set, iterator, and listIterator operations run in constant time.
 *
 * List接口的数组实现，数组大小可调整。实现了list的所有操作，并允许操作包括null在内的所有元素。除了实现List接口，该类提供了操作数组大小的方法，该数组在内部用于存储这个list。
 * （除了非同步，这个类与Vector大致相同）。size, isEmpty, get, set, iterator, and listIterator 方法时间复杂度为常数时间O(1)。
 *
 * The add operation runs in amortized constant time, that is, adding n elements requires O(n) time.
 * All of the other operations run in linear time (roughly speaking).
 * The constant factor is low compared to that for the LinkedList implementation.
 * Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list.
 * It is always at least as large as the list size. As elements are added to an ArrayList, its capacity grows automatically.
 * The details of the growth policy are not specified beyond the fact that adding an element has constant amortized time cost.
 *
 * add操作是分摊常数时间复杂度，意味着：增加n个元素需要O(n)时间。所有其他操作是线性时间复杂度。常量因子相比LinkedList实现很低
 * 每一个ArrayList实例有一个容量，该容量是用来存储list元素的数组的大小。容量总是至少与list大小一样大。随着元素的添加，list的容量自动增加。
 * 详细的增长机制并不明确，由于添加元素要小号分摊常量时间。
 *
 * An application can increase the capacity of an ArrayList instance before adding a large number of elements using the ensureCapacity operation.
 * This may reduce the amount of incremental reallocation.
 * 可以在添加大量元素前使用ensureCapacity方法，来增加ArrayList实例的容量。
 *
 * Note that this implementation is not synchronized. If multiple threads access an ArrayList instance concurrently,
 *      and at least one of the threads modifies the list structurally, it must be synchronized externally.
 *      (A structural modification is any operation that adds or deletes one or more elements, or explicitly resizes the backing array;
 *      merely setting the value of an element is not a structural modification.) This is typically accomplished by synchronizing on
 *      some object that naturally encapsulates the list. If no such object exists, the list should be "wrapped" using the Collections.synchronizedList
 *      method. This is best done at creation time, to prevent accidental unsynchronized access to the list:
 *      List list = Collections.synchronizedList(new ArrayList(...));
 *
 *注意：这个实现不是同步的。
 *
 * The iterators returned by this class's iterator and listIterator methods are fail-fast:
 * if the list is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove or add methods,
 * the iterator will throw a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,
 * rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees
 * in the presence of unsynchronized concurrent modification. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should
 * be used only to detect bugs.
 *
 * //1.8里面添加了一个modCount，用于记录对ArrayList的操作数
 */
public class myArrayList {
    private int size;
    private Object[] elementData;

    public myArrayList(int initialSize){
        elementData = new Object[initialSize];
        size = 0;
    }

    public void add(Object o){
        ensureCapacity(size+1);
        elementData[size++] = o;
    }

    /**
     * 扩容 新的为 oldCapacity + (oldCapacity >> 1)
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        if (capacity > elementData.length){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < capacity){
                newCapacity = capacity;
            }
            if (newCapacity > Integer.MAX_VALUE-8){
                newCapacity = Integer.MAX_VALUE;
            }

            elementData = Arrays.copyOf(elementData,newCapacity);
        }
    }

    public Object get(int index){
        //可以判断是否越界
        if (index>=size){
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public int size(){
        return size;
    }

    public Object remove(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object oldValue = elementData[index];
        for (int i=index; i<size-1; i++){
            elementData[i] = elementData[i+1];
        }
        elementData[--size] = null;
        return oldValue;
    }

    public void display(){
        for (int i=0; i<size; i++){
            System.out.println(elementData[i]);
        }
    }
}
