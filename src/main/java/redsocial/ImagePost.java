package redsocial;

import java.util.Date;

public class ImagePost extends Post {
    private String title;
    private int width;
    private int height;

    public ImagePost(String title, int width, int height) {
        super(new Date());
        this.title = title;
        this.width = width;
        this.height = height;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "ImagePost: " + title + " (" + width + "x" + height + ") - " + date;
    }
}