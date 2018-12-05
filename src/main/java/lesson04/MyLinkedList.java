package lesson04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node first = null;
    private Node last = null;

    private class Node {
        T item;
        Node previous;
        Node next;

        public Node(T item, Node previous, Node next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    public void insertFirst(T item) {
        Node oldFirst = first;
        first = new Node(item, null, oldFirst);
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.previous = first;
        }
        size++;
    }

    public T deleteFirst() {
         if (isEmpty()) {
             throw new NoSuchElementException();
         }
         T item = first.item;
         Node oldFirst = first;
         first = first.next;
         oldFirst.next = null;
         size--;
         if (isEmpty()) {
             last = null;
         }
         else {
             first.previous = null;
         }
         return item;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public void insertLast(T item) {
        Node oldLast = last;
        last = new Node(item, oldLast, null);
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public T deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = last.item;
        Node oldLast = last;
        last = last.previous;
        oldLast.previous = null;
        size--;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.item = item;
    }

    public boolean find(T item) {
        Node current = first;
        while (current != null && !current.item.equals((item))) {
            current = current.next;
        }
        return current != null;
    }

    public T delete(T item) {
        Node current = first;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return  null;
        }
        if (current == first) {
            return deleteFirst();
        } else if( current == last) {
            return deleteLast();
        }
        current.previous = current.next;
        current.next = current.previous;
        current.previous = null;
        current.next = null;
        size--;
        return current.item;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new NullPointerException();
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        else if (index == size) {
            insertLast(item);
            return;
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node newNode = new Node(item, current.previous, current);
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
