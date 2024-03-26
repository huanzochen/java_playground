public class StringPermutaionCheckOne {
    private static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation(String s1, String s2) {
        System.out.println("sort(s1):" + sort(s1));
        return sort(s1).equals(sort(s2));
    }

    public static void main(String[] args) {
        String s1 = "tommy";
        String s2 = "ymmot";
        System.out.println(isPermutation(s1, s2));
    }
}
