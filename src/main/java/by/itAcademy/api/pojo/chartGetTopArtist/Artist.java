package by.itAcademy.api.pojo.chartGetTopArtist;

import java.util.ArrayList;

public class Artist{
    public String getName() {
        return name;
    }

    public String name;
    public String playcount;
    public String listeners;
    public String mbid;
    public String url;
    public String streamable;
    public ArrayList<Image> image;
}
