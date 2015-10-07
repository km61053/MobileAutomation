package utils.dataUtils

/**
 * Created by himanshushivhare on 04-09-2015.
 */
class LoadBuildConfigurations {

    public static Properties loadBuildConfigurations() {
        Properties prop = new Properties()
        InputStream input = null
        try {

         //   input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace()
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop
    }
}