package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

public class apkYukle {

    AndroidDriver driver= Driver.getAndroidDriver();

    @Given("Kullanici uygulamayi yukler")
    public void kullanici_uygulamayi_yukler() {
        Driver.getAndroidDriver();
    }

    @Given("Kullanici gerekli ekran ayarlarini yapar")
    public void kullanici_gerekli_ekran_ayarlarini_yapar() throws InterruptedException {
        Thread.sleep(2500);
        ReusableMethods.koordinatTiklamaMethodu(533,2000);
    }
}
