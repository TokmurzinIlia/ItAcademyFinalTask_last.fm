package by.itAcademy.api.methods;

import by.itAcademy.api.endpoints.Constant;
import by.itAcademy.utils.FileHandler;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.URIBuild;
import io.qameta.allure.Step;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.nodes.Entities.unescape;

public class Auth {

    private static String authToken;

    private static String sk;

    private static String path = "src/main/resources/";

    private static String fileNameWithExtension = "authToken.txt";

    public static String getFileNameWithExtension() {
        return fileNameWithExtension;
    }

    public static String getPath() {
        return path;
    }

    @Step("Send a request to receive auth token")
    public static HttpResponse getAuthTokenFromResponse() throws IOException, URISyntaxException {


        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair(Constant.METHOD_PARAMETER, "auth.getToken"));
        authParams.add(new BasicNameValuePair(Constant.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(Constant.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(httpGet);

        return response;}

    @Step("Get response code")
    public static String responseCode(HttpResponse response){

        return String.valueOf(response.getStatusLine().getStatusCode());
    }

    @Step("Get value from response by key {1}")
    public static String extractValue(HttpResponse response, String key) throws IOException {
        String responseText = EntityUtils.toString(response.getEntity());
        JSONObject responseJson = new JSONObject(responseText);
        return responseJson.getString(key);
    }

    @Step("Write to file {2} value {0}")
    public static void writeToFile(String expectedParameter, String fileName) throws IOException {
        FileHandler.writeToFile(expectedParameter, path, fileName);}

    @Step("Get auth token from file")
    public static String getAuthTokenFromFile() {
        return FileHandler.readFile(path, fileNameWithExtension);
    }

    @Step("Send a request to receive session key")
    public static HttpResponse getAuthGetSession() throws IOException, URISyntaxException {
        String token = getAuthTokenFromFile();

        List<NameValuePair> authParams = new ArrayList<>();

        String apiSig = "api_key" + Property.getPropertyValue("api_key") +
                "method" +"auth.getSession" + "token" + token + Property.getPropertyValue("sc");

        String md5Hex = DigestUtils.md5Hex(unescape(apiSig));


        authParams.add(new BasicNameValuePair(Constant.TOKEN, token));
        authParams.add(new BasicNameValuePair(Constant.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
        authParams.add(new BasicNameValuePair(Constant.METHOD_PARAMETER, "auth.getSession"));
        authParams.add(new BasicNameValuePair(Constant.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet tokenRequest = new HttpGet(URIBuild.getURIInquiryGet(authParams));
        HttpResponse response = client.execute(tokenRequest);

        return response;
    }

}
