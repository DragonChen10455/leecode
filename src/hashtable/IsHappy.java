package hashtable;

import java.util.HashSet;

public class IsHappy {
    public static void main(String[] args) {
//        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> record = new HashSet<>();
        while(n != 1 && !record.contains(n)) {
            record.add(n);
            int res = 0;
            while (n / 10 != 0) {
                res += (n % 10) * (n % 10);
                n = n / 10;
            }
            res += (n % 10) * (n % 10);
            if(res == 1) return true;
            n = res;
        }
        return n == 1;
    }
}