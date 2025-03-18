@eptt
Feature: Kullanici uygulama uzerindeki gorevleri yapar

  Scenario: Kullanici girmis oldugu bilgiler ve formatlar ile uye olabildigini dogrular
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Basarili bir sekilde uye olundugu dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici daha once uye olunmus bir hesapla yeni uyelik acilamadigini dogrular
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Kayitli mail ile tekrar uye olunamadigi dogrulanir
    And Uygulama kapatilir


  Scenario Outline: Kullanici yanlis bir email formati ile uye olmak istediginde uye olmamali
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "Nevzat" "Celik" "<mail>" "Nevzat12" "Nevzat12"
    Then Hatali bilgiler ile giris yapilamadigi dogrulanir
    And Uygulama kapatilir
    Examples:
      | mail             |
      | @gmail          |
      | nevzat@gmailcom |
      | nevzatgmail.com |
      | 13123123        |

  Scenario: Kullanici kucuk harfli 8 karakter bir sifre girdiginde en az bir harf buyuk kullanilmasini dogrular
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Kullanici "En az bir buyuk harf icermeli" uyarisini dogrular
    And Uygulama kapatilir

  Scenario: Kullanici birbirleriyle eslesmeyen password girdiginde uyusmama hatasi almali
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Eslesmeyen sifreler ile giris yapilamadigi dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici herhangi bir parametre girmediginde bu bolumler bos birakilamaz hatalarini dogrular
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Bos birakilan alanlarin doldurulmasi gerektigi dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici aydinlatma metnini onaylamadan uygulamaya giris yapilamamali
    Given Uygulama baslatilir
    When Kullanici "Hesabim" bolumune gider
    And "Uye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "" "" "" "" ""
    Then Aydinlatma metni onaylanmadiginda giris yapilamadigi dogrulanir
    And Uygulama kapatilir
