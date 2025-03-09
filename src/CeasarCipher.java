class CeasarCipher {
    private final char BIG_LETTER_A = 65;
    private final char BIG_LETTER_Z = 90;
    private final char SMALL_LETTER_A = 97;
    private final char SMALL_LETTER_Z = 122;
    private final int ALPHABET_LENGTH = 26;


    public String encrypt(String text, int key) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= BIG_LETTER_A && c <= BIG_LETTER_Z) {
                result += codeChar(c, key, BIG_LETTER_A);
            } else {
                if (c >= SMALL_LETTER_A && c <= SMALL_LETTER_Z) {
                    result += codeChar(c, key, SMALL_LETTER_A);
                } else {
                    result += c;
                }
            }
        }
        return result;
    }

    private char codeChar(char c, int key, int shift) {
        int a = (int) c + key;
        if (a >= shift + ALPHABET_LENGTH)
            a -= ALPHABET_LENGTH;
        return (char) a;
    }

    public String decrypt(String text, int key) {
        return encrypt(text, ALPHABET_LENGTH - key);

    }

}