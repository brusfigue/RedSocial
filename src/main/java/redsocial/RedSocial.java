package redsocial;

import java.util.*;

public class RedSocial {
    private List<User> users;
    private User activeUser;

    public RedSocial() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void runRedSocial(){
        User user1 = new User("Brus");
        addUser(user1);
        user1.addPost(new TextPost("¡Hola amigos!"));
        User user2 = new User("Cesar");
        addUser(user2);
        user2.addPost(new ImagePost("Imagen de paisajes", 1920, 1000));
        User user3 = new User("Monica");
        addUser(user3);
        user3.addPost(new VideoPost("Tutorial Java", 1080, 300));
    }

    public void logOut() {
        if (activeUser != null) {
            System.out.println("Usuario: " + activeUser.getName() + ", ha cerrado sesión correctamente");
            activeUser=null;
        }else {
            System.out.println("No se ha encontrado el usuario");
        }
    }

    public void logIn(Scanner scanner) {
        System.out.print("Introduce tu nombre de usuario para iniciar sesión: ");
        String userName = scanner.nextLine();

        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                System.out.println("Bienvenido, " + user.getName() + "!");
                activeUser = user;
            }
        }
        if (activeUser == null) {
            System.out.println("El usuario \"" + userName + "\" no está registrado. Por favor, regístrate o intenta con otro nombre.");
        }
    }


    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios en la red social.");
        } else {
            System.out.println("Lista de usuarios: ");
            for (User user : users) {
                System.out.println("- " + user.getName());
            }
        }
    }

    public void registerUser (String registrationName){
        if (searchUser(registrationName)==null){
            User newUser = new User (registrationName);
            users.add(newUser);
            activeUser=newUser;
        } else {
            System.out.println("Este usuario ya existe");
        }
    }

    public void addUser(User user) {
        if (!existUser(user.getName())) {
            users.add(user);
            System.out.println("Usuario \"" + user.getName() + "\" añadido.");
        } else {
            System.out.println("El usuario \"" + user.getName() + "\" ya existe. No se puede añadir.");
        }
    }

    public boolean existUser (String name) {
        for (User user : users) {
            if (user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }



    public void removeUser (User user) {
        users.remove(user);
    }

    public User searchUser (String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void listPosts (User user) {
        for (Post post : user.getPosts()) {
            System.out.println(post);
        }
    }

    public void listComments (User user) {
        for (Post post : user.getPosts()) {
            for (Comment comment : post.getComments()) {
                System.out.println(comment);
            }
        }
    }
}