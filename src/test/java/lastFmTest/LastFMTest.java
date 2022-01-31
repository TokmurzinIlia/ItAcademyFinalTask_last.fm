package lastFmTest;

import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.utils.chromeDriver.Driver;
import lastFmTest.data.DataForMainPageTextBlock;
import lastFmTest.data.DataForSocialNetworkLink;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastFMTest {

    private static WebDriver driver;

    @BeforeEach
    public void getDriver() {
        driver = Driver.getChromeDriver();
    }

    @AfterEach
    public void closeDriver(){
        Driver.quitDriver();
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForMainPageTextBlock.class)
    public void checkElementPrimaryNavigationMenu(By selector, List<String> str, String name){

        List<String> actualWebElementList = new MainPage(driver)
                .openMainPage()
                .getTextElementFromBlock(selector);

        List<String> expectedWebElementList = str;

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForSocialNetworkLink.class)
    public void checkFacebookLinkURL(By selector, String expectedLink, String name) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .openMainPage()
                .clickSocialNetworkLink(selector);

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        String url = driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));

        assertEquals(expectedLink, url);
    }


}
