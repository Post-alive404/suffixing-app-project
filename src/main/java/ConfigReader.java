
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.logging.Level;

public class ConfigReader {
    public Config readConfig(String filePath){
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(filePath)){
            properties.load(fileInputStream);
        } catch (IOException e){
            return null;
        }



        String mode = properties.getProperty("mode");
        Mode renamingMode = Mode.fromString(mode);

        if(renamingMode == null){
            LoggerWrapper.log(Level.SEVERE, "Mode is not recognized: " + mode);
            return null;
        }

        String suffix = properties.getProperty("suffix");
        if(suffix == null || suffix.isEmpty()){
            LoggerWrapper.log(Level.SEVERE, "No suffix is configured");
            return null;
        }

        String files = properties.getProperty("files");
        if(files == null || files.isEmpty()){
            LoggerWrapper.log(Level.WARNING, "No files are configured to be copied/moved");
            return null;
        }

        return new Config(renamingMode, suffix, files);
    }
}