package zzz_everyday;

import java.util.*;

public class TopStudents {
    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> ps = new HashSet<>();
        Set<String> ns = new HashSet<>();
        for (String s : positive_feedback) {
            ps.add(s);
        }
        for (String s : negative_feedback) {
            ns.add(s);
        }
        int n = report.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int sid = student_id[i];
            int score = 0;
            for (String s : report[i].split(" ")) {
                if (ps.contains(s)) {
                    score += 3;
                } else if (ns.contains(s)) {
                    score -= 1;
                }
            }
            arr[i] = new int[] {score, sid};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(arr[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] positive_feedback = {"smart","brilliant","studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious","the student is smart"};
        int[] student_id = {1,2};
        int k = 2;
        System.out.println(topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }
}
