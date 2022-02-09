package by.itAcademy.api.pojo.topalbum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @Override
    public String toString() {
        return "Root{" +
                "topalbums=" + topalbums +
                '}';
    }

    public Topalbums getTopalbums() {
        return topalbums;
    }

    public Topalbums topalbums;
    @JsonProperty("Topalbums")
    public Topalbums Topalbums;
}
