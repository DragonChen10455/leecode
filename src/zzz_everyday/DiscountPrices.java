package zzz_everyday;

public class DiscountPrices {
    public static String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            if(!s.startsWith("$")) {
                res.append(s).append(" ");
                continue;
            }
            boolean illegal = false;
            for(int i = 1;i < s.length();i++){
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    illegal = true;
                    break;
                }
            }
            if(!illegal && s.length() > 1){
                double priceN = Double.parseDouble(s.substring(1)) * (1 - discount * 0.01);
                s = "$" + String.format("%.2f", priceN);
            }
            res.append(s).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "$76111 ab $6 $";
        System.out.println(discountPrices(sentence, 48));
    }
}
