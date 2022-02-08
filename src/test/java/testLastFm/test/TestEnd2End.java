package testLastFm.test;

import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.ui.pages.*;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnd2End {

    @AfterEach

    public void tearDown() {
        BaseMethodPages.checkLogOut();
    }

    @AfterAll
    public static void closeDriver(){
        Driver.quitDriver();
    }

    @Test
    public void logInTest() throws IOException {

        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        UserPage userPage = new UserPage();
        HeaderBlock headerBlock = new HeaderBlock();

        mainPage.openMainPage();

        headerBlock.clickSingInButton();

        singInPage
                    .logIn(Property.getPropertyValue("user"),
                            Property.getPropertyValue("password"));

        String actualURL = userPage.getCurrentUrl();

        headerBlock.clickAvatar();

        String actualNameFromUserPage =  userPage.getUserName();
        String actualNamesFromDropDownMenuAvatar =  headerBlock.getActualNamesFromDropDownMenuAvatar();

        assertAll(
                () -> assertEquals(actualURL, actualURL),
                () -> assertEquals(actualNamesFromDropDownMenuAvatar, Property.getPropertyValue("user")),
                () -> assertEquals(actualNameFromUserPage, Property.getPropertyValue("user")));

    }

    @Test
    public void updateAvatarTest() throws IOException {
        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        HeaderBlock headerBlock = new HeaderBlock();
        SettingsPage settingsPage = new SettingsPage();
        mainPage.openMainPage();
        headerBlock.clickSingInButton();

        singInPage
                .logIn(Property.getPropertyValue("user"),
                        Property.getPropertyValue("password"));

        headerBlock.clickAvatar();
        headerBlock.click(headerBlock.getSettingsFromDropDownMenuAvatar());
        settingsPage.addAvatar(settingsPage.getPATH_TO_AVATAR());
        settingsPage.click(settingsPage.getInputAvatarButton());
        WebElement expectedElement = settingsPage.searchElement(settingsPage.getElementAcceptAvatar());

        assertTrue(expectedElement.isDisplayed());

    }

    @Test
    public void updateProfileDataTest() throws IOException {
        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        HeaderBlock headerBlock = new HeaderBlock();
        SettingsPage settingsPage = new SettingsPage();
        mainPage.openMainPage();
        headerBlock.clickSingInButton();

        singInPage
                .logIn(Property.getPropertyValue("user"),
                        Property.getPropertyValue("password"));


        headerBlock.clickAvatar();
        headerBlock.click(headerBlock.getSettingsFromDropDownMenuAvatar());
        settingsPage.clear(settingsPage.getDisplayNameField());
        settingsPage.sendKey(settingsPage.getDisplayNameField(), "Ilia");
        settingsPage.setValueFromSelect(settingsPage.getCountryField(), "None");
        settingsPage.setValueFromSelect(settingsPage.getCountryField(), "Belarus");
        settingsPage.clear(settingsPage.getWebSiteField());
        settingsPage.sendKey(settingsPage.getWebSiteField(), "http://www.iliatokmurzin.com");
        settingsPage.clear(settingsPage.getAboutYouField());
        settingsPage.sendKey(settingsPage.getAboutYouField(), "kjhgtyuirtyu");
        settingsPage.click(settingsPage.getSaveChangesUpdateProfileButton());

        WebElement expectedElement = settingsPage.searchElement(settingsPage.getElementAcceptUserData());

        assertTrue(expectedElement.isDisplayed());


    }

}
