package DataStructures.Trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {


    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);

        if (parent == null) return null;

        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }
    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;

        if (left(p) != null)
            count++;

        if (right(p) != null)
            count++;

        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);

        if (left(p) != null)
            snapshot.add(left(p));

        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

}