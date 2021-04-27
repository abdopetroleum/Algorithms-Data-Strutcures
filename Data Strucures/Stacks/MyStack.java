package DataStructures.Stacks;

public abstract class MyStack<E> implements StackADT<E> {
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

}
