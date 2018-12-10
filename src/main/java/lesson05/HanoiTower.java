package lesson05;


import lesson04.MyLinkedStack;

public class HanoiTower {
    private final static int NUM_ROADS = 3;
    private int disks = 8;
    private MyLinkedStack<Integer>[] roads;

    public HanoiTower(int blocks) {
        this.disks = blocks;
        roads = new MyLinkedStack[NUM_ROADS];
        for (int i = 0; i < NUM_ROADS; i++) {
            roads[i] = new MyLinkedStack<>();
        }
        for (int diskSize = this.disks; diskSize >0 ; diskSize--) {
            roads[0].push(diskSize);
        }
    }

    public static void solve(int blocks) {
        HanoiTower hanoiTower = new HanoiTower(blocks);
        System.out.println("Hanoi tower");
        hanoiTower.show();
        hanoiTower.step(0, 1, hanoiTower.disks);
    }

    private void step(int source, int target, int size) {
        if (size == 1) {
            roads[target].push(roads[source].pop());
            show();
            return;
        } else {
            step(source, 3 - source - target, size - 1);
            step(source, target, 1);
            step(3 - source - target, target, size - 1);
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < NUM_ROADS; i++) {
            str.append(roads[i]);
        }
        return str.toString();
    }

    private void show() {
        for (int i = 0; i < NUM_ROADS; i++) {
            System.out.println(roads[i]);
        }
        System.out.println("");
    }
}
