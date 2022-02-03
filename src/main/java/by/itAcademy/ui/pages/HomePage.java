package by.itAcademy.ui.pages;


import org.openqa.selenium.WebDriver;


public class HomePage {

    private WebDriver driver;

    public String pageUrl = "https://www.last.fm/home";


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage  openHomePage() {
        driver.get(pageUrl);
        return this;
    }




}
