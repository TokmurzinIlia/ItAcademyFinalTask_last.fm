package by.itAcademy.ui.pages;

import by.itAcademy.ui.blocks.FooterBlock;
import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.utils.Waiter;
import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    Waiter waiter = new Waiter();

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    @Step("Get current URL from second tab")
    public String getCurrentUrlFromSecondTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        String actualUrlFromSecondTab = driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return actualUrlFromSecondTab;
    }

    @Step("Enter text {1} in the field {0}")
    public void sendKey(By selector, String text){

        waiter.waitUntilElementToBeClickable((selector)).sendKeys(text);
        waiter.waitUntilAttributeToBeNotEmpty(driver.findElement(selector), "value");

    }
    @Step("Click ENTER")
    public void sendKey(By selector, Keys key){
        driver.findElement(selector).sendKeys(key);

    }

    @Step("Clear input field {0}")
    public void clear(By selector){
       waiter.waitUntilElementToBeClickable((selector)).clear();


    }

    @Step("Select a field {1} from the dropdown list {0}")
    public void setValueFromSelect(By selector, String text){
        waiter.waitUntilElementToBeClickable((selector));
        Select select = new Select(driver.findElement(selector));
        select.selectByVisibleText(text);
    }

    @Step("Click on an element {0}")
    public void click(By selector){
        waiter.waitUntilElementToBeClickable((selector)).click();
    }

    @Step("Search element {0}")
    public WebElement searchElement(By selector){
        return driver.findElement(selector);
    }

    @Step("Checking if an element is missing {0}")
    public boolean elementIsNotPresent(By selector){
        return driver.findElements(selector).isEmpty();

    }

    @Step("Get text elements from block {0} and put into list")
    public List<String> getTextElementFromBlock(By selector){

        return driver.findElements(selector)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Log out")
    public void logOut() {
        HeaderBlock headerBlock = new HeaderBlock();
        FooterBlock footerBlock = new FooterBlock();

            footerBlock.searchElement(footerBlock.getLogOutButton()).click();
        waiter.waitUntilElementToBeClickable(headerBlock.searchElement(headerBlock.getSingInButton()));
    }

    @Step("Checking out of the account and exiting it if it has not been done before")
    public void checkLogOut() {
        HeaderBlock headerBlock = new HeaderBlock();

        if (headerBlock.elementIsNotPresent(headerBlock.getSingInButton())) {
           logOut();
        }
    }

    @Step("Get entered text in registration form field {0} from 'value' attribute")
    public String getEnteredTextFormField(By selector){
        return driver.findElement(selector).getAttribute("value");
    }

    @Step("Enter data into form fields")
    public void addKeysInFormFields(List<By> selector, List<String> expectedList){

        for (int i = 0; i < selector.size(); i++){
            sendKey(selector.get(i), expectedList.get(i));}
    }

    @Step("Get a list of the actual text entered into the form fields")
    public List<String> getActualEnteredTextList(List<By> selector) {
        List<String> actualEnteredTextList = new ArrayList<>();

        for (int i = 0; i < selector.size(); i++) {
            actualEnteredTextList.add(getEnteredTextFormField(selector.get(i)));
        }

        return actualEnteredTextList;}
}

