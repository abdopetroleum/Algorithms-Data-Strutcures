package DataStructures.Stacks;

public interface StackADT<E> {
    int size();

    boolean isEmpty();

    E top();

    E pop();


    void push(E e);


}
