package testLastFm.test;

import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnd2End {

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

        String actualURL = Driver.getChromeDriver().getCurrentUrl();

        headerBlock.clickAvatar();

        String actualName =  userPage.getUserName();

        assertAll(
                () -> assertEquals(actualURL, actualURL),
                () -> assertEquals(actualName, Property.getPropertyValue("user")));

    }

}
