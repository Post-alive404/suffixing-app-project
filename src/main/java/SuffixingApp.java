import java.io.IOException;

public class SuffixingApp {
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Usage: java -jar suffixing.jar <config-file-path>");
        }

        String filePath = args[0];
        ConfigReader configReader = new ConfigReader();
        Config config = configReader.readConfig(filePath);
        if(config == null){
            return;
        }

        try {
            FileRenamer fileRenamer = new FileRenamer(config);
            fileRenamer.renameFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}