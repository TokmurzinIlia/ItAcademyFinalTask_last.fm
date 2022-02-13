package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    private final String PATH_TO_AVATAR = "D:\\ItAacademy\\ДЗ\\ItAcademyFinalTask_last.fm\\src\\test\\resources\\picture.png";

    private final By inputAvatarButton = By.xpath("//span[contains(text(),\"Upload picture\")]");
    private final By displayNameField = By.cssSelector("input[id = \"id_full_name\"]");
    private final By countryField = By.cssSelector("select[id = \"id_country\"]");
    private final By webSiteField = By.id("id_homepage");
    private final By aboutYouField = By.cssSelector("textarea[name=\"about_me\"]");
    private final By saveChangesUpdateProfileButton = By.xpath("//section[@id=\"update-profile\"]//button");
    private final By inputAvatar = By.cssSelector("input[name=\"avatar\"]");
    private final By deletePictureButton = By.xpath("//button[contains(text(),\"Delete picture\")]");
    private final By elementAcceptAvatar = By.xpath("//div[contains(text(),\"Your avatar was uploaded successfully\")]");
    private final By elementAcceptUserData = By.xpath("//div[contains(text(),\"You have successfully updated your profile\")]");

    public String getPATH_TO_AVATAR() {
        return PATH_TO_AVATAR;
    }

    public By getElementAcceptUserData() {
        return elementAcceptUserData;
    }

    public By getInputAvatarButton() {
        return inputAvatarButton;
    }

    public By getDisplayNameField() {
        return displayNameField;
    }

    public By getCountryField() {
        return countryField;
    }

    public By getWebSiteField() {
        return webSiteField;
    }

    public By getAboutYouField() {
        return aboutYouField;
    }

    public By getSaveChangesUpdateProfileButton() {
        return saveChangesUpdateProfileButton;
    }

    public By getElementAcceptAvatar() {
        return elementAcceptAvatar;
    }

    public By getDeletePictureButton() {
        return deletePictureButton;
    }

    @Step("Upload avatar located at absolute path {0}")
    public void addAvatar(String text){

       waiter.waitPresenceOfAllElementsLocatedBy(inputAvatar);
        driver.findElement(inputAvatar).sendKeys(text);

    }



}
