package by.itAcademy.utils;

import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Waiter {

    private static final int WAIT_FOR_ELEMENT_SECONDS = 10;
    private static final int POLLING_TIME_DURATION_MILLIS = 100;

    private Wait<WebDriver> wait = new FluentWait<>(Driver.getChromeDriver()).withTimeout(Duration.ofSeconds(WAIT_FOR_ELEMENT_SECONDS))
            .pollingEvery(Duration.ofMillis(POLLING_TIME_DURATION_MILLIS))
            .ignoring(NoSuchElementException.class)
            .ignoring(ElementNotInteractableException.class)
            .ignoring(StaleElementReferenceException.class);

    public WebElement waitUntilElementToBeClickable(By selector) {
        return wait.until(ExpectedConditions.elementToBeClickable(Driver.getChromeDriver().findElement(selector)));
    }

    public WebElement waitUntilElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable((webElement)));
    }

    public WebElement waitUntilAttributeToBeNotEmpty(WebElement element, String attribute) {
        new WebDriverWait(Driver.getChromeDriver(), WAIT_FOR_ELEMENT_SECONDS).
                until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
        return element;
    }


    public void waitPresenceOfAllElementsLocatedBy(By selector) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }



}