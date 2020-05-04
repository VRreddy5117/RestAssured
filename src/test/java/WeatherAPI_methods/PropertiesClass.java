package WeatherAPI_methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClass {

    public static Properties loader_properties() throws IOException {

        File file = new File("src/main/resources/ConfigureProperties/config.properties");
        InputStream fileInput = null;

        fileInput = new FileInputStream(file);

        Properties prop = new Properties();
        prop.load(fileInput);

        return prop;

    }

}
