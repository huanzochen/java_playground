import java.util.Arrays;

public class UniqueCharsCheckerOne {

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            System.out.println("val: " + val); // Use Arrays.toString to print the array

            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        System.out.println("char_set list: " + Arrays.toString(char_set)); // Use Arrays.toString to print the array
        return true;
    }

    public static void main(String[] args) {
        String testString = "tomy";
        System.out.println("Is unique: " + isUniqueChars(testString));
    }
}