package by.itAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {

    private WebDriver driver;

    public static final By primaryNavigationMenuElement =
            By.cssSelector("ul[class=\"js-navlist-items navlist-items\"]>li[class=\"masthead-nav-item\"]");

    public static final By siteAuthItemMenuElement =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li[class=\"site-auth-item\"]");

    public static final By companyMenuElement =
            By.xpath("//h2[text()=\"Company\"]/..//li");

    public static final By helpMenuElement =
            By.xpath("//h2[text()=\"Help\"]/..//li");

    public static final By goodiesMenuElement =
            By.xpath("//h2[text()=\"Goodies\"]/..//li");

    public static final By accountMenuElement =
            By.xpath("//h2[text()=\"Account\"]/..//li");

    public static final By followUsMenuElement =
            By.xpath("//h2[text()=\"Follow Us\"]/..//li");

    public static final By followUsFacebook =
            By.xpath("//li/a[text()=\"Facebook\"]");

    public static final By followUsTwitter =
            By.xpath("//li/a[text()=\"Twitter\"]");

    public static final By followUsInstagram =
            By.xpath("//li/a[text()=\"Instagram\"]");

    public static final By followUsYouTube =
            By.xpath("//li/a[text()=\"YouTube\"]");

    private final By singUpButton =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li>a[href=\"/join\"]");

    private final By singInButton =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li>a[href=\"/login\"]");







    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public MainPage  openMainPage() {
        driver.get("https://www.last.fm");
        return this;
    }

    public void clickSocialNetworkLink(By selector){
        driver.findElement(selector).click();
    }

    public void clickSingUpButton(){ driver.findElement(singUpButton).click();}

    public void clickSingInButton(){ driver.findElement(singInButton).click();}

    public List<String> getTextElementFromBlock(By selector){

        return driver.findElements(selector)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

//    public List<String> getTextElementFollowUsMenu(){
//
//
//        return driver.findElements(followUsMenu)
//                .stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }

}
