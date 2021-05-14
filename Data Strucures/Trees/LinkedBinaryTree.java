package DataStructures.Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //Nested node class
    public static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }


        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    // we declare a couple of instance variables for our tree implementation
    protected Node<E> root = null;
    private int size = 0;
    // getters of the two instances;
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }


    // return related elements for the passed node (left, right,parent)
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    // end of the part

    //To create a new instance of the node, we declare a factory method as below:
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /*∗ Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");

        Node<E> node = (Node<E>) p;

        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in tree");

        return node;
    }







    //---------------- nested ElementIterator class ----------------
    // This class adapts the iteration produced by positions() to return elements. ∗/
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }






    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }

        return snapshot;
    }
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        if(left(p) != null)
            preorderSubtree(left(p), snapshot);
        if(right(p) != null)
            preorderSubtree(right(p), snapshot);

    }



    public Iterable<Position<E>> inorder(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty())
            inorderSubtree(root(), snapshot);

        return snapshot;
    }
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){

        if(left(p) != null)
            inorderSubtree(left(p), snapshot);

        snapshot.add(p);

        if(right(p) != null)
            inorderSubtree(right(p), snapshot);

    }




    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }

        return snapshot;
    }
    public void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if(left(p) != null)
            postorderSubtree(left(p), snapshot);
        if(right(p) != null)
            postorderSubtree(right(p), snapshot);
        snapshot.add(p);
    }


    public Iterable<Position<E>> breadthFirst(){
        List<Position<E>> snapshot = new ArrayList<>();

        if(!isEmpty()) {
            Queue<Position<E>> queue = new ConcurrentLinkedQueue<>();
            queue.offer(root());
            while (!queue.isEmpty()) {
                Position<E> p = queue.remove();
                snapshot.add(p);
                if(left(p) != null)
                    queue.offer(left(p));
                if(right(p) != null)
                    queue.offer(right(p));
            }
        }

        return snapshot;
    }




    /*∗∗ Places element e at the root of an empty tree and returns its new Position. ∗*/
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException();
        } else {
            root = new Node<E>(e, null, null, null);
            size = 1;
            return root;
        }
    }

    /*∗∗ Creates a new left child of Position p storing element e; returns its Position. ∗*/
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalStateException();
        } else {
            Node<E> child = new Node<E>(e, parent, null, null);
            parent.setLeft(child);
            size++;
            return child;
        }
    }

    /*∗∗ Creates a new Right child of Position p storing element e; returns its Position. ∗*/
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalStateException();
        } else {
            Node<E> child = new Node<E>(e, parent, null, null);
            parent.setRight(child);
            size++;
            return child;
        }
    }

    /*∗∗ Replaces the element at Position p with e and returns the replaced element. ∗*/
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E perivousElement = node.getElement();
        node.setElement(e);
        return perivousElement;
    }

    /*∗∗ Attaches trees t1 and t2 as left and right subtrees of external p. ∗*/
    /*public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.size = 0;
            t1.root = null;
        }
        if (!t2.isEmpty()) {
            node.setRight(t2.root);
            t2.root.setParent(node);
            t2.size = 0;
            t2.root = null;
        }

    }*/

    /*∗∗ Removes the node at Position p and replaces it with its child, if any. ∗*/
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); // child’s grandparent becomes its parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> integers=new LinkedBinaryTree<>();
        Position<Integer> root=integers.addRoot(8);
        Position <Integer> root_left=integers.addLeft(root,7);
        Position <Integer> root_right=integers.addRight(root,9);
        for (Position<Integer> i:integers.preorder()){
            System.out.println(i.getElement());
        }


    }
}