package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingUpPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private String singUpPageURL = "https://www.last.fm/join";

    private static final By singUpFormFieldsNames = By.cssSelector("form[action=\"/join\"]>div>label");

    public static final By userNameSingUpFormInputField = By.cssSelector("input[name=\"userName\"]");

    public static final By emailSingUpFormInputField = By.cssSelector("input[name=\"email\"]");

    public static final By passwordSingUpFormInputField = By.cssSelector("input[name=\"password\"]");

    public static final By confirmPasswordSingUpFormInputField = By.cssSelector("input[name=\"passwordConf\"]");

    public SingUpPage  openSingUpPage()
    {
        driver.navigate().to(singUpPageURL);
        return this;
    }

    public List<String> getTextElementNameFromSingUpForm(){

        return driver.findElements(singUpFormFieldsNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void enterTextInSingUpFormPole(By selector, String text){
       driver.findElement(selector).sendKeys(text);
    }

    public String getEnteredTextInSingUpFormField(By selector){
        return driver.findElement(selector).getAttribute("value");
    }

    public void addKeysInSingUpFormFields(List<By> selector, List<String> expectedList){

        for (int i = 0; i < selector.size(); i++){
        enterTextInSingUpFormPole(selector.get(i), expectedList.get(i));}
}

    public List<String> getActualEnteredTextList(List<By> selector) {
        List<String> actualEnteredTextList = new ArrayList<>();

        for (int i = 0; i < selector.size(); i++) {
            actualEnteredTextList.add(getEnteredTextInSingUpFormField(selector.get(i)));
        }

    return actualEnteredTextList;}

}
