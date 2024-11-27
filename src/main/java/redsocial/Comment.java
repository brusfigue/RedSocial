package redsocial;

import java.util.*;

public class Comment {
    private String text;
    private Date date;
    private User owner;

    public Comment(String text, User owner) {
        this.text = text;
        this.date = date;
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return owner.getName() + " comentó: " + text + " en " + date;
    }

}