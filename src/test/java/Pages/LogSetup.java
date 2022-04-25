package Pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LogSetup {
    public static Logger log;

    static{
        log = LogManager.getLogger(LogSetup.class.getName());
    }
}
