
import by.itAcademy.ui.pages.MainPage;

import by.itAcademy.utils.chromeDriver.Driver;


import java.io.IOException;

import java.net.URISyntaxException;


import static by.itAcademy.utils.chromeDriver.Driver.driver;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Driver.getChromeDriver();

        MainPage mainPage = new MainPage(driver);
        System.out.println(mainPage
                .openMainPage()
                .getTextElementPrimaryNavigationMenu());


    }
}
