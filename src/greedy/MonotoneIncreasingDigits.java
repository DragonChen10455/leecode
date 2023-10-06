package greedy;

public class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] chars = num.toCharArray();
        int start = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i-1] >= chars[i]) {
                chars[i-1]--;
                start = i;
            }
        }
        for(int i = start;i < chars.length;i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args){
        System.out.println(monotoneIncreasingDigits(101));
    }
}
