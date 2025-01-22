import java.util.Arrays;
import java.util.Objects;

public class Runner extends Main {

    public void run(String command, String filePath, int key) {
        if (command.equalsIgnoreCase("ENCRYPT") && key != 0) {
            FileService fileService = new FileService();
            fileService.Encrypted(filePath, key);
        } else if (command.equalsIgnoreCase("DECRYPT") && key != 0) {
            FileService fileService = new FileService();
            fileService.Decrypted(filePath, key);
        } else if (command.equalsIgnoreCase("brute_force")) {
            FileService fileService = new FileService();
            fileService.Brute_Force(filePath, key);
        }
    }
}
