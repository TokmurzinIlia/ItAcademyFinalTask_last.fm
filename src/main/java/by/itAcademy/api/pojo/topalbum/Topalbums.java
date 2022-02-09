package by.itAcademy.api.pojo.topalbum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Topalbums{
    @JsonProperty("@attr")
    public Attr attr;

    @Override
    public String toString() {
        return "Topalbums{" +
                "album=" + album +
                '}';
    }

    public ArrayList<Album> album;
    public List<String> getNameAlbum(){
        return album.stream().map(album -> album.getName()).collect(Collectors.toList());
    }
}
