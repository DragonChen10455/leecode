package template;

public class POW {
    public static int pow(int a, int n){
        int res = 1;
        while(n != 0){
            if((n & 1) == 1){
                res = res * a;
            }
            n = n >> 1;
            a = a * a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }
}
