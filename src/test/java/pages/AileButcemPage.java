package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {

    public AileButcemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)),this);
    }

    @FindBy (xpath = "(//*[@class='android.widget.EditText'])[1]")
    public WebElement emailAdresiBox;

    @FindBy (xpath = "(//*[@class='android.widget.EditText'])[2]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[17]")
    public WebElement girisYapildiYazisi;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public WebElement isimBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public WebElement soyisimBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public WebElement sehirBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public WebElement yasBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public WebElement meslekBox;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    public WebElement girisYazisiDogrulama;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    public WebElement plusButton;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public WebElement aciklamaKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public WebElement tutarKutusu;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[10]")
    public WebElement gelirTipiKutusu;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[11]")
    public WebElement kategoriKutusu;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[12]")
    public WebElement tarihKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    public WebElement tarihKutusu2;

    @FindBy(id = "android:id/button1")
    public WebElement okButton;

    @FindBy(xpath = "//*[@text='Gelir eklendi.']")
    public WebElement gelirEklediText;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[11]")
    public WebElement gelirPeriyodu;


    public void ilkEkranAyarlari(){
        ReusableMethods.wait(2);
        for (int i = 0; i < 6; i++) {
            ReusableMethods.ekranKaydirmaMethodu(964,979,750,124,979);
        }
    }

    public void girisYap(String mail, String password){
        emailAdresiBox.sendKeys(mail);
        passwordBox.sendKeys(password);
        ReusableMethods.scrollWithUiScrollableAndClick("Giriş Yap");
    }

    public void hesabimBilgileriniTemizleme(){
        isimBox.clear();
        soyisimBox.clear();
        sehirBox.clear();
        yasBox.clear();
        meslekBox.clear();
    }

    public void hesabimBilgileriniDegistirmeVeKaydetme(String isim,String soyisim,String sehir,String yas,String meslek){
        hesabimBilgileriniTemizleme();
        isimBox.sendKeys(ConfigReader.getProperty(isim));
        soyisimBox.sendKeys(ConfigReader.getProperty(soyisim));
        sehirBox.sendKeys(ConfigReader.getProperty(sehir));
        yasBox.sendKeys(ConfigReader.getProperty(yas));
        meslekBox.sendKeys(ConfigReader.getProperty(meslek));
        ReusableMethods.scrollWithUiScrollableAndClick("Kaydet");
    }

    public void bilgiDegistirmeAssert(String isim,String soyisim,String sehir,String yas,String meslek){
        Assert.assertTrue(isimBox.getText().contains(ConfigReader.getProperty(isim)));
        Assert.assertTrue(soyisimBox.getText().contains(ConfigReader.getProperty(soyisim)));
        Assert.assertTrue(sehirBox.getText().contains(ConfigReader.getProperty(sehir)));
        Assert.assertTrue(yasBox.getText().contains(ConfigReader.getProperty(yas)));
        Assert.assertTrue(meslekBox.getText().contains(ConfigReader.getProperty(meslek)));
    }

    public void tarihKaydirmaMethodu(int forBitis,String gun){
        tarihKutusu.click();
        ReusableMethods.wait(2);
        for (int i=0; i<forBitis;i++){
            ReusableMethods.ekranKaydirmaMethodu(811,1052,750,241,1052);
        }
        ReusableMethods.scrollWithUiScrollableAndClick(gun);
        okButton.click();
    }

}
