package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingUpPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private String singUpPageURL = "https://www.last.fm/join";

    private final By singUpFormFieldsNames = By.cssSelector("form[action=\"/join\"]>div>label");

    private final By userNameSingUpFormInputField = By.cssSelector("input[name=\"userName\"]");

    private final By emailSingUpFormInputField = By.cssSelector("input[name=\"email\"]");

    private final By passwordSingUpFormInputField = By.cssSelector("input[name=\"password\"]");

    private final By confirmPasswordSingUpFormInputField = By.cssSelector("input[name=\"passwordConf\"]");

    public By getSingUpFormFieldsNames() {
        return singUpFormFieldsNames;
    }

    public By getUserNameSingUpFormInputField() {
        return userNameSingUpFormInputField;
    }

    public By getEmailSingUpFormInputField() {
        return emailSingUpFormInputField;
    }

    public By getPasswordSingUpFormInputField() {
        return passwordSingUpFormInputField;
    }

    public By getConfirmPasswordSingUpFormInputField() {
        return confirmPasswordSingUpFormInputField;
    }

    @Step("Open sing up page")
    public SingUpPage  openSingUpPage()
    {
        driver.navigate().to(singUpPageURL);
        return this;
    }



}
