package lastFmTest;

import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.utils.chromeDriver.Driver;
import lastFmTest.data.DataForMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Test
    public void checkElementPrimaryNavigationMenu(){

        List<String> actualWebElementList = new MainPage(driver)
                .openMainPage()
                .getTextElementPrimaryNavigationMenu();

        List<String> expectedWebElementList = new DataForMainPage().primaryNavigationMenu;

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Test
    public void checkElementFollowUsMenu(){

        List<String> actualWebElementList = new MainPage(driver)
                .openMainPage()
                .getTextElementFollowUsMenu();

        List<String> expectedWebElementList = new DataForMainPage().followUsMenu;

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Test
    public void checkFacebookLinkURL() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .openMainPage()
                .clickFacebookLink();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        String url = driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(5000);
        System.out.println(url);
        assertEquals("https://www.facebook.com/lastfm", url);
    }


}
