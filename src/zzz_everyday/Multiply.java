package zzz_everyday;

public class Multiply {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder[] tmpResArray = new StringBuilder[n2];
        for (int i = 0; i < n2; i++) {
            tmpResArray[i] = new StringBuilder();
        }
        for(int i = 0;i < n2;i++){
            for(int j = 0;j < i;j++){
                tmpResArray[i].append("0");
            }
        }
        for(int i = n2 - 1;i >= 0;i--){
            int overflow = 0;
            for(int j = n1 - 1;j >= 0;j--){
                int multi = Integer.parseInt(String.valueOf(num1.charAt(j))) *
                        Integer.parseInt(String.valueOf(num2.charAt(i))) + overflow;
                overflow = multi / 10;
                tmpResArray[n2-i-1].append(multi % 10);
            }
            if(overflow > 0) {
                tmpResArray[n2-i-1].append(overflow);
            }
        }
        int maxLen = 0;
        for (int i = 0; i < n2; i++) {
            maxLen = Math.max(maxLen, tmpResArray[i].length());
        }
        for (int i = 0; i < n2; i++) {
            for(int cnt = tmpResArray[i].length(); cnt < maxLen;cnt++){
                tmpResArray[i].append("0");
            }
        }
        StringBuilder res = new StringBuilder();
        int overflow = 0;
        for(int i = 0;i < maxLen;i++){
            int sum = 0;
            for(int j = 0;j < n2;j++){
                sum += tmpResArray[j].charAt(i) - '0';
            }
            sum += overflow;
            overflow = sum / 10;
            res.append(sum % 10);
        }
        if(overflow > 0){
            res.append(overflow);
        }
        res.reverse();
        int k = 0;
        while (k < res.length() - 1 && res.charAt(k) == '0') k++;
        return res.substring(k);
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "999"));
    }
}
