package by.itAcademy.ui.pages;


import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private final By avatar =
            By.cssSelector("a[aria-controls=\"auth-dropdown\"]");
    public String pageUrl = "https://www.last.fm/home";


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage  openHomePage() {
        driver.get(pageUrl);
        return this;
    }

    public HomePage goToAvatar(){


        Actions actions = new Actions(driver);
        WebElement avatarElement = driver.findElement(avatar);
        actions.moveToElement(avatarElement).build().perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .attributeToBe(avatar, "class", "auth-link auth-dropdown-toggle disclose-active"));
        return this;

    }

}
