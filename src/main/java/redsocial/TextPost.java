package redsocial;

import java.util.Date;

public class TextPost extends Post {
    private String content;

    public TextPost(String content) {
        super(new Date());
        this.content = content;
    }

    @Override
    public void addComment(Comment comment) {
        // Agregar el comentario a la lista de comentarios
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "TextPost: " + content + " (" + date + ")";
    }
}