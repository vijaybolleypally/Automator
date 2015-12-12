package selenium.lib;

import java.io.*;
import java.util.Properties;

/**
 * Created by t_bollv on 12/12/15.
 */
public class AccessPropertiesFile {
    Properties properties;

    public AccessPropertiesFile(String filePath) throws IOException {
        properties = new Properties();
        InputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
    }

    public String getPropValues(String keyValue) {
        return properties.getProperty(keyValue);
    }

}
