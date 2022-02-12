package steps;


import by.itAcademy.api.methods.GetMethodsArtist;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepGetTopAlbum {
private List<String> actualTopAlbum;
    @Given("User is sends a get request to get the numbers top albums artists on following parameters.")
    public List<String> userPreparesGetRequestForBasedOnFollowingParameters(DataTable dataTable) throws IOException, URISyntaxException {
        Map<String, String> parameters = dataTable.asMap(String.class, String.class);
        actualTopAlbum = GetMethodsArtist.getTopAlbumsArtist(parameters.get("artists"), parameters.get("numbers"));
        return actualTopAlbum;
    }


    @Then("^The list of top albums obtained from the query is equivalent to the desired one$")
    public void theListOfTopAlbumsObtainedFromTheQueryIsEquivalentToTheDesiredOne(List<String> expectedList) {

        assertEquals(expectedList, actualTopAlbum);

    }
}
