package by.itAcademy.ui.blocks;

import by.itAcademy.ui.pages.BaseMethodPages;
import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterBlock extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    public FooterBlock() {
    }

    private final By logOutButton =
            By.xpath("//button[contains( text(), \"Logout\")]");
    private final By companyMenuElement =
            By.xpath("//h2[text()=\"Company\"]/..//li");

    private final By helpMenuElement =
            By.xpath("//h2[text()=\"Help\"]/..//li");

    private final By goodiesMenuElement =
            By.xpath("//h2[text()=\"Goodies\"]/..//li");

    private final By accountMenuElement =
            By.xpath("//h2[text()=\"Account\"]/..//li");

    private final By followUsMenuElement =
            By.xpath("//h2[text()=\"Follow Us\"]/..//li");

    private final By followUsFacebook =
            By.xpath("//li/a[text()=\"Facebook\"]");

    private final By followUsTwitter =
            By.xpath("//li/a[text()=\"Twitter\"]");

    private final By followUsInstagram =
            By.xpath("//li/a[text()=\"Instagram\"]");

    private final By followUsYouTube =
            By.xpath("//li/a[text()=\"YouTube\"]");

    private final By settings = By.xpath("//div[@class=\"footer-top-col\"]//a[@href=\"/settings\"]");

    public By getSettings() {
        return settings;
    }

    public By getLogOutButton() {
        return logOutButton;
    }

    public By getCompanyMenuElement() {
        return companyMenuElement;
    }

    public By getHelpMenuElement() {
        return helpMenuElement;
    }

    public By getGoodiesMenuElement() {
        return goodiesMenuElement;
    }

    public By getAccountMenuElement() {
        return accountMenuElement;
    }

    public By getFollowUsMenuElement() {
        return followUsMenuElement;
    }

    public By getFollowUsFacebook() {
        return followUsFacebook;
    }

    public By getFollowUsTwitter() {
        return followUsTwitter;
    }

    public By getFollowUsInstagram() {
        return followUsInstagram;
    }

    public By getFollowUsYouTube() {
        return followUsYouTube;
    }
}
