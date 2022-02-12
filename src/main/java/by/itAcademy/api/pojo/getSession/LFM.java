package by.itAcademy.api.pojo.getSession;

import by.itAcademy.api.pojo.topalbum.Topalbums;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LFM {
    public Session session;
    public String status;
    public String text;
    @JsonProperty("LFM")
    public LFM lfm;
    public Session getSession() {
        return session;
    }
}
