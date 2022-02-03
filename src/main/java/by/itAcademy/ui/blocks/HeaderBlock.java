package by.itAcademy.ui.blocks;

import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderBlock {

    private WebDriver driver = Driver.getChromeDriver();

    public HeaderBlock() {
    }

    private final By primaryNavigationMenuElement =
            By.cssSelector("ul[class=\"js-navlist-items navlist-items\"]>li[class=\"masthead-nav-item\"]");

    private  final By siteAuthItemMenuElement =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li[class=\"site-auth-item\"]");

    private final By singUpButton =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li>a[href=\"/join\"]");

    private final By singInButton =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li>a[href=\"/login\"]");

    private final By avatar =
            By.cssSelector("img[class=\"auth-avatar-desktop\"]");

    public By getPrimaryNavigationMenuElement() {
        return primaryNavigationMenuElement;
    }

    public By getSiteAuthItemMenuElement() {
        return siteAuthItemMenuElement;
    }

    public By getSingUpButton() {
        return singUpButton;
    }

    public By getSingInButton() {
        return singInButton;
    }

    public void clickSingUpButton(){ driver.findElement(singUpButton).click();}

    public void clickSingInButton(){ driver.findElement(singInButton).click();}

    public void clickAvatar(){
        driver.findElement(avatar).click();
    }

    public String getActualNamesFromDropDownMenuAvatar() {
        return  driver.findElement(By.cssSelector("a[class=\"auth-dropdown-menu-item\"]>strong")).getText();
    }

    public void goToAvatar(){
        Actions actions = new Actions(driver);
        WebElement avatarElement = driver.findElement(avatar);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(avatarElement));
        actions.moveToElement(avatarElement).perform();
    }
}
