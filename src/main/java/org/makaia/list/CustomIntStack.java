package org.makaia.list;

public class CustomIntStack {

    private Node top;
    private int size;

    public CustomIntStack() {
        this.size = 0;
        this.top = null;
    }

    //   top
    //                      aux
    // [ node3 -> node2  -> node1 ]
    public void push(int value) {
        Node newNode = new Node(value);
        if (top != null) {
            newNode.setNext(top);
        }
        top = newNode;
        size++;
    }

    public int pop() {
        if( top == null ){
            throw new IllegalArgumentException("stack is empty");
        }

        int topValue = top.value;

        if ( top.next == null ) {
            top = null;
        } else {
            top = top.next;
        }

        size--;
        return topValue;
    }

    public int search(int valueToSearch) {
        if( top == null ){
            throw new IllegalArgumentException("stack is empty");
        }

        Node aux = top;
        for ( int i = 0; i < size; i++ ) {
            if (aux.value == valueToSearch) {
                return aux.value;
            }
            aux = getNext(aux);
        }

        return -1;
    }

    private static Node getNext(Node aux) {
        return aux.next;
    }

    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public void setNext(Node next) {
            this.next = next;
        }

    }
}
