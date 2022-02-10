package by.itAcademy.api.methods;

import by.itAcademy.api.endpoints.EndPoints;
import by.itAcademy.utils.FileHandler;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.URIBuild;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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

    public static String getAuthTokenFromResponse() throws IOException, URISyntaxException {


        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair(EndPoints.METHOD_PARAMETER, "auth.getToken"));
        authParams.add(new BasicNameValuePair(EndPoints.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(EndPoints.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(httpGet);
        String responseText = EntityUtils.toString(response.getEntity());

        JSONObject responseJson = new JSONObject(responseText);
        authToken = responseJson.getString("token");

        FileHandler.writeToFile(authToken, path, fileNameWithExtension);
        return authToken;
    }

    public static String getAuthTokenFromFile() {
        return FileHandler.readFile(path, fileNameWithExtension);
    }

    public static String getAuthToken() {
        authToken = null;
        authToken = getAuthTokenFromFile();
        if (authToken == null) {
            try {
                authToken = getAuthTokenFromResponse();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            try {
                FileHandler.writeToFile(authToken, path, fileNameWithExtension);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return authToken;
    }


    public static String getAuthGetSession() throws IOException, URISyntaxException {
        //String token = getAuthTokenFromResponse();
        String apiSig = "api_key" + Property.getPropertyValue("api_key") +
                "methodauth.getMobileSession" + "password" + Property.getPropertyValue("password")
                + "username" + Property.getPropertyValue("user") + Property.getPropertyValue("sc");
        System.out.println(apiSig);
        String md5Hex = DigestUtils.md5Hex(unescape(apiSig));
        System.out.println(md5Hex);

//        List<NameValuePair> authParams = new ArrayList<>();
//        authParams.add(new BasicNameValuePair(EndPoints.PASSWORD, Property.getPropertyValue("password")));
//        authParams.add(new BasicNameValuePair(EndPoints.USER_NAME, Property.getPropertyValue("user")));
//        authParams.add(new BasicNameValuePair(EndPoints.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
//        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
//        authParams.add(new BasicNameValuePair(EndPoints.FORMAT_PARAMETER, "json"));
//
//        HttpClient client = HttpClients.createDefault();
//        System.out.println(URIBuild.getURIInquiryGet(authParams));
//        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));
//
//        HttpResponse response = client.execute(httpGet);
//        String responseText = EntityUtils.toString(response.getEntity());
        HttpClient client = HttpClients.createDefault();


        //tokenRequest.addHeader("Authorization", "Basic d2ViYXBwOg==");
        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair(EndPoints.PASSWORD, Property.getPropertyValue("password")));
        authParams.add(new BasicNameValuePair(EndPoints.USER_NAME, Property.getPropertyValue("user")));
        authParams.add(new BasicNameValuePair(EndPoints.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
        HttpPost tokenRequest = new HttpPost(URIBuild.getURIInquiryGet(authParams));
        //tokenRequest.setEntity(new UrlEncodedFormEntity(authParams, Charset.defaultCharset()));
        HttpResponse response = client.execute(tokenRequest);
        System.out.println(tokenRequest);
        System.out.println(response.getStatusLine().getStatusCode());
//        if (response.getStatusLine().getStatusCode() != 200) {
//            throw new RuntimeException("Api login failed");
//        }
        String responseText = EntityUtils.toString(response.getEntity());

        //JSONObject responseJson = new JSONObject(responseText);
       // sk = responseJson.getString("key");

        return responseText;
    }

}
