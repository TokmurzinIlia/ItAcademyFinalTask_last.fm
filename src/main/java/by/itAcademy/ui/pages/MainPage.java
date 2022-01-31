package by.itAcademy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {

    private WebDriver driver;

    public static final By primaryNavigationMenu =
            By.cssSelector("ul[class=\"js-navlist-items navlist-items\"]>li[class=\"masthead-nav-item\"]");

    public static final By siteAuthItemMenu =
            By.cssSelector("ul[class=\" site-auth site-auth--anon hidden-xs \"]>li[class=\"site-auth-item\"]");

    public static final By companyMenu =
            By.xpath("//h2[text()=\"Company\"]/..//li");

    public static final By helpMenu =
            By.xpath("//h2[text()=\"Help\"]/..//li");

    public static final By goodiesMenu =
            By.xpath("//h2[text()=\"Goodies\"]/..//li");

    public static final By accountMenu =
            By.xpath("//h2[text()=\"Account\"]/..//li");

    public static final By followUsMenu =
            By.xpath("//h2[text()=\"Follow Us\"]/..//li");

    public static final By followUsFacebook =
            By.xpath("//li/a[text()=\"Facebook\"]");

    public static final By followUsTwitter =
            By.xpath("//li/a[text()=\"Twitter\"]");

    public static final By followUsInstagram =
            By.xpath("//li/a[text()=\"Instagram\"]");

    public static final By followUsYouTube =
            By.xpath("//li/a[text()=\"YouTube\"]");



    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public MainPage  openMainPage()
    {
        driver.get("https://www.last.fm");
        return this;
    }

    public void clickSocialNetworkLink(By selector){
        driver.findElement(selector).click();
    }

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
