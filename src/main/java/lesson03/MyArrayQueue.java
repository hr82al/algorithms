package lesson03;

import java.util.NoSuchElementException;

public class MyArrayQueue<T> {
    private Object[] queue = new Object[2];
    private int size = 0;
    private int start = 0;  //первый элемент в очереди
    private int end = 0;    //индекс, следующий за последним

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        queue[end++] = item;
        end %= queue.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = (T) queue[start];
        queue[start] = null;
        size--;
        start++;
        start %= queue.length;
        if (size >0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) queue[start];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{ }";
        }
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = start; i < start + size - 1; i++) {
            str.append(queue[i % queue.length]);
            str.append(", ");
        }
        str.append(queue[(start + size - 1) % queue.length]);
        str.append("}");

        return str.toString();
    }

    public void resize(int capacity) {
        Object[] tmp = new Object[capacity];

        if (start > end) {
            System.arraycopy(queue, start , tmp, 0 , queue.length - start);
            System.arraycopy(queue, 0, tmp, start, end);
        } else {
            System.arraycopy(queue, start, tmp, 0, size);
        }
        start = 0;
        end = queue.length;
        queue = tmp;
    }
}
