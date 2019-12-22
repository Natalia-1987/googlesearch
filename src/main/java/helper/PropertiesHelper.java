package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static final String PROPERTIES_FILE_PATH = "./src/main/resources/properties/framework.properties";

    private Properties frameworkProperties;

    public PropertiesHelper() throws IOException {

        frameworkProperties = new Properties();

        File propertiesFile = new File(PROPERTIES_FILE_PATH);

        InputStream inputStream = new FileInputStream(propertiesFile);

        frameworkProperties.load(inputStream);

    }

    public String readProperty(String key){ return frameworkProperties.getProperty(key);}
}
