package lesson06;

import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int size;  //количество узлов в дереве, корнем которго является аднный узел
        int height;

        public Node(K key, V value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Не может быть ключа со значением Null");
        }
        root = put(root, key, value);
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public boolean contains(K key) {
        return get(root, key) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else  {
            return node.height;
        }
    }

    private V get(Node node, K key) {
        if (key == null) {
            throw new IllegalArgumentException("Не может быть ключа со значением Null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1, 0);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = (height(node.left) > height(node.right) ? height(node.left) : height(node.right)) + 1;
        return node;
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0 ) {
            node.right = delete(node.right, key);
        } else  {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tmp = node;
            node = max(node.left);
            node.left = deleteMax(tmp.left);
            node.right = tmp.right;
            tmp.left = null;
            tmp.right = null;
        }
        node.height = (height(node.left) > height(node.right) ? height(node.left) : height(node.right)) + 1;
        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    public boolean isBalanced() {
        if (isEmpty()) {
            return true;
        }
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node.left != null && node.right != null) {
            return !(Math.abs(node.left.height - node.right.height) > 1);
        } else {
            if (node.left != null) {
                return !(node.left.height > 1);
            } else {
                return !(node.right.height > 1);
            }
        }
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return min(node.right);
        }
    }
}
