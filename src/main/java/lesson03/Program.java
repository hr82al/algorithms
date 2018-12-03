package lesson03;

public class Program {
    public static void main(String[] args) {
        System.out.println(reverse("Some string."));
        testDeque();
    }

    private static void testDeque() {
        MyArrayDeque<Integer> deque = new MyArrayDeque<>();
        System.out.println(deque);
        deque.insertLeft(1);
        System.out.println(deque);
        deque.insertLeft(2);
        System.out.println(deque);
        deque.insertLeft(3);
        System.out.println(deque);
        deque.insertLeft(4);
        System.out.println(deque);
        deque.insertLeft(5);
        System.out.println(deque);
        deque.insertLeft(6);
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        System.out.println();
        System.out.println();

        deque.insertRight(1);
        System.out.println(deque);
        deque.insertRight(2);
        System.out.println(deque);
        deque.insertRight(3);
        System.out.println(deque);
        deque.insertRight(4);
        System.out.println(deque);
        deque.insertRight(5);
        System.out.println(deque);
        deque.insertRight(6);
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
    }

    private static String reverse(String str) {
        MyArrayStack<Character> chars = new MyArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            chars.push(str.charAt(i));
        }
        StringBuilder newStr = new StringBuilder();
        while (!chars.isEmpty()) {
            newStr.append(chars.pop());
        }
        return newStr.toString();
    }
}
