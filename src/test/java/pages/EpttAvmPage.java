package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EpttAvmPage {
    Faker faker = new Faker();

    public EpttAvmPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }

    @FindBy(id = "com.pttem.epttavm:id/buttonOpenAccountPage")
    public WebElement accountButton;

    @FindBy(id = "com.pttem.epttavm:id/buttonSignUp")
    public WebElement signUpButton;

    @FindBy(id = "com.pttem.epttavm:id/editTextUserName")
    public WebElement isim;

    @FindBy(id = "com.pttem.epttavm:id/editTextUserSurname")
    public WebElement soyisim;

    @FindBy(id = "com.pttem.epttavm:id/editTextUserEmail")
    public WebElement email;

    @FindBy(id = "com.pttem.epttavm:id/editTextPassword")
    public WebElement password;

    @FindBy(id = "com.pttem.epttavm:id/editTextPasswordAgain")
    public WebElement confirmPassword;

    @FindBy(id = "com.pttem.epttavm:id/checkBoxReadTerms")
    public WebElement metinKutu;

    public void enterUserInfo() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        String passwordText = faker.internet().password(8, 16);
        String confirmPasswordText = passwordText;

        isim.sendKeys(firstName);
        soyisim.sendKeys(lastName);
        email.sendKeys(emailAddress);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(confirmPasswordText);
    }


}
