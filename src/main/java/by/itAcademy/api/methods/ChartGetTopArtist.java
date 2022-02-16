package by.itAcademy.api.methods;

import by.itAcademy.api.endpoints.Constant;
import by.itAcademy.api.pojo.chartGetTopArtist.Artists;
import by.itAcademy.api.pojo.chartGetTopArtist.Root;
import by.itAcademy.utils.Property;
import by.itAcademy.utils.URIBuild;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class ChartGetTopArtist {

    public static HttpResponse getChartGetTopArtist(String limitArtist) throws IOException, URISyntaxException {


        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair(Constant.METHOD_PARAMETER, "chart.getTopArtists"));
        authParams.add(new BasicNameValuePair("limit", limitArtist));
        authParams.add(new BasicNameValuePair(Constant.API_KEY_PARAMETER, Property.getPropertyValue("api_key")));
        authParams.add(new BasicNameValuePair(Constant.FORMAT_PARAMETER, "json"));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URIBuild.getURIInquiryGet(authParams));

        HttpResponse response = client.execute(httpGet);

        return response;
    }

    public static List<String> extractNameTopArtists(HttpResponse response) throws IOException {

        String responseText = EntityUtils.toString(response.getEntity());

        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(responseText, Root.class);
        Artists str = root.getArtists();
        List<String> actualNameTopArtist = str.getNameArtist();
        return actualNameTopArtist;
    }
}
