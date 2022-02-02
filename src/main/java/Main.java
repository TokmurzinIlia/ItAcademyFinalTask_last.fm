
import by.itAcademy.api.methods.Auth;
import by.itAcademy.ui.pages.MainPage;

import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

import java.net.URISyntaxException;




public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver;
        driver = Driver.getChromeDriver();
//        driver.get("https://www.marvel.com/");
//        driver.findElement(By.cssSelector("a[class=\"user-menu-tab sign-in\"]"))
//                .click();
//        //driver.switchTo().frame(driver.findElement(By.cssSelector("div[class=\"content ng-scope\"]")));
//        //driver.findElement(By.xpath("//input[@type=\"email\"]")).isDisplayed();
//        driver.findElement(By.cssSelector("div[class=\"field field-username-email badgeable\"]>div[class=\"message-error message no-height ng-isolate-scope\"]")).sendKeys("dfgfdgfdg");
        MainPage mainPage = new MainPage(driver);
        UserPage userPage = new UserPage(driver);
        SingInPage singInPage = new SingInPage(driver);
        mainPage
                .openMainPage()
                .clickSingInButton();
        singInPage
                .logIn(Property.getPropertyValue("user"), Property.getPropertyValue("password"));

        userPage.openUserPage();



    }
}
