package lesson04;

import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.insertFirst(i);
        }

        for (Integer item: list) {
            System.out.println(item);
        }

        System.out.println("Through iterator on direct.");
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
