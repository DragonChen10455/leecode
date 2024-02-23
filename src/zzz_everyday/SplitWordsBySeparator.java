package zzz_everyday;

import java.util.ArrayList;
import java.util.List;

public class SplitWordsBySeparator {
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            word += Character.toString(separator);
            StringBuilder sb = new StringBuilder();
            for(char w : word.toCharArray()) {
                if(w != separator) {
                    sb.append(w);
                } else {
                    String addString = sb.toString();
                    if(addString.length() != 0) {
                        res.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        List<String> res = splitWordsBySeparator(words, '.');
        System.out.println(res);
    }
}
