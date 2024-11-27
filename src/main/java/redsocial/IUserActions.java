package redsocial;

import java.util.*;

public interface IUserActions {
    void followUser (User user);

    void unfollowUser (User user);

    void addPost (Post post);

    void removePost (Post post);

    List<Post> listUserPosts();
}