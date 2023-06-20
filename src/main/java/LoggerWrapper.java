import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerWrapper {
    private static final Logger logger = Logger.getLogger(LoggerWrapper.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
    }

    public static void log(Level level, String message){
        logger.log(level, message);
    }
}
