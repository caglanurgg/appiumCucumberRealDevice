package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;
    private static IOSDriver iosDriver;

    static final String TELEFONADI="Pixel 22";
    static final String ANDROIDVERSION="10.0";
    static final String PLATFORM="Android";
    static final String OTOMASYON_ISMI="UiAutomator2";


    public static AndroidDriver getAndroidDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {
            UiAutomator2Options options=new UiAutomator2Options();
            options
                    //   .setAppPackage("com.ailebutcem")
                    //  .setAppActivity("com.ailebutcem.MainActivity")
                    .setApp("C:\\Users\\Cagla\\IdeaProjects\\appiumCucumberRealDevice\\Apps\\Aile Bütçem_1.07_apkcombo.com (1).apk")
                    .setUdid("emulator-5554") // terminale "adb devices" yazarak cihazlarimizin tc kimlik nosuna ulasiriz kopyalayarak
                    // hangi cihaz uzerinde calismak istiyorsak onun udid sini burada gireriz
                    .setSkipUnlock(true)     // eger cihazinin ekran kilidi otomatik olarak eger kapaliysa ve acilsin istiyorsan true
                    // .setLanguage("En");   // uygulamanin dili
                   // .setGpsEnabled(true) // GPS ozelligini etkinlestirerek konum tabanli testleri mumkun kilar.
                    .setAutoGrantPermissions(true);// kullanici tarafindan verilmesi gereken izinleri KABUL eder

            // .setNoReset(false) // Kullanicinin verileri sifirlanir ve cihaz baslatildiginda tum veriler silinir.
            // .setFullReset(false) // Cihazin her calistirilmadan once sifirlanip sifirlanmayacagi.Eger false ise sifirlanmaz, mevcut veriler korunur.
            // .withBrowserName("chrome") // Kullanilacak tarayiciyi belirtir (ornegin Chrome).
            // .setChromedriverExecutable("") // Chromedriver'in dosyasinin yolu burada belirtilmeli.


            if (ConfigReader.getProperty("platformName").equals("Android")) {
                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver(appiumServerURL,options);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            }else {
                assert appiumServerURL != null;
                iosDriver = new IOSDriver(appiumServerURL,options);
                iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                throw new UnsupportedOperationException("Dostum Ios kullanmaya calisiyorsun YAPMA!!");
            }
        }
        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}