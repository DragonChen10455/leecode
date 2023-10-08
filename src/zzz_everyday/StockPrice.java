package zzz_everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {
    Map<Integer, Integer> tpMap;
    TreeMap<Integer, Integer> tpTreeMap;
    int maxTimestamp;
    public StockPrice() {
        tpMap = new HashMap<>();
        tpTreeMap = new TreeMap<>();
        maxTimestamp = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        if (tpMap.containsKey(timestamp)) {
            int oldPrice = tpMap.get(timestamp);
            if (tpTreeMap.merge(oldPrice, -1, Integer::sum) == 0) {
                tpTreeMap.remove(oldPrice);
            }
        }
        tpMap.put(timestamp, price);
        maxTimestamp = Math.max(timestamp, maxTimestamp);
        tpTreeMap.merge(price, 1, Integer::sum);
    }

    public int current() {
        return tpMap.get(maxTimestamp);
    }

    public int maximum() {
        return tpTreeMap.lastKey();
    }

    public int minimum() {
        return tpTreeMap.firstKey();
    }
}
