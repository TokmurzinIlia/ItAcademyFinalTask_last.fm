package testLastFm.test;

import by.itAcademy.ui.pages.HomePage;
import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnd2End {

    private static WebDriver driver;

    @BeforeAll
    public static void getDriver() {
        driver = Driver.getChromeDriver();
    }

    @AfterAll
    public static void closeDriver(){
        Driver.quitDriver();
    }

    @Test
    public void logInTest() throws IOException {

        MainPage mainPage = new MainPage(driver);
        SingInPage singInPage = new SingInPage(driver);
        HomePage homePage = new HomePage(driver);
        UserPage userPage = new UserPage(driver);

        mainPage
                .openMainPage()
                .clickSingInButton();

            singInPage
                    .logIn(Property.getPropertyValue("user"), Property.getPropertyValue("password"));

        homePage.clickAvatar();

        String actualName =  userPage.getUserName();

        assertEquals(actualName, Property.getPropertyValue("user"));
    }

}
