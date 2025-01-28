import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class FileService {


    void encryptFile(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            FileOutputStream fileOutputStream = new FileOutputStream("File [ENCRYPTED].txt");
            CeasarCipher ceasarCipher = new CeasarCipher();
            String resultEncrypt = ceasarCipher.encrypt(result, Math.abs(key));
            fileOutputStream.write(resultEncrypt.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    void decryptFile(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            FileOutputStream fileOutputStream1 = new FileOutputStream("File [ENCRYPTED][DECRYPTED].txt");
            CeasarCipher ceasarCipher = new CeasarCipher();
            String resultDecrypt = ceasarCipher.decrypt(result, Math.abs(key));
            fileOutputStream1.write(resultDecrypt.getBytes());
            fileOutputStream1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void bruteForceFile(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            CeasarCipher ceasarCipher = new CeasarCipher();
            String msg1 = ceasarCipher.encrypt(result, Math.abs(key));
            for (int i = 1; i < 27; i++) {
                String resultDecrypt = ceasarCipher.decrypt(msg1, i);
                if (resultDecrypt.equals(result)) {
                    FileOutputStream fileOutputStream = new FileOutputStream("File [Key = " + i + "].txt");
                    fileOutputStream.write(resultDecrypt.getBytes());
                    fileOutputStream.close();
                } else {
                    resultDecrypt = "";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

