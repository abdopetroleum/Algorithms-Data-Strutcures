package DataStructures;

import javax.lang.model.element.Element;

public class MySingleLinkedList<E> {
    private static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    }
    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0;

    public MySingleLinkedList() {
    }
    public int size( ) { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()){
            return null;
        }else {
            return head.getElement();
        }
    }
    public E last() { // returns (but does not remove) the last element
        if (isEmpty()){
            return null;
        }else {
            return tail.getElement();
        }
    }
    public E getElement(int index){
        if(index>size-1){
            return null;
        }
        Node<E> myNode=head;
        for (int i=0;i<index;i++){
            myNode=myNode.getNext();
        }
        return myNode.getElement();
    }

    public void addFirst(E e) { // adds element e to the front of the list
        head=new Node<E>(e,head);
        size++;
        if (size==1){
            tail=head;
        }
    }
    public void addLast(E e) { // adds element e to the end of the list
        Node<E> node=new Node<>(e,null);
        if (isEmpty()){
            head=node;
        }else {
            tail.setNext(node);
        }
        tail=node;
        size++;
    }
    public void addAt(int postion,E e){
        if(postion>size){
            return;
        }
        if (postion==0){
            addFirst(e);
        }else if(postion==size){
            addLast(e);
        }else {
            Node<E> node=new Node<E>(e,null);
            Node<E> currentNode=head;
            for(int i=1;i<postion;i++){
                currentNode=currentNode.getNext();
            }
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
            size++;
        }
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null;
        }else {
            E e=head.element;
            head=head.getNext();
            size--;
            if(size==0){
                tail=null;
            }
            return e;
        }
    }
    public E removeLast(){
        return removeAt(size-1);
    }
    public E removeAt(int index){
        if(index>size-1){
            return null;
        }
        if (index==0){
            return removeFirst();
        }else {
            Node<E> myNode=head;
            for (int i=0;i<index-1;i++){
                myNode=myNode.getNext();
            }
            E e=myNode.getNext().getElement();
            myNode.setNext(myNode.getNext().getNext());
            if(index==size-1){
                tail=myNode;
            }
            size--;
            return e;
        }
    }

    public void reverse(){
        if (size<2){
            return;
        }else {
            Node<E> currentHead=head;
            Node<E> currentNode=head;
            Node<E> nextNode=head.getNext();
            for (int i=0;i<size-2;i++){
                nextNode=nextNode.getNext();
                currentNode.getNext().setNext(currentNode);
                currentNode=currentNode.getNext();
            }
            nextNode.setNext(currentNode);
            head=tail;
            tail=currentHead;
        }

    }
    public int search(E e){
        int postion=0;
        Node<E> currentNode= head;
        while (currentNode!=null){
            if(currentNode.getElement().equals(e)){
                return postion;
            }else {
                currentNode=currentNode.getNext();
                postion++;
            }
        }
        return -1;
    }
    public void display(){
        Node<E> node=head;
        for (int x=0;x<size;x++){
            System.out.println(node.getElement());
            node=node.getNext();
        }
    }
}
