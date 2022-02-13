package testLastFm.test;

import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.ui.pages.SettingsPage;
import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Log;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import testLastFm.data.dataForEnd2End.DataForAddNewPlayList;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEnd2End {


    @AfterEach

    public void tearDown() {
        UserPage userPage = new UserPage();
        userPage.checkLogOut();
    }

    @AfterAll
    public static void closeDriver(){
        Driver.quitDriver();
    }

    @Order(1)
    @Test
    public void logInTest() throws IOException {

        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        UserPage userPage = new UserPage();
        HeaderBlock headerBlock = new HeaderBlock();

        mainPage.openMainPage();
        Log.info("Main page opened");

        headerBlock.clickSingInButton();
        Log.info("Clicked sing in button");
        singInPage
                    .logIn(Property.getPropertyValue("user"),
                            Property.getPropertyValue("password"));
        Log.info("Account logged in");
        String actualURL = userPage.getCurrentUrl();
        Log.info("Taken current URL");
        headerBlock.clickAvatar();
        Log.info("Avatar has been clicked");
        String actualNameFromUserPage =  userPage.getUserName();
        Log.info("Taken actual name from user page");
        String actualNamesFromDropDownMenuAvatar =  headerBlock.getActualNamesFromDropDownMenuAvatar();
        Log.info("Taken actual name from drop down menu avatar");
        assertAll(
                () -> assertEquals("https://www.last.fm/home", actualURL),
                () -> assertEquals(Property.getPropertyValue("user"), actualNamesFromDropDownMenuAvatar),
                () -> assertEquals(Property.getPropertyValue("user"), actualNameFromUserPage));
        userPage.logOut();
        Log.info("log out made");
    }

    @Order(2)
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

        settingsPage.logOut();
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource({"Ilia, Belarus, http://www.iliatokmurzin.com, Hello. My name is Ilia"})
    public void updateProfileDataTest(String name, String country, String myURL, String aboutMe) throws IOException {
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
        settingsPage.sendKey(settingsPage.getDisplayNameField(), name);
        settingsPage.setValueFromSelect(settingsPage.getCountryField(), country);
        settingsPage.clear(settingsPage.getWebSiteField());
        settingsPage.sendKey(settingsPage.getWebSiteField(), myURL);
        settingsPage.clear(settingsPage.getAboutYouField());
        settingsPage.sendKey(settingsPage.getAboutYouField(), aboutMe);
        settingsPage.click(settingsPage.getSaveChangesUpdateProfileButton());

        WebElement expectedElement = settingsPage.searchElement(settingsPage.getElementAcceptUserData());

        assertTrue(expectedElement.isDisplayed());

        settingsPage.logOut();
    }

    @Order(4)
    @ParameterizedTest
    @ArgumentsSource(DataForAddNewPlayList.class)
    public void addTrackInNewPlayList(List<String> expectedList) throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        HeaderBlock headerBlock = new HeaderBlock();
        UserPage userPage = new UserPage();
        mainPage.openMainPage();
        headerBlock.clickSingInButton();
        singInPage
                .logIn(Property.getPropertyValue("user"),
                        Property.getPropertyValue("password"));
        headerBlock.clickAvatar();
        userPage.click(userPage.getPlayListButton());
        userPage.click(userPage.getNewPlayListButton());
        userPage.click(userPage.getStartFromScratchButton());
        userPage.addTrackInNewPlayList(expectedList);

        int actualNumberOfSongs = userPage.getTextElementFromBlock(userPage.getSongsFromPlayList()).size();

        assertEquals(expectedList.size(), actualNumberOfSongs);

        userPage.logOut();
    }

    @Order(5)
    @ParameterizedTest
    @CsvSource("My New Playlist")
    public void deletePlayList(String namePlayList) throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        SingInPage singInPage = new SingInPage();
        HeaderBlock headerBlock = new HeaderBlock();
        UserPage userPage = new UserPage();
        mainPage.openMainPage();
        headerBlock.clickSingInButton();
        singInPage
                .logIn(Property.getPropertyValue("user"),
                        Property.getPropertyValue("password"));
        headerBlock.clickAvatar();
        userPage.click(userPage.getPlayListButton());
        int quantityBeforeRemoval = userPage.getTextElementFromBlock(userPage.getPlayLists()).size();
        userPage.deletePlayListByName(namePlayList);
        int quantityAfterRemoval = userPage.getTextElementFromBlock(userPage.getPlayLists()).size();
        int difference = quantityBeforeRemoval - quantityAfterRemoval;

        assertEquals( 1, difference);

        userPage.logOut();
    }

}
