package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private final By userNameFromPage = By.cssSelector("h1[class=\"header-title\"]");
    private final By headerAvatar = By.cssSelector("div[class=\"header-avatar\"]");

    public By getUserNameFromPage() {
        return userNameFromPage;
    }


    @Step("Get user name from user page")
    public String getUserName(){
        return driver.findElement(userNameFromPage)
                .getText();
    }
}
