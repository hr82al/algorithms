package lesson08;

public class ChainingHashTable<K, V> {
    private int M = 97;
    private int size = 0;
    private Object[] st = new Object[M];

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        validateKey(key);
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) == null;
    }

    public void set(K key, V value) {
        validateKey(key);
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
    }

    private void validateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
    }
}
