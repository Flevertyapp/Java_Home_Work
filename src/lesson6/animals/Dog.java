package lesson6.animals;

public class Dog extends Animals {

    int maxRun;
    int maxSwim;
    boolean canSwim;

    public Dog (String name) {
        super(name);
        maxRun = 500;
        maxSwim = 10;
        canSwim = true;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }

    public boolean isCanSwim() {
        return canSwim;
    }
}