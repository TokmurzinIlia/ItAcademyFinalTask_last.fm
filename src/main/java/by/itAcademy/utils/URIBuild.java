package by.itAcademy.utils;

import by.itAcademy.api.endpoints.EndPoints;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class URIBuild {

    public static URI getURIInquiryGet(List<NameValuePair> authParams) throws URISyntaxException {

        URIBuilder builder = new URIBuilder();
        builder
                .setScheme(EndPoints.SCHEME)
                .setHost(EndPoints.HOST)
                .setPath(EndPoints.PATH)
                .addParameters(authParams);

        return builder.build();
    }

    public static URI getURIInquiryGet() throws URISyntaxException {

        URIBuilder builder = new URIBuilder();
        builder
                .setScheme(EndPoints.SCHEME)
                .setHost(EndPoints.HOST)
                .setPath(EndPoints.PATH);

        return builder.build();
    }
}
