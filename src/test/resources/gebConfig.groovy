/*
   This is the Geb configuration file.
   See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import utils.mobileDrivers.DriverNames
import utils.mobileDrivers.MobileDrivers

DesiredCapabilities capibilities = new DesiredCapabilities()
def driverDetails

baseNavigatorWaiting = true
cacheDriverPerThread = true
atCheckWaiting = true

def createDriver = { String driverName ->
    driverDetails = new MobileDrivers().getDriverDetails(driverName)
    System.setProperty("geb.env", driverDetails.EnvironmentName)
    capibilities.setCapability("platformName",driverDetails.PlatformType)
    capibilities.setCapability("deviceName", driverDetails.DeviceName)
    capibilities.setCapability(CapabilityType.BROWSER_NAME,driverDetails.Browser)
    capibilities.setCapability("platformVersion", driverDetails.PlatformVersion)
    capibilities.setCapability("app",driverDetails.App)
    capibilities.setCapability("appPackage",driverDetails.AppPackage)
    capibilities.setCapability("appActivitiy",driverDetails.AppActivitiy)
}


driver = {

    createDriver(DriverNames.NEXUS5)
    def browserDriver = new RemoteWebDriver(new URL(System.getProperty("test.appium.server")),capibilities)
    return browserDriver
}

environments {
    androidNexus5 {
        driver ={
            createDriver(DriverNames.NEXUS5)
            def browserDriver = new RemoteWebDriver(new URL(System.getProperty("test.appium.server")),capibilities)
            return browserDriver
        }
    }

    androidGalaxyS6 {
        driver ={
            createDriver(DriverNames.GALAXYS6)
            def browserDriver = new RemoteWebDriver(new URL(System.getProperty("test.appium.server")),capibilities)
            return browserDriver
        }
    }

    iOSiPhone5 {
        driver ={
            createDriver(DriverNames.IPHONE5)
            def browserDriver = new RemoteWebDriver(new URL(System.getProperty("test.appium.server")),capibilities)
            return browserDriver
        }
    }
}

waiting {
    timeout = Integer.parseInt(System.getProperty("test.timeout", "60"))

    presets {
        extraLongWait {
            timeout = 150
        }
        longwait {
            timeout = 90
        }
        mediumwait {
            timeout = 45
        }
        averagewait {
            timeout = 15
        }
        fast {
            timeout = 5
        }
        quick {
            timeout = 1
        }
        mediumwaitWithRetry {
            timeout = 45
            retryInterval = 3
        }
        mediumwaitWithXSRetry {
            timeout = 45
            retryInterval = 0.10
        }
    }
}