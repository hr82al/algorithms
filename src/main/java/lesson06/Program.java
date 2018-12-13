package lesson06;

/*1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с
глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа
int. Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
2. Проанализировать, какой процент созданных деревьев являются несбалансированными.*/

import java.util.Random;

public class Program {
    static Random random = new Random();

    public static void main(String[] args) {
        BST<Integer, Character> bst = new BST<>();
        bst.put(10, 'k');
        System.out.println(bst.height());
        bst.put(5, 'k');
        System.out.println(bst.height());
        bst.put(3, 'k');
        System.out.println(bst.height());
        bst.put(14, 'k');
        System.out.println(bst.isBalanced());
        System.out.println(bst.height());
        bst.put(12, 'k');
        System.out.println(bst.height());
        bst.put(15, 'k');
        System.out.println(bst.height());
        bst.put(17, 'k');
        System.out.println(bst.height());
        //bst.delete(14);
        System.out.println(bst.height());
        bst.delete(17);
        System.out.println(bst.height());
        System.out.println();

        generateBSTs(6);
    }

    private static void generateBSTs(int deep) {
        final int NUM = 20;
        BST<Integer, Character>[] bst = new BST[NUM];
        int balanced = 0;
        for (int i = 0; i < NUM; i++) {
            bst[i] = new BST();
            do {
                bst[i].put(nextNumber(), 'k');
            } while (bst[i].height() <= 6);
            if (bst[i].isBalanced()) {
                balanced++;
            }
        }
        System.out.println("Сбалансировыннх " + balanced + " из " + NUM);

        // При заполнение дерева случайными данными процент сбалансированных деревьев 15.
    }

    public static int nextNumber() {
        return random.nextInt(201) - 100;
    }
}
