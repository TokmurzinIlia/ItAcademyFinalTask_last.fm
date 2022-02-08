
import by.itAcademy.api.methods.Auth;
import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.ui.pages.MainPage;

import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.ui.pages.UserPage;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

import java.net.URISyntaxException;




public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println(Auth.getAuthGetSession());



    }
}
