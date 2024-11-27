package redsocial;

import java.util.*;

public class App {
    public static void logMenu(RedSocial redSocial) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    if (redSocial.getActiveUser() == null) {
                        redSocial.logIn(scanner);
                    }
                    if (redSocial.getActiveUser() != null) {
                        mainMenu(redSocial, scanner);
                    }
                    break;
                }
                case 2: {
                    System.out.print("Ingrese su nombre de usuario: ");
                    String registerName = scanner.nextLine();
                    redSocial.registerUser(registerName);
                    mainMenu(redSocial, scanner);
                    break;
                }
                case 3: {
                    System.out.println("Saliendo...");
                    break;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
    public static void mainMenu (RedSocial redSocial, Scanner scanner){
        int opcion;
        do{
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Seguir usuario");
            System.out.println("4. Dejar de seguir usuario");
            System.out.println("5. Añadir post");
            System.out.println("6. Añadir comentario");
            System.out.println("7. Listar posts de un usuario");
            System.out.println("8. Listar comentarios de un usuario");
            System.out.println("9. Contar comentarios de un post");
            System.out.println("10. Mostrar usuarios");
            System.out.println("11. Mostrar usuarios seguidos");
            System.out.println("12. Cerrar sesión");
            System.out.println("13. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                //Registrar usuario
                case 1: {
                    System.out.println("Nombre de usuario: ");
                    String userNameAdd = scanner.nextLine();
                    User user = new User(userNameAdd);
                    redSocial.addUser(user);
                    System.out.println("Usuario creado.");
                    break;
                }
                //Eliminar usuario
                case 2 : {
                    System.out.println("Seleccione usuario para eliminar: ");
                    redSocial.showUsers();
                    String userNameRemove = scanner.nextLine();
                    User user = redSocial.searchUser(userNameRemove);
                    if (user != null) {
                        redSocial.removeUser(user);
                        System.out.println("Usuario eliminado.");
                    }else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Seguir usuario
                case 3:{
                    System.out.println("¿A quien quiere seguir?");
                    String nameFollow = scanner.nextLine();
                    User userFollow = redSocial.searchUser(nameFollow);

                    if (userFollow != null) {
                        // Verificar si el usuario no está intentando seguirse a sí mismo
                        if (!userFollow.equals(redSocial.getActiveUser())) {
                            redSocial.getActiveUser().followUser(userFollow);
                        } else {
                            System.out.println("No puedes seguirte a ti mismo.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                }
                //Dejar de seguir a usuario
                case 4: {
                    System.out.println("¿Aquien quiere dejar de seguir?");
                    String nameUnfollow = scanner.nextLine();
                    User userUnfollow = redSocial.searchUser(nameUnfollow);

                    if (userUnfollow != null) {
                        redSocial.getActiveUser().unfollowUser(userUnfollow);
                    }else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                }
                //Publicar post
                case 5: {
                    System.out.println("Seleccione tipo de post");
                    System.out.println("1. Texto");
                    System.out.println("2. Imagen");
                    System.out.println("3. Vídeo");
                    int typePost = scanner.nextInt();
                    scanner.nextLine();

                    switch (typePost) {
                        case 1:
                            System.out.println("Contenido del texto: ");
                            String content = scanner.nextLine();
                            Post textPost = new TextPost(content);
                            redSocial.getActiveUser().addPost(textPost);
                            System.out.println("Post de texto subido.");
                            break;

                        case 2:
                            System.out.println("Titulo de la imagen: ");
                            String imageTitle = scanner.nextLine();
                            System.out.println("Ancho de imagen: ");
                            int width = scanner.nextInt();
                            System.out.println("Alto de imagen: ");
                            int height = scanner.nextInt();
                            Post imagePost = new ImagePost(imageTitle, width, height);
                            redSocial.getActiveUser().addPost(imagePost);
                            System.out.println("post de imagen subido.");
                            break;

                        case 3:
                            System.out.println("Título del vídeo: ");
                            String videoTitle = scanner.nextLine();
                            System.out.println("Calidad del vídeo: ");
                            int quality = scanner.nextInt();
                            System.out.println("Duración en segundos: ");
                            int duration = scanner.nextInt();
                            Post videoPost = new VideoPost(videoTitle, quality, duration);
                            redSocial.getActiveUser().addPost(videoPost);
                            System.out.println("Post de vídeo subido.");
                            break;

                        default:
                            System.out.println("Tipo de post no válido.");
                    }
                    break;
                }
                //Comentar post
                case 6: {
                    if (redSocial.getActiveUser() != null) {
                        System.out.print("Nombre del usuario del post a comentar: ");
                        String userNameComment = scanner.nextLine();
                        User user = redSocial.searchUser(userNameComment);

                        if (user != null) {
                            System.out.println("Seleccione el número del post:");
                            for (int i = 0; i < user.getPosts().size(); i++) {
                                System.out.println(i + ": " + user.getPosts().get(i));
                            }

                            int postIndex = scanner.nextInt();
                            scanner.nextLine();

                            if (postIndex >= 0 && postIndex < user.getPosts().size()) {
                                Post post = user.getPosts().get(postIndex);
                                System.out.print("Escribe el comentario: ");
                                String textComment = scanner.nextLine();
                                Comment comment = new Comment(textComment, redSocial.getActiveUser());
                                post.addComment(comment); ////////////////////////////////////////////////
                                System.out.println("Comentario añadido.");
                            } else {
                                System.out.println("Número de post no válido.");
                            }
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no autenticado.");
                    }
                    break;
                }
                // Listar posts
                case 7: {
                    System.out.print("¿De qué usuario quieres ver posts? ");
                    String userNameListPost = scanner.nextLine();
                    User user = redSocial.searchUser(userNameListPost);

                    if (user != null) {
                        redSocial.listPosts(user);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Listar comentarios
                case 8:{
                    System.out.print("¿De qué usuario quieres ver comentarios? ");
                    String userNameListCom = scanner.nextLine();
                    User user = redSocial.searchUser(userNameListCom);
                    if (user != null) {
                        redSocial.listComments(user);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Contar comentarios
                case 9: {
                    System.out.print("¿De qué usuario quieres consultar post? ");
                    String userNameCont = scanner.nextLine();
                    User user = redSocial.searchUser(userNameCont);
                    if (user != null) {
                        System.out.println("Selecciona el número del post:");
                        for (int i = 0; i < user.getPosts().size(); i++) {
                            System.out.println((i + 1) + ". " + user.getPosts().get(i));
                        }
                        int postIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (postIndex > 0 && postIndex <= user.getPosts().size()) {
                            Post post = user.getPosts().get(postIndex - 1);
                            System.out.println("El número de comentarios en el post es: " + post.countComments());
                        } else {
                            System.out.println("El número de post no es válido.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                }
                //Mostrar usuarios
                case 10:{
                    redSocial.showUsers();
                    break;
                }
                //Mostrar usuarios seguidos
                case 11:{
                    redSocial.getActiveUser().showUsersFollow();
                    break;
                }
                //Salir
                case 12: {
                    redSocial.logOut();
                    opcion=13;
                }

                case 13: {
                    System.out.println("Saliendo...");
                    return;
                }
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion !=13);
        scanner.close();
    }
}