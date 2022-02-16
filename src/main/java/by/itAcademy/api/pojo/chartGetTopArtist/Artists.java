package by.itAcademy.api.pojo.chartGetTopArtist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Artists{
    public ArrayList<Artist> artist;
    @JsonProperty("@attr")
    public Attr attr;

    public List<String> getNameArtist() {
        return artist.stream().map(artist -> artist.getName()).collect(Collectors.toList());
    }
}
