package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingInPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private final By usernameOrEmailField =
            By.cssSelector("input[id=\"id_username_or_email\"]");

    private final By passwordField =
            By.cssSelector("input[id=\"id_password\"]");

    private final By letMeInButton =
            By.xpath("//button[text()=\"Let me in!\"]");

    @Step("Open sing in page")
    public SingInPage  openSingInPage()
    {
        Driver.getChromeDriver().navigate().to("https://www.last.fm/login");
        return this;
    }

    @Step("Login with username {0} and password {1}")
    public void logIn(String usernameOrEmail, String password){

        driver.findElement(usernameOrEmailField).sendKeys(usernameOrEmail);
        driver.findElement(passwordField).sendKeys(password);
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(passwordField), "value"));
        driver.findElement(letMeInButton).click();


    }
}
