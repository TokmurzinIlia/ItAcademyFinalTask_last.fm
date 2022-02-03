package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.stream.Collectors;

public class MainPage {


    private final String mainPageURL = "https://www.last.fm";

    public MainPage  openMainPage() {
        Driver.getChromeDriver().navigate().to(mainPageURL);
        return this;
    }

    public void clickSocialNetworkLink(By selector){
        Driver.getChromeDriver().findElement(selector).click();
    }



    public List<String> getTextElementFromBlock(By selector){

        return Driver.getChromeDriver().findElements(selector)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

//    public List<String> getTextElementFollowUsMenu(){
//
//
//        return driver.findElements(followUsMenu)
//                .stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }

}
