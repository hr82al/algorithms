package lesson08;

public class LinearProbingHashTable<K,V> {
    private int M = 3;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(K key) {
        return get(key) == null;
    }

    public V get(K key) {
        validateKey(key);
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((K)keys[i]).equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public void put(K key, V value){
        validateKey(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((K)keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size == M - 1){
            int tmpM = M;
            M = nextPrime(M * 2);
            Object[] tmpKeys = keys;
            Object[] tmpValues = values;
            keys = new Object[M];
            values = new Object[M];
            size = 0;
            for (int j = 0; j < tmpM; j++) {
                if (tmpKeys[j] != null) {
                    put((K) tmpKeys[j], (V) tmpValues[j]);
                }
            }
            put(key, value);
            return;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    private void validateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
    }

    private boolean isPrime(int num) {
        if (num > 1) {
            for (int i = 2; i < num / 2; i++) {
                if ((num % i) == 0) return false;
            }
            return true;
        }
        return false;
    }

    private int nextPrime(int num) {
        while (!isPrime(num)) {
            num++;
        }
        System.out.println("prime " + num);
        return num;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuilder s = new StringBuilder();
        s.append("{ ");
        for (int i = 0; i < M ; i++) {
            if (keys[i] != null) {
                s.append(keyValueByIndex(i));
                s.append("; ");
            }
        }
        s.append("}");
        return s.toString();
    }

    private String keyValueByIndex(int index) {
        return keys[index] + ": " + values[index];
    }
}
