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
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Auth {

    private static String authToken;

    private static String sk;

    private static String path = "src/main/resources/";

    private static String fileNameWithExtension = "authToken.txt";

    private static String getAuthTokenFromResponse() throws IOException, URISyntaxException {


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

    private static String getAuthTokenFromFile() {
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
        String token = DigestUtils.md5Hex(getAuthTokenFromResponse());
        String apiSig = "api_keyecf62d464eaf8f5ee50df045c9740ab81methodauth.getSessiond3934cd4a39360fe6f742c040bc4802";
        String md5Hex = DigestUtils.md5Hex(apiSig);

        List<NameValuePair> authParams = new ArrayList<>();

        authParams.add(new BasicNameValuePair(EndPoints.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(EndPoints.TOKEN, token));
        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
        authParams.add(new BasicNameValuePair(EndPoints.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(httpGet);
        String responseText = EntityUtils.toString(response.getEntity());

//        JSONObject responseJson = new JSONObject(responseText);
//        sk = responseJson.getString("key");

        return responseText;
    }

}
