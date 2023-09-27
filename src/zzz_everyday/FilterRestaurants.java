package zzz_everyday;

import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> restFiltered = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if(restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                restFiltered.add(restaurant);
            }
        }
        restFiltered.sort((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] rest : restFiltered) {
            res.add(rest[0]);
        }
        return res;
    }
}
