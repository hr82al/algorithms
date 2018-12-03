package lesson03;

import java.util.NoSuchElementException;

public class MyArrayStack<T> {
    private Object[] stack = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(T item) {
        if (size == stack.length) {
            resize(stack.length * 2);
        }
        stack[size++] = item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int capacity) {
        Object tmp[] = new Object[capacity];
        System.arraycopy(stack, 0, tmp, 0, size);
        stack = tmp;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        T item = (T) stack[size];
        stack[size] = null;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) stack[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < size - 1; i++) {
            str.append(stack[i]);
            str.append(", ");
        }
        str.append(stack[size - 1]);
        str.append("}");
        return str.toString();
    }
}
