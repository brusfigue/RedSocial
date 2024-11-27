package redsocial;

import java.util.*;

public class VideoPost extends Post {
    private String title;
    private int quality;
    private int duration;

    public VideoPost(String title, int quality, int duration) {
        super(new Date());
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    @Override
    public void addComment(Comment comment) {
        // Agregar el comentario a la lista de comentarios
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "VideoPost: " + title + " (" + quality + ", " + duration + " segundos) - " + date;
    }
}