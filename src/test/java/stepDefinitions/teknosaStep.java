package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TeknosaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class teknosaStep {

    AndroidDriver driver= Driver.getAndroidDriver();
    TeknosaPage page=new TeknosaPage();

    @Given("Uygulama baslatilir")
    public void uygulama_baslatilir() {
        Driver.getAndroidDriver();
    }

    @When("Ilk ekran bolumunden {string} tiklanir")
    public void ilk_ekran_bolumunden_tiklanir(String girisSecenegi) {
        ReusableMethods.scrollWithUiScrollableAndClick(girisSecenegi);
        ReusableMethods.wait(2);
    }

    @When("Footer bolumunden {string} bolumune tiklanir")
    public void footer_bolumunden_bolumune_tiklanir(String footerSecenek) {
        ReusableMethods.scrollWithUiScrollableAndClick(footerSecenek);
    }

    @When("Kategoriler bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumunden_bolumune_tiklanir(String kategoriTuru) {
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriTuru);
    }

    @When("Telefon sayfasindan cihaz secimi {string} yapilir")
    public void telefon_sayfasindan_cihaz_secimi_yapilir(String cihazIsmi) {
        ReusableMethods.scrollWithUiScrollableAndClick(cihazIsmi);
    }

    @When("Cep telefonu sayfasinda {string} bolumune tiklanir")
    public void cep_telefonu_sayfasinda_bolumune_tiklanir(String cepTelefonuBolumu) {
        ReusableMethods.scrollWithUiScrollableAndClick(cepTelefonuBolumu);
    }

    @When("Filtrele sayfasindan herhangi bir {string} filtreleme yapilir")
    public void filtrele_sayfasindan_herhangi_bir_filtreleme_yapilir(String filtrelemeTuru) {
        ReusableMethods.scrollWithUiScrollableAndClick(filtrelemeTuru);
    }

    @When("Marka bolumunden bir cihaz {string} filtrelemesi yapilir")
    public void marka_bolumunden_bir_cihaz_filtrelemesi_yapilir(String cihazIsmi) {
        page.markaKutusu.sendKeys(cihazIsmi);
        page.kutucuk.click();
        ReusableMethods.wait(2);
        page.sonuclariGosterButonu.click();
    }

    @When("Siralama sayfasindan {string} siralamasi secilir")
    public void siralama_sayfasindan_siralamasi_secilir(String siralamaIsmi) {
        ReusableMethods.scrollWithUiScrollableAndClick(siralamaIsmi);
    }

    @Then("Fiyatlarin azalan duzende oldugu test edilir")
    public void fiyatlarin_azalan_duzende_oldugu_test_edilir() {
        ReusableMethods.wait(3);
        ReusableMethods.ekranKaydirmaMethodu(530,2032,750,530,667);
        String birinciUrunFiyatiText=page.birinciUrunFiyati.getText(); // 4.529,00 TL
        String ikinciUrunFiyatiText= page.ikinciUrunFiyati.getText();

        birinciUrunFiyatiText=birinciUrunFiyatiText.replaceAll("\\D","");
        System.out.println(birinciUrunFiyatiText);
        ikinciUrunFiyatiText=ikinciUrunFiyatiText.replaceAll("\\D","");
        System.out.println(ikinciUrunFiyatiText);

        Assert.assertTrue(Integer.parseInt(birinciUrunFiyatiText)>Integer.parseInt(ikinciUrunFiyatiText));
    }

    @When("En ucuz cihaza tiklanir")
    public void en_ucuz_cihaza_tiklanir() {
        page.enUcuzSamsung.click();
    }

    @When("Cihaz sepete eklenir")
    public void cihaz_sepete_eklenir() {
        page.sepeteEkle.click();
    }

    @When("{string} bolumune tiklanir")
    public void bolumune_tiklanir(String sepetimeGit) {
        page.sepetimeGit.click();
        ReusableMethods.wait(2);
    }

    @Then("Urunun sayisi arttirildiginda fiyatinin arttigi dogrulanir")
    public void urunun_sayisi_arttirildiginda_fiyatinin_arttigi_dogrulanir() {
        String urununILKfiyati= page.urunFiyati.getText();
        urununILKfiyati=urununILKfiyati.replaceAll("\\D","");
        urununILKfiyati=urununILKfiyati.substring(0,urununILKfiyati.length()-2);
        System.out.println(urununILKfiyati); // 5699
        page.artiButonu.click();
        ReusableMethods.wait(4);
        String urununIKINCIfiyati=page.urunFiyati.getText();
        urununIKINCIfiyati=urununIKINCIfiyati.replaceAll("\\D","");
        urununIKINCIfiyati=urununIKINCIfiyati.substring(0,urununIKINCIfiyati.length()-2);
        System.out.println(urununIKINCIfiyati); // 11398

        Assert.assertEquals(Integer.parseInt(urununIKINCIfiyati),Integer.parseInt(urununILKfiyati)*2);
    }

    @Then("Kullanici cekmek istedigi elementin {string} screenshot'ini alir")
    public void kullanici_cekmek_istedigi_elementin_screenshot_ini_alir(String elementXpath) throws IOException {
        ReusableMethods.getScreenshot("fullScreen");
        ReusableMethods.screenShotElement(elementXpath);
    }

    @Then("Kullanici cekmek istedigi elementin {string} ekran fotografini ceker")
    public void kullanici_cekmek_istedigi_elementin_ekran_fotografini_ceker(String ssText) throws IOException,InterruptedException {
        ReusableMethods.screenShotElement(ssText);
        ReusableMethods.koordinatTiklamaMethodu(150,1500);
    }
}
