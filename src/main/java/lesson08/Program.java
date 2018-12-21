package lesson08;

/*
Создать программу, реализующую метод цепочек.
 */
import java.util.Random;

public class Program {
    static Random random = new Random();

    public static void main(String[] args) {
        LinearProbingHashTable<Integer, Character> ht= new LinearProbingHashTable<>();
        System.out.println(ht);
        ht.put(5, 'c');
        System.out.println(ht);
        ht.put(7,'k');
        ht.put(2, 'j');
        System.out.println(ht);
        System.out.println(ht.get(2));
        ht.put(12,'d');
        ht.put(323,'f');
        ht.put(2311,'s');
        System.out.println(ht);
        int j;
        Character c;
        for (int i = 0; i < 40; i++) {
            j = random.nextInt();
            c = (Character) randomChar();
            System.out.println(j + ": " + c);
            ht.put(random.nextInt(), randomChar());
            System.out.println(ht);
            System.out.println("size: " + ht.size());
        }
        System.out.println(ht);
    }

    public static char randomChar() {
        return (char) (random.nextInt(26) + 'a');
    }
}
