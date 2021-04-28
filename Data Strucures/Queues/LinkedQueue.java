package DataStructures.Queues;
/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 */

import java.util.LinkedList;

public class LinkedQueue<E> extends MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>(); // an empty list

    public LinkedQueue() {
    } // new queue relies on the initially empty list
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }
    @Override
    public E top() {
        return list.getFirst();
    }
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
