package redsocial;

import java.util.*;

public class User implements IUserActions{
    private String name;
    private List<User> following;
    private List<Post> posts;

    private static List<User> allUsers = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
        allUsers.add(this);
    }

    public String getName() {
        return name;
    }

    public void showUsersFollow() {
        if (following.isEmpty()) {
            System.out.println("No sigue a ningún usuario.");
        } else {
            System.out.println("Sigue a los siguientes usuarios:");
            for (User user : following) {
                System.out.println("- " + user.getName());
            }
        }
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }

    @Override
    public void followUser(User user) {
        if (this.equals(user)) {
            System.out.println("No puedes seguirte a ti mismo.");
        } else if (following.contains(user)) {
            System.out.println("Ya estás siguiendo a " + user.getName());
        } else {
            following.add(user);
            System.out.println("Ahora sigues a " + user.getName());
        }
    }

    @Override
    public void unfollowUser(User user) {
        if (following.contains(user)) {
            following.remove(user);
            System.out.println("Has dejado de seguir a " + user.getName());
        } else {
            System.out.println("No estás siguiendo a " + user.getName());
        }
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public void removePost(Post post) {
        posts.remove(post);
    }

    @Override
    public List<Post> listUserPosts() {
        return posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}