package template;

public class GCD_LCM {
    public static int gcd(int a, int b){
        if(a == 0 || b == 0) return 0;
        while(b > 0){
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

    public static int gcd2(int a, int b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }

    public static int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 16));
        System.out.println(lcm(24, 16));
    }
}
