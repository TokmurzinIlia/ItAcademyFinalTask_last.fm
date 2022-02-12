package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;

public class MainPage extends BaseMethodPages {


    private final String mainPageURL = "https://www.last.fm";

    @Step("Open main page")
    public MainPage  openMainPage() {
        Driver.getChromeDriver().navigate().to(mainPageURL);
        return this;
    }

}
