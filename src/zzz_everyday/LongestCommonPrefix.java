package zzz_everyday;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 2){
            return strs[0];
        }
        String a = strs[0];
        String b = strs[1];
        int res = 0;
        for(int i = 0;i < Math.min(a.length(), b.length());i++){
            if(a.charAt(i) == b.charAt(i)){
                res++;
            } else {
                break;
            }
        }
        if(res == 0) return "";
        String sub = a.substring(0, res);
        for(int i = 2;i < strs.length;i++){
            String cur = strs[i];
            int cnt = 0;
            for(int j = 0;j < res;j++){
                if(cur.charAt(j) == sub.charAt(j)){
                    cnt++;
                } else {
                    break;
                }
            }
            res = Math.min(res, cnt);
        }
        return a.substring(0, res);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
