package DataStructures.Trees.PriorityQueuesPackage;

//An implementation of a priority queue using an array-based heap. ∗/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    // primary collection of priority queue entries ∗/
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    // Creates an empty priority queue based on the natural ordering of its keys. ∗/
    public HeapPriorityQueue() {
        super();
    }

    // Creates an empty priority queue using the given comparator to order keys. ∗/
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    //∗∗ Creates a priority queue initialized with the given key-value pairs. ∗/
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++)
            heap.add(new PQEntry<>(keys[j], values[j]));
        heapify();
    }

    //∗∗ Performs a bottom-up construction of the heap in linear time. ∗/
    protected void heapify() {
        int startIndex = parent(size() - 1); // start at PARENT of last entry
        for (int j = startIndex; j >= 0; j--) // loop until processing the root
            siftDown(j);
    }





        protected int parent(int j) {
        return (j - 1) / 2;
    } // truncating division

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    // Exchanges the entries at indices i and j of the array list. ∗/
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    //∗∗ Moves the entry at index j higher, if necessary, to restore the heap property. ∗/
    protected void siftUp(int j) {
        while (j > 0) { // continue until reaching root (or break statement)
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            } // heap property verified
            swap(j, p);
            j = p; // continue from the parent's location
        }
    }

    //∗∗ Moves the entry at index j lower, if necessary, to restore the heap property. ∗/
    protected void siftDown(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(rightIndex), heap.get(leftIndex)) < 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) > 0) {
                break;// heap property has been restored
            }
            swap(j, smallChildIndex);
            j = smallChildIndex; // continue at position of the child
        }
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        PQEntry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        siftUp(size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        } else {
            return heap.get(0);
        }
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> answer = heap.get(0);
        swap(0, size() - 1);
        heap.remove(size() - 1);
        siftDown(0);
        return answer;
    }

    PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer integer, Integer t1) {
            return integer.compareTo(t1);
        }
    });
}
