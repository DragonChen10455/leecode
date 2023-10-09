package zzz_everyday;

import java.util.Arrays;

public class SplitNum {
    public int splitNum(int num) {
        char[] charNum = String.valueOf(num).toCharArray();
        Arrays.sort(charNum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < charNum.length; i++) {
            if(i % 2 == 0) {
                num1 = num1 * 10 + charNum[i] - '0';
            } else {
                num2 = num2 * 10 + charNum[i] - '0';
            }
        }
        return num1 + num2;
    }
}
