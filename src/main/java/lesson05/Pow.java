package lesson05;

public class Pow {
    public static int pow(int n, int power) {
        if (power == 0) {
            return 1;
        }
        int result = n;
        for (int i = 1; i < power; i++) {
            result *= n;
        }
        return result;
    }

    public static int powRec(int n, int power) {
        if (power == 0) {
            return n;
        } else return powI(n, power);
    }

    private static int powI(int n, int power) {
        if (power == 1) {
            return n;
        } else if (power % 2 == 0) {
            int tmp = powRec(n, power / 2);
            return tmp * tmp;
        } else {
            return n * powRec(n, power - 1);
        }
    }
}
