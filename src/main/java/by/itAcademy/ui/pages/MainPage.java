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

    public static final By followUsMenu =
            By.xpath("//h2[text()=\"Follow Us\"]/..//li");

    private final By followUsFacebook =
            By.xpath("//li/a[text()=\"Facebook\"]");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public MainPage  openMainPage()
    {
        driver.get("https://www.last.fm");
        return this;
    }

    public void clickFacebookLink(){
        driver.findElement(followUsFacebook).click();
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
