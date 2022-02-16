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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.nodes.Entities.unescape;

public class TrackUnLove {
    @Step("Send a request to receive session key")
    public static HttpResponse postTrackUnLove(String track, String artist) throws IOException, URISyntaxException {
        String token = Auth.getAuthTokenFromFile();
        String sk = FileHandler.readFile(Auth.getPath(), "sessionKey.txt");
        List<NameValuePair> authParams = new ArrayList<>();

        String apiSig =  "api_key" + Property.getPropertyValue("api_key") +
                "method" +"track.unlove"+ "track" + track +"artist" + artist + Property.getPropertyValue("sc");

        String md5Hex = DigestUtils.md5Hex(unescape(apiSig));
        System.out.println(md5Hex);

        byte[] bytes = track.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedTrack = new String(bytes, StandardCharsets.UTF_8);
        bytes = artist.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedArtist = new String(bytes, StandardCharsets.UTF_8);

        authParams.add(new BasicNameValuePair(Constant.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(Constant.METHOD_PARAMETER, "track.unlove"));
        authParams.add(new BasicNameValuePair("track", utf8EncodedTrack));
        authParams.add(new BasicNameValuePair("artist", utf8EncodedArtist));
        authParams.add(new BasicNameValuePair("api_sig", md5Hex));
        authParams.add(new BasicNameValuePair("sk", sk));

        //authParams.add(new BasicNameValuePair(Constant.FORMAT_PARAMETER, "json"));
//        HttpClient client = HttpClients.createDefault();
//        HttpPost tokenRequest = new HttpPost(applicationUrl+"oauth/token");
//        tokenRequest.addHeader("Authorization", "Basic d2ViYXBwOg==");
//        List<NameValuePair> authParams = new ArrayList<>();
//        authParams.add(new BasicNameValuePair("username",username));
//        authParams.add(new BasicNameValuePair("password",password));
//        authParams.add(new BasicNameValuePair("grant_type","password"));
//        authParams.add(new BasicNameValuePair("scope","deltix.axa.user"));
//        tokenRequest.setEntity(new UrlEncodedFormEntity(authParams, Charset.defaultCharset()));
//        HttpResponse response = client.execute(tokenRequest);
//        if (response.getStatusLine().getStatusCode() != 200) {
//            throw new RuntimeException("Api login failed");
//        }
//        String responseText = EntityUtils.toString(response.getEntity());
        System.out.println(authParams);
        HttpClient client = HttpClients.createDefault();
        HttpPost trackRequest = new HttpPost(URIBuild.getURIInquiryGet());
        trackRequest.setEntity(new UrlEncodedFormEntity(authParams, Charset.defaultCharset()));
        System.out.println(trackRequest);
        HttpResponse response = client.execute(trackRequest);
        String responseText = EntityUtils.toString(response.getEntity());
        System.out.println(responseText);
        System.out.println(response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Api login failed");
        }

        return response;
    }
}
