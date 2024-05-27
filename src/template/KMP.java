package template;

public class KMP {
    public static int countComparisons(String text, String pattern) {
        int[] failure = new int[pattern.length()];
        computeFailure(pattern, failure);

        int comparisons = 0;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = failure[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                // 找到匹配的模式
                comparisons += (text.length() - i + 1 - pattern.length());
                j = failure[j - 1]; // 继续匹配下一个可能的位置
            }
        }
        return comparisons;
    }

    private static void computeFailure(String pattern, int[] failure) {
        int j = 0;
        failure[0] = j;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = failure[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            failure[i] = j;
        }
    }

    public static void main(String[] args) {
        String text = "xyxxyxxyzzyxyxxyzxyxyxy";
        String pattern = "xyxxyz";
        int comparisons = countComparisons(text, pattern);
        System.out.println("Total comparisons: " + comparisons);
    }
}
