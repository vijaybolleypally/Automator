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
        BufferedInputStream fileData = new BufferedInputStream(new FileInputStream(filePath));
        properties.load(fileData);
    }

    public String getPropValues(String keyValue) {
        return properties.getProperty(keyValue);
    }

}
