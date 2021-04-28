package DataStructures.Queues;

public interface QueueADT<E> {
    int size();
    boolean isEmpty();
    E top();
    E dequeue();
    void enqueue(E e);
}