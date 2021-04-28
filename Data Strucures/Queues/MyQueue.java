package DataStructures.Queues;
public abstract class MyQueue<E> implements QueueADT<E> {
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

}