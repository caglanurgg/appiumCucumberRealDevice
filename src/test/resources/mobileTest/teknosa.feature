
Feature: Kullanici mobil uygulamada filtreleme ve siralama islemlerini gerceklestirir
  @teknosa
  Scenario: Kullanici urunleri filtreler ve azalan fiyata gore siralar
    Given Uygulama baslatilir
    When Ilk ekran bolumunden "Atla" tiklanir
    And Footer bolumunden "Kategoriler" bolumune tiklanir
    And Kategoriler bolumunden "Telefon" bolumune tiklanir
    And Telefon sayfasindan cihaz secimi "Cep Telefonu" yapilir
    And Cep telefonu sayfasinda "Filtrele" bolumune tiklanir
    And Filtrele sayfasindan herhangi bir "Marka" filtreleme yapilir
    And Marka bolumunden bir cihaz "TCL" filtrelemesi yapilir
    And Cep telefonu sayfasinda "Sırala" bolumune tiklanir
    And Siralama sayfasindan "Azalan Fiyat" siralamasi secilir
    Then Fiyatlarin azalan duzende oldugu test edilir

  Scenario: Kullanici urunleri filtreler, siralar ve sepete ekler
    Given Uygulama baslatilir
    When Ilk ekran bolumunden "Atla" tiklanir
    And Footer bolumunden "Kategoriler" bolumune tiklanir
    And Kategoriler bolumunden "Telefon" bolumune tiklanir
    And Telefon sayfasindan cihaz secimi "Cep Telefonu" yapilir
    And Cep telefonu sayfasinda "Filtrele" bolumune tiklanir
    And Filtrele sayfasindan herhangi bir "Marka" filtreleme yapilir
    And Marka bolumunden bir cihaz "Samsung" filtrelemesi yapilir
    And Cep telefonu sayfasinda "Sırala" bolumune tiklanir
    And Siralama sayfasindan "Artan Fiyat" siralamasi secilir
    And En ucuz cihaza tiklanir
    And Cihaz sepete eklenir
    And "Sepetime Git" bolumune tiklanir
    Then Urunun sayisi arttirildiginda fiyatinin arttigi dogrulanir


  Scenario: Kullanici screenShot cekecegi alani belirler
    Given Uygulama baslatilir
    When Ilk ekran bolumunden "Atla" tiklanir
    Then Kullanici cekmek istedigi elementin "(//*[@class='android.view.View'])[3]" screenshot'ini alir
