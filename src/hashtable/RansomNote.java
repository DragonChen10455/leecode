package hashtable;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a']--;
        }

        for(int i : record){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
