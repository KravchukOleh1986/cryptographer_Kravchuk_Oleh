import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.List;

public class FileService extends Main {


    public void Encrypted(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            FileOutputStream fileOutputStream = new FileOutputStream("File [ENCRYPTED].txt");
            CeasarCipher ceasarCipher = new CeasarCipher();
            String msg1 = ceasarCipher.code(result, key);
            fileOutputStream.write(msg1.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void Decrypted(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            FileOutputStream fileOutputStream1 = new FileOutputStream("File [ENCRYPTED][DECRYPTED].txt");
            CeasarCipher ceasarCipher = new CeasarCipher();
            String msg1 = ceasarCipher.code(result, key);
            String msg2 = ceasarCipher.deCode(msg1, key);
            fileOutputStream1.write(msg2.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Brute_Force(String filePath, int key) {
        try {
            String result = "";
            Path file = Path.of(filePath);
            List<String> list = Files.readAllLines(file);


            for (String i : list) {
                result += i + "\n";
            }
            CeasarCipher ceasarCipher = new CeasarCipher();
            String msg1 = ceasarCipher.code(result, key);
            for (int i = 1; i < 27; i++) {
                String msg2 = ceasarCipher.deCode(msg1, i);
                if (msg2.equals(result)) {
                    FileOutputStream fileOutputStream = new FileOutputStream("File [Key = " + i + "].txt");
                    fileOutputStream.write(msg2.getBytes());
                    fileOutputStream.close();
                } else {
                    msg2 = "";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

