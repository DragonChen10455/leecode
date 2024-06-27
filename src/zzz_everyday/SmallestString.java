package zzz_everyday;

public class SmallestString {
    public static String smallestString(String s) {
        int start = 0;
        int end = s.length() - 1;
        int firstA = s.indexOf("a");
        if(firstA > 0) {
            end = firstA - 1;
        } else if(firstA == 0){
            while(++start < s.length()){
                if(s.charAt(start) != 'a'){
                    break;
                }
            }
            int nextA = s.substring(start).indexOf("a");
            end = nextA > 0 ? nextA + start - 1 : s.length() - 1;
        }
        if(start > s.length() - 1) start = s.length() - 1;
        char[] arr = s.toCharArray();
        for(int i = start;i <= end;i++){
            if(arr[i] != 'a'){
                arr[i]--;
            } else {
                arr[i] = 'z';
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(smallestString("acbbc"));
    }
}
