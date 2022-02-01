package by.itAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SingUpPage {

    private WebDriver driver;

    private static final By singUpFormFieldName = By.cssSelector("form[action=\"/join\"]>div>label");

    public static final By userNameSingUpFormInputField = By.cssSelector("input[name=\"userName\"]");

    public static final By emailSingUpFormInputField = By.cssSelector("input[name=\"email\"]");

    public static final By passwordSingUpFormInputField = By.cssSelector("input[name=\"password\"]");

    public static final By confirmPasswordSingUpFormInputField = By.cssSelector("input[name=\"passwordConf\"]");

    public SingUpPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public SingUpPage  openSingUpPage()
    {
        driver.get("https://www.last.fm/join");
        return this;
    }

    public List<String> getTextElementNameFromSingUpForm(){

        return driver.findElements(singUpFormFieldName)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void enterTextInSingUpFormPole(String selector, String text){
       driver.findElement(By.cssSelector("input[name=\"" + selector + "\"]")).sendKeys(text);
    }

    public String getEnteredTextInSingUpFormField(String selector){
        return driver.findElement(By.cssSelector("input[name=\"" + selector + "\"]")).getAttribute("value");
    }


}
