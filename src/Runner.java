class Runner {

    void run(String command, String filePath, int key) {
        if (command.equalsIgnoreCase("ENCRYPT") && key != 0) {
            FileService fileService = new FileService();
            fileService.encryptFile(filePath, Math.abs(key));
        } else if (command.equalsIgnoreCase("DECRYPT") && key != 0) {
            FileService fileService = new FileService();
            fileService.decryptFile(filePath, Math.abs(key));
        } else if (command.equalsIgnoreCase("brute_force")) {
            FileService fileService = new FileService();
            fileService.bruteForceFile(filePath, Math.abs(key));
        }
    }
}
