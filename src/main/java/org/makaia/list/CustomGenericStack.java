package org.makaia.list;

import java.util.Optional;

public class CustomGenericStack<T> {

    private Node top;
    private int size;

    public CustomGenericStack() {
        this.size = 0;
        this.top = null;
    }

    //   top
    //                      aux
    // [ node3 -> node2  -> node1 ]
    public void push(T value) {
        Node newNode = new Node(value);
        if (top != null) {
            newNode.setNext(top);
        }
        top = newNode;
        size++;
    }

    public T pop() {
        if( top == null ){
            throw new IllegalArgumentException("stack is empty");
        }

        T topValue = top.value;

        if ( top.next == null ) {
            top = null;
        } else {
            top = top.next;
        }

        size--;
        return topValue;
    }

    public Optional<T> search(T valueToSearch) {
        if( top == null ){
            throw new IllegalArgumentException("stack is empty");
        }

        Node aux = top;
        for ( int i = 0; i < size; i++ ) {
            if (aux.value.equals(valueToSearch)) {
                return Optional.ofNullable(aux.value);
            }
            aux = getNext(aux);
        }

        return Optional.empty();
    }

    private Node getNext(Node aux) {
        return aux.next;
    }

    private class Node {
        private T value;
        private Node next;
        public Node(T value) {
            this.value = value;
        }
        public void setNext(Node next) {
            this.next = next;
        }

    }
}
