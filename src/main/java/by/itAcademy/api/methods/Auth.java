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

import javax.xml.bind.SchemaOutputResolver;
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
        System.out.println(URIBuild.getURIInquiryGet(authParams));
        JSONObject responseJson = new JSONObject(responseText);
        authToken = responseJson.getString("token");

        FileHandler.writeToFile(authToken, path, fileNameWithExtension);
        System.out.println(authToken);
        System.out.println(httpGet);
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(EntityUtils.toString(response.getEntity()));
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
        String token = getAuthToken();

        List<NameValuePair> authParams = new ArrayList<>();

        String apiSig = "api_key" + Property.getPropertyValue("api_key") +
                "method" +"auth.getSession" + "token" + token + Property.getPropertyValue("sc");
        System.out.println(token);
        System.out.println(apiSig);
        String md5Hex = DigestUtils.md5Hex(unescape(apiSig));
        System.out.println(md5Hex);


        authParams.add(new BasicNameValuePair(EndPoints.TOKEN, token));
        authParams.add(new BasicNameValuePair(EndPoints.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
        authParams.add(new BasicNameValuePair(EndPoints.METHOD_PARAMETER, "auth.getSession"));

        HttpClient client = HttpClients.createDefault();
        System.out.println(URIBuild.getURIInquiryGet(authParams));
        HttpGet tokenRequest = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(tokenRequest);
        System.out.println(tokenRequest);
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(EntityUtils.toString(response.getEntity()));


        return sk;
    }

}
