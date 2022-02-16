import by.itAcademy.api.methods.TrackUnLove;

import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

//        HttpResponse response = Auth.getAuthTokenFromResponse();
//        System.out.println(Auth.responseCode(response));
//        String authToken = Auth.extractValue(response, "token");
//        System.out.println(authToken);
//        Auth.writeToFile(authToken, Auth.getFileNameWithExtension());
//
//        WebDriver driver = Driver.getChromeDriver();
//        String uri = "https://www.last.fm/api/auth?api_key=" + Property.getPropertyValue("api_key")+
//                "&token=" + authToken;
//        driver.get(uri);
//        SingInPage singInPage = new SingInPage();
//        singInPage
//                .logIn(Property.getPropertyValue("user"),
//                        Property.getPropertyValue("password"));
//        driver.findElement(By.xpath("//button[contains(text(), \"Yes, allow access\")]")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"alert alert-success\"]")));
//        driver.quit();
//        response = Auth.getAuthGetSession();
//        String responseText = EntityUtils.toString(response.getEntity());
//        System.out.println(responseText);
//        ObjectMapper om = new ObjectMapper();
//        LFM root = om.readValue(responseText, LFM.class);
//        Session str = root.getSession();
//        String sessionKey = str.getKey();
//
//        System.out.println(sessionKey);
//        Auth.writeToFile(sessionKey, "sessionKey.txt");
        TrackUnLove.postTrackUnLove("masterpiece", "madonna");

    }
}
