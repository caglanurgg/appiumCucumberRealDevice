package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EpttAvmPage;

public class EpttAvmStep {
    EpttAvmPage avmpage=new EpttAvmPage();

    @When("Kullanici {string} bolumune gider")
    public void kullanici_bolumune_gider(String string) {

    }

    @When("{string} sayfasina gider")
    public void sayfasina_gider(String string) {

    }

    @When("Kullanici istenen bilgileri girer: {string} {string} {string} {string} {string}")
    public void kullanici_istenen_bilgileri_girer(String string, String string2, String string3, String string4, String string5) {

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
