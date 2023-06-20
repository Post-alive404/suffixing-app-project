import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class FileRenamer {
    private final Config config;

    public FileRenamer(Config config) {
        this.config = config;
    }

    public void renameFile() throws IOException {
        List<String> listFiles = List.of(config.getFiles().split(":"));

        for(String filePath : listFiles){
            File file = new File(filePath);
            if(!file.exists()){
                LoggerWrapper.log(Level.SEVERE, "No such file: " + filePath.replace('\\', '/'));
                continue;
            }

            String newFileName = getNewFileName(file);

            File renamedFile = new File(file.getParent(), newFileName);
            FileUtils.copyFile(file, renamedFile);
            if(config.getMode() == Mode.COPY){
                LoggerWrapper.log(Level.INFO, file.getPath().replace('\\', '/') + " -> " + renamedFile.getPath().replace('\\', '/'));
            } else if (config.getMode() == Mode.MOVE){
                LoggerWrapper.log(Level.INFO, file.getPath().replace('\\', '/') + " => " + renamedFile.getPath().replace('\\', '/'));
                file.delete();
            }
        }
    }

    private String getNewFileName(File file) {
        String fileName  = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        String baseName = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex);
        return baseName + config.getSuffix() + extension;
    }
}
