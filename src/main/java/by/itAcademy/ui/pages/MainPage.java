package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BaseMethodPages {


    private final String mainPageURL = "https://www.last.fm";

    @Step("Open main page")
    public MainPage  openMainPage() {
        Driver.getChromeDriver().navigate().to(mainPageURL);
        return this;
    }

}
