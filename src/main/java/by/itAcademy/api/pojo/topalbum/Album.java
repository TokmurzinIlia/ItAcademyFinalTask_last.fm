package by.itAcademy.api.pojo.topalbum;

import java.util.ArrayList;

public class Album{
    public ArrayList<Image> image;
    public String mbid;
    public Artist artist;
    public int playcount;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                '}';
    }

    public String name;
    public String url;
}
