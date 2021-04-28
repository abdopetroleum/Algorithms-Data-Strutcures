package DataStructures.Queues;

public class ArrayQueue<E> extends MyQueue<E> {
    // instance variables
    private E[] data; // generic array used for storage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements

    // constructors
    // constructs queue with default capacity
    public ArrayQueue() {
        this(1000);
    }

    // constructs queue with given capacity
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // methods
    //** Returns the number of elements in the queue. */
    @Override
    public int size() {
        return sz;
    }



    /**
     * Inserts an element at the rear of the queue.
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length; // use modular arithmetic
         data[avail] = e;
         sz++;
    }
    @Override
    public E top() {
        if(isEmpty()){
            return null;
        }
        return data[f];
    }

    @Override
    public E dequeue() {
       if (isEmpty()){
           return null;
       }
       sz--;
       E element=data[f];
       data[f]=null;
       f=(f+1)%data.length;
       return element;
    }

}