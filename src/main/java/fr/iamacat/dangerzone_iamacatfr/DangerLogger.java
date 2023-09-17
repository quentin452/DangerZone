package fr.iamacat.dangerzone_iamacatfr;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DangerLogger {

    public static final Logger LOGGER = LogManager.getLogger("DangerZone");

    public static final Logger INFO_LOGGER = LogManager.getLogger("DangerZone-Info");

    public static final Logger WARN_LOGGER = LogManager.getLogger("DangerZone-Warn");

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }

    public static void info(String message, Object[] objects) {
        INFO_LOGGER.info(message);
    }

    public static void warn(String message) {
        WARN_LOGGER.warn(message);
    }

}
