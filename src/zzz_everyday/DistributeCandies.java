package zzz_everyday;

import java.util.Arrays;

public class DistributeCandies {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        while(candies > 0){
            // 现在发的是第几轮
            int n = i / num_people;
            int curCandy = (i % num_people + 1) + num_people * n;
            if(candies > curCandy) {
                res[i%num_people] += curCandy;
                candies -= curCandy;
            } else {
                res[i%num_people] += candies;
                candies -= curCandy;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(60, 4)));
    }
}
