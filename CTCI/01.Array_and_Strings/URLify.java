import java.util.Arrays;

public class URLify {

    public static String replaceSpaces(char[] s, int trueLength) {
        int spaceCount = 0, index, i = 0;

        for (i = 0; i < trueLength; i++) {
            if (s[i] == ' ') {
                spaceCount++;
            }
        }
        // trueLength(alphabet + space) & '%20' space *2
        index = trueLength + spaceCount * 2;

        System.out.println("index, trueLength:" + index + "," + trueLength);

        // if (trueLength < s.length)
        // s[trueLength] = '\0';

        System.out.println("s:" + Arrays.toString(s));

        for (i = trueLength - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index = index - 3;
            } else {
                s[index - 1] = s[i];
                index = index - 1;
            }
        }

        return new String(s);
    }

    public static void main(String args[]) {
        String s = "Mr. Tommy Huang    ";
        char[] charS = s.toCharArray();
        System.out.println(replaceSpaces(charS, 15));
    }
}
