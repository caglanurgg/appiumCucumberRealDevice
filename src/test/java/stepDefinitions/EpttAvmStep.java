package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EpttAvmPage;
import utilities.Driver;

public class EpttAvmStep {
    AndroidDriver driver= Driver.getAndroidDriver();
    EpttAvmPage avmpage=new EpttAvmPage();

    @Given("EpttAvm Uygulamasi baslatilir")
    public void epttavmUygulamasiBaslatilir() {
        System.out.println("Driver Instance: " + driver); // Aynı mı kontrol et!
    }

    @When("Kullanici {string} bolumune gider")
    public void kullanici_bolumune_gider(String hesabim) {
        avmpage.accountButton.click();
    }

    @When("{string} sayfasina gider")
    public void sayfasina_gider(String uyeOl) {
        avmpage.signUpButton.click();
    }

    @When("Kullanici istenen bilgileri girer: {string} {string} {string} {string} {string}")
    public void kullanici_istenen_bilgileri_girer(String adi, String soyadi, String ePosta, String sifre, String sifreTekrar) {
        avmpage.enterUserInfo();
    }

    @Then("Basarili bir sekilde uye olundugu dogrulanir")
    public void basarili_bir_sekilde_uye_olundugu_dogrulanir() {

    }

    @Then("Uygulama kapatilir")
    public void uygulama_kapatilir() {

    }

    @Then("Hatali bilgiler ile giris yapilamadigi dogrulanir")
    public void hatali_bilgiler_ile_giris_yapilamadigi_dogrulanir() {

    }

    @Then("Kayitli mail ile tekrar uye olunamadigi dogrulanir")
    public void kayitli_mail_ile_tekrar_uye_olunamadigi_dogrulanir() {

    }

    @Then("Kullanici {string} uyarisini dogrular")
    public void kullanici_uyarisini_dogrular(String string) {

    }

    @Then("Eslesmeyen sifreler ile giris yapilamadigi dogrulanir")
    public void eslesmeyen_sifreler_ile_giris_yapilamadigi_dogrulanir() {

    }

    @Then("Bos birakilan alanlarin doldurulmasi gerektigi dogrulanir")
    public void bos_birakilan_alanlarin_doldurulmasi_gerektigi_dogrulanir() {

    }

    @Then("Aydinlatma metni onaylanmadiginda giris yapilamadigi dogrulanir")
    public void aydinlatma_metni_onaylanmadiginda_giris_yapilamadigi_dogrulanir() {

    }


}
