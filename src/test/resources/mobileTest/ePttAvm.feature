Feature: Kullanici uygulama uzerindeki gorevleri yapar

  @eptt
  Scenario: Kullanici girmis oldugu bilgiler ve formatlar ile uye olabildigini dogrular
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "Adı" "Soyadı" "E-Posta Adresi" "Şifre" "Sifre Tekrar"
    Then Basarili bir sekilde uye olundugu dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici daha once uye olunmus bir hesapla yeni uyelik acilamadigini dogrular
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer: "Adı" "Soyadı" "E-Posta Adresi" "Şifre" "Sifre Tekrar"
    Then Kayitli mail ile tekrar uye olunamadigi dogrulanir
    And Uygulama kapatilir

  Scenario Outline: Kullanici yanlis bir email formati ile uye olmak istediginde uye olmamali
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer:
      | Adı    | Soyadı | E-Posta Adresi | Şifre   | Şifre Tekrar |
      | Martin | Eden   | <mail>         | Martin12 | Martin12 |
    Then Hatali bilgiler ile giris yapilamadigi dogrulanir
    And Uygulama kapatilir

    Examples:
      | mail             |
      | @gmail           |
      | martin@gmailcom  |
      | martingmail.com  |
      | 13123123         |

  Scenario: Kullanici kucuk harfli 8 karakter bir sifre girdiginde en az bir harf buyuk kullanilmasini dogrular
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer:
      | Adi | Soyadi | E-Posta Adresi | Sifre    | Sifre Tekrar |
      |     |        | test@mail.com  | sifre123 | sifre123 |
    Then Kullanici "En az bir buyuk harf icermeli" uyarisini dogrular
    And Uygulama kapatilir

  Scenario: Kullanici birbirleriyle eslesmeyen password girdiginde uyusmama hatasi almali
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer:
      | Adi | Soyadi | E-Posta Adresi | Sifre    | Sifre Tekrar  |
      |     |        | test@mail.com  | Test1234 | Test12345 |
    Then Eslesmeyen sifreler ile giris yapilamadigi dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici herhangi bir parametre girmediginde bu bolumler bos birakilamaz hatalarini dogrular
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer:
      | Adi | Soyadi | E-Posta Adresi | Sifre | Sifre Tekrar |
      |     |        |                |       |             |
    Then Bos birakilan alanlarin doldurulmasi gerektigi dogrulanir
    And Uygulama kapatilir

  Scenario: Kullanici aydinlatma metnini onaylamadan uygulamaya giris yapilamamali
    Given EpttAvm Uygulamasi baslatilir
    When Kullanici "Hesabım" bolumune gider
    And "Üye Ol" sayfasina gider
    And Kullanici istenen bilgileri girer:
      | Adi | Soyadi | E-Posta Adresi | Sifre    | Sifre Tekrar  |
      |     |        | test@mail.com  | Test1234 | Test1234 |
    Then Aydinlatma metni onaylanmadiginda giris yapilamadigi dogrulanir
    And Uygulama kapatilir

