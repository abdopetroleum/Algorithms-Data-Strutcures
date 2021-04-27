package DataStructures.Stacks;

import java.util.LinkedList;

public class LinkedStack<E> extends MyStack<E> {
    private LinkedList<E> list = new LinkedList<>(); // an empty list
    public LinkedStack() {
    } // new stack relies on the initially empty list
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public void push(E element) {
        list.addFirst(element);
    }
    @Override
    public E top() {
        return list.getFirst();
    }
    @Override
    public E pop() {
        return list.removeFirst();
    }
}
