package DataStructures.Trees;
import java.util.Iterator;
public interface Tree<E> extends Iterable<E> {
    int size();
    Position<E> root();

    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    Iterator<E> iterator();
    Iterable<Position<E>> positions();


    //implemented by Abstract binary Tree
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p) throws IllegalArgumentException;



    //implemented by Abstract Tree
    boolean isEmpty();
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    public int depth(Position<E> p);
    public int height(Position<E> p);



}