package lesson03;

import java.util.NoSuchElementException;

public class MyArrayDeque<T> {
    private Object[] deque = new Object[2];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertLeft(T item) {
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        if (start == 0) {
            start = deque.length - 1;
        } else {
            start--;
        }
        deque[start] = item;
        size++;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = (T) deque[start];
        deque[start++] = null;
        start %= deque.length;
        size--;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public void insertRight(T item) {
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        deque[end++] = item;
        end %= deque.length;
        size++;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        end--;
        T item = (T) deque[end];
        deque[end] = null;
        size--;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public void resize(int capacity) {
        Object tmp[] = new Object[capacity];
        if (start >= end) {
            System.arraycopy(deque, start, tmp, 0, deque.length - start);
            System.arraycopy(deque, 0, tmp, start, end);
        } else {
            System.arraycopy(deque, start, tmp, 0, size);
        }
        start = 0;
        end = size;
        deque = tmp;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{ }";
        }
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = start; i < start + size - 1; i++) {
            str.append(deque[i % deque.length]);
            str.append(", ");
        }
        str.append(deque[(start + size - 1) % deque.length]);
        str.append("}");

        return str.toString();
    }
}
