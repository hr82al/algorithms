package lesson04;

public class MyLinkedQueue<T> {
    private MyLinkedList<T> queue = new MyLinkedList<>();

    public void enqueue(T item) {
        queue.insertLast(item);
    }

    public T dequeue() {
        return queue.deleteFirst();
    }

    public T peek() {
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
