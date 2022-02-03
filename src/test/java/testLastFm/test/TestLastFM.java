package testLastFm.test;

import by.itAcademy.ui.pages.MainPage;
import by.itAcademy.ui.pages.SingUpPage;
import by.itAcademy.utils.chromeDriver.Driver;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import testLastFm.data.DataForMainPageTextBlock;
import testLastFm.data.DataForSingUpValidationForm;
import testLastFm.data.DataForSocialNetworkLink;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(JUnitPlatform.class)
public class TestLastFM {

    @AfterAll
    public static void closeDriver(){
        Driver.quitDriver();
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForMainPageTextBlock.class)
    public void checkElementPrimaryNavigationMenu(By selector, List<String> expectedWebElements, String name){

        List<String> actualWebElementList = new MainPage()
                .openMainPage()
                .getTextElementFromBlock(selector);

        List<String> expectedWebElementList = expectedWebElements;

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @ParameterizedTest(name = "{2}")
    @ArgumentsSource(DataForSocialNetworkLink.class)
    public void checkFacebookLinkURL(By selector, String expectedLink, String name) throws InterruptedException {
        MainPage mainPage = new MainPage();

        mainPage
                .openMainPage()
                .clickSocialNetworkLink(selector);

        String actualUrl = mainPage.getCurrentUrlFromSecondTab();

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

        singUpPage.addKeysInSingUpFormFields(selector, expectedList);

        List<String> actualEnteredTextList = singUpPage.getActualEnteredTextList(selector);

        assertAll(
                () -> assertEquals(expectedList, actualWebElementList),
                () -> assertEquals(expectedList, actualEnteredTextList));
    }


}
