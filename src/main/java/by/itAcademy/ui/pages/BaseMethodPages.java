package by.itAcademy.ui.pages;

import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public String getCurrentUrlFromSecondTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        String actualUrlFromSecondTab = driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return actualUrlFromSecondTab;
    }

}
