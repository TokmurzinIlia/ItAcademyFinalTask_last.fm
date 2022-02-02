package by.itAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {

    private WebDriver driver;

    private final By userNameFromPage = By.cssSelector("h1[class=\"header-title\"]");

    public UserPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public UserPage  openUserPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAvatar();
        return this;
    }

    public String getUserName(){
        return driver.findElement(userNameFromPage)
                .getText();
    }
}
