import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Runner runner = new Runner();
        runner.run(args[0], args[1], Integer.parseInt(args[2]));

    }
}