package testLastFm.test;

import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.ui.pages.SingUpPage;
import by.itAcademy.utils.chromeDriver.Driver;
import testLastFm.data.DataForMainPageTextBlock;
import testLastFm.data.DataForSingUpValidationForm;
import testLastFm.data.DataForSocialNetworkLink;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
//@RunWith(JUnitPlatform.class)
public class TestLastFM {

    private static WebDriver driver;

    @BeforeAll
    public static void getDriver() {
        driver = Driver.getChromeDriver();
    }

    @AfterAll
    public static void closeDriver(){
        Driver.quitDriver();
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForMainPageTextBlock.class)
    public void checkElementPrimaryNavigationMenu(By selector, List<String> str, String name){

        List<String> actualWebElementList = new MainPage()
                .openMainPage()
                .getTextElementFromBlock(selector);

        List<String> expectedWebElementList = str;

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForSocialNetworkLink.class)
    public void checkFacebookLinkURL(By selector, String expectedLink, String name) throws InterruptedException {
        MainPage mainPage = new MainPage();

        mainPage
                .openMainPage()
                .clickSocialNetworkLink(selector);

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        String actualUrl = driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));

        assertEquals(expectedLink, actualUrl);
    }

    @ParameterizedTest(name = "{index}")
    @ArgumentsSource(DataForSingUpValidationForm.class)
    public void singUpFormValidation(List<By> selector,List<String> expectedList)  {
        SingUpPage singUpPage = new SingUpPage();

        List<String> actualWebElementList =
            singUpPage
                .openSingUpPage()
                .getTextElementNameFromSingUpForm();

        for (int i = 0; i < selector.size(); i++){
        singUpPage.enterTextInSingUpFormPole(selector.get(i), expectedList.get(i));}

        List<String> actualEnteredTextList = new ArrayList<>();

        for (int i = 0; i < selector.size(); i++){
            actualEnteredTextList.add(singUpPage.getEnteredTextInSingUpFormField(selector.get(i)));}

        assertAll(
                () -> assertEquals(expectedList, actualWebElementList),
                () -> assertEquals(expectedList, actualEnteredTextList));
    }


}
