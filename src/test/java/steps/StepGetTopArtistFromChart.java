package steps;

import by.itAcademy.api.methods.Auth;
import by.itAcademy.api.methods.ChartGetTopArtist;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepGetTopArtistFromChart {
    private HttpResponse response;
    private List<String> actualNameTopArtist;
    @When("^The user sends a request to get the best performers by the following parameters of the number of performers in the list.$")
    public void theUserSendsARequestToGetTheBestPerformersForTheFollowingParameters(String limitArtist)
            throws IOException, URISyntaxException {
        response = ChartGetTopArtist.getChartGetTopArtist(limitArtist);
    }
    @And("^The user receives a response status code of (\\d+) upon request$")
    public void responseCode(int expectedStatusCode){
        int statusCode = Integer.parseInt(Auth.responseCode(response));
        assertEquals(expectedStatusCode, statusCode);
    }
    @Then("^The list of top chart artists obtained from the query is equivalent to the desired one$")
    public void theListOfTopChartArtistsObtainedFromTheQueryIsEquivalentToTheDesiredOne(List<String> expectedList) throws IOException {
        List<String> actualList = ChartGetTopArtist.extractNameTopArtists(response);
        assertEquals(expectedList,actualList);
    }
}
