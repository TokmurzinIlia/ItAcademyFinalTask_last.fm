package steps;

import by.itAcademy.api.methods.Auth;
import by.itAcademy.api.pojo.getSession.LFM;
import by.itAcademy.api.pojo.getSession.Session;
import by.itAcademy.ui.pages.SingInPage;
import by.itAcademy.utils.FileHandler;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.chromeDriver.Driver;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class StepGetSessionKey {

    private HttpResponse response;
    private String authToken;
    private String sessionKey;
    private WebDriver driver = Driver.getChromeDriver();

    @When("User is sends a get request to get the token")
        public HttpResponse getResponseAuthToken() throws IOException, URISyntaxException {
        return response = Auth.getAuthTokenFromResponse();
    }

    @Then("^User get response status code is \"([^\"]*)\"$")
    public void responseCode(String expectedStatusCode){
        String statusCode = Auth.responseCode(response);
        assertEquals(expectedStatusCode, statusCode);
    }

    @And("User get token")
    public String getAuthToken() throws IOException {
        authToken = Auth.extractValue(response, "token");
        assertNotNull(authToken);
        return authToken;
    }

    @And("^User write token in file \"([^\"]*)\"$")
    public void userWriteTokenInFileSessionKeyTxt(String fileName) throws IOException {
        Auth.writeToFile(authToken, fileName);
        String actualTokenFromFile = FileHandler.readFile(Auth.getPath(), fileName);
        assertEquals(authToken, actualTokenFromFile);

    }

    @Then("User open page user authorization request")
    public void userOpenPageUserAuthorizationRequest() throws IOException {
        String URI = "https://www.last.fm/api/auth?api_key=" + Property.getPropertyValue("api_key")+
                "&token=" + authToken;
        driver.get(URI);
    }

    @And("User logs in")
    public void userLogsIn() throws IOException {
        SingInPage singInPage = new SingInPage();
        singInPage
                .logIn(Property.getPropertyValue("user"),
                        Property.getPropertyValue("password"));
    }

    @And("User give access to his Last.fm account")
    public void userGiveAccessToHisLastFmAccount() {
        driver.findElement(By.xpath("//button[contains(text(), \"Yes, allow access\")]")).click();
        assertTrue(new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"alert alert-success\"]"))).isDisplayed());
    }

    @And("User close browser")
    public void userCloseBrowser() {
        driver = Driver.quitDriver();
        assertNull(driver);
    }

    @Then("User is sends a get request to get the session")
    public HttpResponse userIsSendsAGetRequestToGetTheSession() throws IOException, URISyntaxException {
        return response = Auth.getAuthGetSession();
    }


    @And("User get session key")
    public String userGetSessionKey() throws IOException {
        String responseText = EntityUtils.toString(response.getEntity());
        System.out.println(responseText);
        ObjectMapper om = new ObjectMapper();
        LFM root = om.readValue(responseText, LFM.class);
        Session str = root.getSession();
        sessionKey = str.getKey();
        System.out.println(sessionKey);
        assertNotNull(sessionKey);
        return sessionKey;
    }

    @And("^User write session key in file \"([^\"]*)\"$")
    public void userWriteSessionKeyInFile(String fileName) throws IOException {
        Auth.writeToFile(sessionKey, fileName);
        String actualSessionKeyFromFile = FileHandler.readFile(Auth.getPath(), fileName);
        assertEquals(sessionKey, actualSessionKeyFromFile);
    }
}
