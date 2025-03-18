# 📱 Appium Cucumber Real Device Test Framework

Bu proje, **Appium, Cucumber, JUnit** kullanarak **gerçek cihazlar** üzerinde test çalıştırmak için geliştirilmiştir.

## 🛠 Kullanılan Teknolojiler

- **Java 17:** Projenin ana programlama dili.
- **Maven:** Proje yönetimi ve bağımlılık yönetimi için kullanıldı.
- **Selenium WebDriver:** Web sayfalarını otomatikleştirilmiş testlerle doğrulamak için kullanıldı.
- **Cucumber:** BDD (Behavior-Driven Development) çerçevesi ile test senaryolarını yazmak için kullanıldı.
- **JUnit:** Testlerin yürütülmesi ve raporlanması için kullanıldı.

## 📂 Proje Yapısı

- **`src/test/java/`**: Test senaryolarını ve adım tanımlarını içerir.
- **`src/test/resources/`**: Test senaryolarında kullanılan konfigürasyon dosyalarını içerir.
- **`pom.xml`**: Projede kullanılan tüm bağımlılıkları yöneten Maven yapılandırma dosyası.

## 🚀 Kurulum

1. **Projeyi klonlayın:**
   ```sh
   git clone https://github.com/caglanurgg/appiumCucumberRealDevice.git
   cd appiumCucumberRealDevice
2. **Gerekli Bağımlılıkları Yükleyin:** Proje, Maven ile yönetildiği için, gerekli tüm bağımlılıkları yüklemek için aşağıdaki komutu kullanabilirsiniz:

   ```sh
   mvn install

3. **Gerçek Cihaz Bağlantısını Kontrol Edin:** Testleri çalıştırmadan önce cihazınızın **USB hata ayıklama (USB Debugging)** modunun açık olduğundan emin olun.

4. **Testleri Çalıştırın:** Testlerinizi çalıştırmak için aşağıdaki komutu kullanabilirsiniz:

   ```sh
   mvn test -Dcucumber.options="src/test/resources/mobileTest"

Bu komut, **`mobileTest`** konfigürasyon dosyasını kullanarak tüm testleri çalıştırır.

**🔧 Dry Run Açıklaması**
- **dryRun true:** Testler çalıştırılmaz, ancak features dosyasındaki adımların stepDefinitions'ta tanımlı olup olmadığı kontrol edilir. Eğer eksik adımlar varsa, hata mesajları gösterilir, ancak testler gerçekten çalıştırılmaz.
- **dryRun false:** Eğer tüm adımlar tanımlıysa, testler çalıştırılır ve gerçek test süreci başlar.

**📝 Notlar**

- **USB Debugging:** Testleri çalıştırmadan önce cihazınızın USB hata ayıklama modunun açık olduğundan emin olun.
- **Vysor Kullanımı:** Gerçek cihazları test ederken cihazın ekranını bilgisayarınıza yansıtmak için Vysor kullanabilirsiniz.
- **Appium Logları:** Appium, testlerinizi çalıştırırken oluşan hataları log dosyalarına kaydeder. Testlerinizi debug ederken bu logları inceleyebilirsiniz.