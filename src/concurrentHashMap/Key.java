package concurrentHashMap;

import java.util.Random;

public class Key {
    private static Random random = new Random();
    private int intField = random.nextInt(5) + 1;

    public int getIntField() {
        return intField;
    }

    @Override
    public int hashCode() {
        return intField;
    }

    @Override
    public String toString() {
        return "" + intField;
    }
}
