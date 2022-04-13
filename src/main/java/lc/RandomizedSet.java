package lc;

import java.util.HashMap;
import java.util.Random;

/**
 * @author hawdies
 * @date 2022/4/13
 */
public class RandomizedSet {

    private HashMap<Integer, Object> map;
    private int mapSize;
    private Random rand;

    private static final Object PRESENT = new Object();

    public RandomizedSet() {
        map = new HashMap<>();
        mapSize = 0;
        rand = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, PRESENT);
            mapSize++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            mapSize--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        int val = rand.nextInt(mapSize);
        Integer[] ins = map.keySet().toArray(new Integer[0]);

        return ins[val];
    }

}
