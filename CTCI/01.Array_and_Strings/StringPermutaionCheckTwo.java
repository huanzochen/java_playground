import java.util.Arrays;

public class StringPermutaionCheckTwo {
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];
        // System.out.println("Arrays.toString(letters):" + Arrays.toString(letters));

        char[] s1_array = s1.toCharArray();
        for (char c : s1_array) {
            letters[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            System.out.println((int) s2.charAt(i));
            int c = (int) s2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        // System.out.println(Arrays.toString(letters));
        return true;
    }

    public static void main(String[] args) {
        String s1 = "tommy";
        String s2 = "ymmot";
        System.out.println(isPermutation(s1, s2));
    }
}
