package by.itAcademy.ui.pages;


import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private final By avatar =
            By.cssSelector("a[aria-controls=\"auth-dropdown\"]");
    public String pageUrl = "https://www.last.fm/home";


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Open home page")
    public HomePage  openHomePage() {
        driver.get(pageUrl);
        return this;
    }

}
