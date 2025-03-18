package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeknosaPage {
    public TeknosaPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement markaKutusu;

    @AndroidFindBy(xpath = "//*[@text='Sonuçları Göster']")
    public WebElement sonuclariGosterButonu;

    @AndroidFindBy(xpath = "//*[@bounds='[100,893][152,946]']")
    public WebElement kutucuk;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[14]")
    public WebElement birinciUrunFiyati;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[20]")
    public WebElement ikinciUrunFiyati;

    @AndroidFindBy(xpath = "//*[@bounds='[27,762][514,1276]']")
    public WebElement enUcuzSamsung;

    @AndroidFindBy(xpath = "//*[@text='Sepete Ekle']")
    public WebElement sepeteEkle;

    @AndroidFindBy(xpath = "//*[@text='Sepetime Git']")
    public WebElement sepetimeGit;

    @AndroidFindBy(xpath = "//*[@text='+']")
    public WebElement artiButonu;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[7]")
    public WebElement urunFiyati;
}
