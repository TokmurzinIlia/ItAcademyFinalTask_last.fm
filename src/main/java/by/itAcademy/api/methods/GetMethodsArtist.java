package by.itAcademy.api.methods;

import by.itAcademy.api.constant.Constant;
import by.itAcademy.api.pojo.topalbum.Root;
import by.itAcademy.api.pojo.topalbum.Topalbums;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.URIBuild;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GetMethodsArtist {

    @Step("Get top albums artist")
    public static List<String> getTopAlbumsArtist(String name, String limitAlbum) throws IOException, URISyntaxException {


        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair(Constant.METHOD_PARAMETER, "artist.getTopAlbums"));
        authParams.add(new BasicNameValuePair("artist", name));
        authParams.add(new BasicNameValuePair("limit", limitAlbum));
        authParams.add(new BasicNameValuePair(Constant.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(Constant.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(httpGet);

        String responseText = EntityUtils.toString(response.getEntity());

        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(responseText, Root.class);
        Topalbums str = root.getTopalbums();
        List<String> actualAlbumName = str.getNameAlbum();

        return actualAlbumName;
    }
}
