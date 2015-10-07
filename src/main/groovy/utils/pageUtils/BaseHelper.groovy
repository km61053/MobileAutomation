package utils.pageUtils

import geb.testng.GebTest
import org.testng.annotations.AfterSuite

//import geb.testng.GebTest
import org.testng.annotations.BeforeSuite

/**
 * Created by himanshushivhare on 28-08-2015.
 */
class BaseHelper extends GebTest {

/**
 * Starts the Appium server before suite execution
 */
    @BeforeSuite
    public void startAppiumServer(){
        loadProperties()
        //Starting of Appium server will be handled manually for now
    }

    /**
     * Stops the Appium server after suite execution
     */
    @AfterSuite
    public void stopAppiumServer(){
        //Stoping of Appium server will be handled manually for now
    }

    /**
     * Loads the properties
     */
    public static loadProperties(){
        String rootDir = new File(".").getCanonicalPath()
        String resourceFilePath= rootDir + "/src/test/resources/build.properties".replace('/',File.separator)
        Properties prop = new Properties()
        prop.load(new FileInputStream(resourceFilePath))
        prop.each{key,value ->
            if(System.getProperty(key)==null){
                System.setProperty(key,value)
            }
        }
    }
}