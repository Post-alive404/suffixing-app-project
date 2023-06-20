public class Config {

    private final Mode mode;
    private final String suffix;
    private final String files;

    public Config(Mode mode, String suffix, String files) {
        this.mode = mode;
        this.suffix = suffix;
        this.files = files;
    }

    public Mode getMode() {
        return mode;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getFiles() {
        return files;
    }
}
