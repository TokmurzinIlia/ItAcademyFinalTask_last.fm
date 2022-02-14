package by.itAcademy.ui.blocks;

import by.itAcademy.ui.pages.BaseMethodPages;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Waiter;
import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderBlock extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    Waiter waiter = new Waiter();

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

    private final By namesFromDropDownMenuAvatar =
            By.cssSelector("a[class=\"auth-dropdown-menu-item\"]>strong");



    private final By settingsFromDropDownMenuAvatar =
            By.cssSelector("a[class=\"auth-dropdown-menu-item\"][data-analytics-label=\"settings\"]");

    public By getSettingsFromDropDownMenuAvatar() {
        return settingsFromDropDownMenuAvatar;
    }

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

    @Step("Click sing up button")
    public void clickSingUpButton(){ driver.findElement(singUpButton).click();}

    @Step("Click sing in button")
    public void clickSingInButton(){ 
        waiter.waitUntilElementToBeClickable(driver.findElement(singInButton)).click();}

    @Step("Click avatar")
    public void clickAvatar(){
        UserPage userPage = new UserPage();
        driver.findElement(avatar).click();
        waiter.waitUntilElementToBeClickable((userPage.getUserNameFromPage()));
    }

    @Step("Get actual names from drop-down menu avatar")
    public String getActualNamesFromDropDownMenuAvatar() {
        return  driver.findElement(namesFromDropDownMenuAvatar).getText();
    }

}
