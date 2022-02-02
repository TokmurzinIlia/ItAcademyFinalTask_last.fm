package by.itAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    private final By avatar =
            By.cssSelector("img[class=\"auth-avatar-desktop\"]");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage  openHomePage() {
        driver.get("https://www.last.fm/home");
        return this;
    }

    public void goToAvatar(){
        Actions actions = new Actions(driver);
        WebElement avatarElement = driver.findElement(avatar);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(avatarElement));
        actions.moveToElement(avatarElement).perform();
    }
}
