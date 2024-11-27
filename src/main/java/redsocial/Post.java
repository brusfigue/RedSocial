package redsocial;

import java.util.*;

public abstract class Post {
    protected Date date;
    protected List<Comment> comments;

    public Post(Date date) {
        this.date = date;
        this.comments = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Post creado el " + date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public abstract void addComment(Comment comment);

    public int countComments() {
        return comments.size();
    }
}