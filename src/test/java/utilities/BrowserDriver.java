package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {
    private static AndroidDriver browserDriver;

    public static AndroidDriver getBrowserDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (browserDriver == null) {
            UiAutomator2Options options=new UiAutomator2Options();
            options.
                    setPlatformName("Android")
                    .setPlatformVersion("10.0")
                    .setAutomationName("UiAutomator2")
                    .setNoReset(false)
                    .withBrowserName("chrome");
            //.setChromedriverExecutable("C:\Users\Cagla\IdeaProjects\appiumCucumberRealDevice\Driver\chromedriver.exe");

            // Eger ki BrowserName=chrome capability cihazinizda chrome u basarili bir sekilde baslatmiyorsa manuel olarak
            // chromedriver sitesinden telefondaki chrome uygulamasinin versiyonuna bakarak uygun driver indirilir ardindab
            // bu sekilde capability olarak dosya yolu tanitilir.

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                browserDriver = new AndroidDriver(appiumServerURL,options);
                browserDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                throw new UnsupportedOperationException("Invalid Platform Name ");
            }
        }
        return browserDriver;
    }


    public static void quitAppiumDriver(){
        if (browserDriver != null) {
            browserDriver.quit();
            browserDriver = null;
        }
    }
}
