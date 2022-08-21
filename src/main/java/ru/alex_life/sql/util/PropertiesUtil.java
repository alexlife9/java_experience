package ru.alex_life.sql.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Alex_life
 * @version 1.0
 * @since 21.08.2022
 */
public final class PropertiesUtil {

    public static final Properties PROPERTIES = new Properties();

    static  {
        loadProperties();
    }

    public PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
