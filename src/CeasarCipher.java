public class CeasarCipher extends Main {


    public String code(String s, int key) {
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                str += codeChar(c, key, 65);
            } else {
                if (c >= 97 && c <= 122) {
                    str += codeChar(c, key, 97);
                } else {
                    str += c;
                }
            }
        }
        return str;
    }

    private char codeChar(char c, int key, int shift) {
        int a = (int) c + key;
        if (a >= shift + 26)
            a -= 26;
        return (char) a;
    }

    public String deCode(String s, int key) {
        return code(s, 26 - key);

    }

}