package lesson05;

import static lesson05.Pow.pow;
import static lesson05.Pow.powRec;

public class Program {
    public static void main(String[] args) {
        System.out.println("Answer is:");
        System.out.println(powRec(2, 6));
        HanoiTower.solve(4);
    }
}
