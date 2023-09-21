package com.campusdual.poo.ex8_red_social;

import com.campusdual.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// CLASE MAIN

public class Main {

    private List<User> usersList = new ArrayList<>();
    private List<Post> postsList = new ArrayList<>();
    private User activeUser;

    public List<User> getUsersList() {

        return usersList;

    }

    public List<Post> getPostsList() {

        return postsList;

    }

    public static void main(String[] args) {

        Main m = new Main();

        m.populateSocialNetwork();

        m.welcome();

    }

    private void populateSocialNetwork() {

        LocalDateTime date = java.time.LocalDateTime.now();

        User u1 = new User("Diego");
        User u2 = new User("Misa");
        User u3 = new User("Italo");

        getUsersList().add(u1);
        getUsersList().add(u2);
        getUsersList().add(u3);

        PostText pt1 = new PostText(1, u1, "Post de texto", date, "tareas");
        PostImage pt2 = new PostImage(2, u2, "Post de imagen", date, "10x10");
        PostVideo pt3 = new PostVideo(3, u3, "Post de video", date, "high", 75);

        getPostsList().add(pt1);
        getPostsList().add(pt2);
        getPostsList().add(pt3);

        u1.getUserPostList().add(pt1);
        u2.getUserPostList().add(pt2);
        u3.getUserPostList().add(pt3);

        Comment cm1 = new Comment(u1, pt2, date, "Tremenda imagen amiga :)");
        Comment cm3 = new Comment(u2, pt3, date, "Me he emocionado con el vídeo :(");
        Comment cm2 = new Comment(u3, pt1, date, "Un texto precioso!");

        pt1.getPostCommentList().add(cm2);
        pt2.getPostCommentList().add(cm1);
        pt3.getPostCommentList().add(cm3);

        u1.getFollowingList().add(u2);
        //u1.getFollowingList().add(u3);
        u2.getFollowingList().add(u3);
        u3.getFollowingList().add(u2);
        //u3.getFollowingList().add(u1);

    }

    public void welcome() {

        System.out.println(" ");
        System.out.println("====================== BIENVENIDO ===================");
        System.out.println(" ");
        System.out.println("1 - Login");
        System.out.println("2 - Registro");
        System.out.println("3 - Salir");
        System.out.println(" ");
        System.out.println("=====================================================");
        System.out.println(" ");

        int opt = (Utils.integer("¿Qué quieres hacer? "));

        switch (opt) {

            case 1:

                login();
                break;

            case 2:

                register();
                break;

            case 3:

                break;

        }

    }

    public void login() {

        System.out.println(" ");
        System.out.println("======================= LOGIN =======================");
        System.out.println(" ");

        String inputName = (Utils.string("Introduce el nombre de usuario: "));

        boolean found = false;

        for (User user : getUsersList()) {

            if (user.getName().equals(inputName)) {

                found = true;
                activeUser = user;
                break;

            }

        }

        if (found) {

            userOptions(activeUser);

        } else {

            System.out.println("El usuario no existe");

            welcome();

        }

    }

    public void register() {

        System.out.println(" ");
        System.out.println("====================== REGISTER =====================");
        System.out.println(" ");
        String name = (Utils.string("Introduzca un nombre de Usario: "));
        System.out.println(" ");

        User u = new User(name);

        getUsersList().add(u);

        System.out.println("Usuario " + name + " creado correctamente");

        login();

    }

    public void userOptions(User user) {

        System.out.println(" ");
        System.out.println("===================== USER OPTIONS ====================");
        System.out.println(" ");
        System.out.println("Perfil de " + user.getName());
        System.out.println(" ");
        System.out.println("1 - Publicaciones recientes");
        System.out.println("2 - Nueva publicación");
        System.out.println("3 - Mis posts");
        System.out.println("4 - Following");
        System.out.println("5 - Cerrar sesión");
        System.out.println(" ");
        System.out.println("=======================================================");
        System.out.println(" ");

        int opt1 = (Utils.integer("Escoge una opción: "));

        switch (opt1) {

            case 1:

                listPosts(activeUser);
                break;

            case 2:

                addPost(activeUser);
                break;

            case 3:

                listMyPosts(activeUser);
                break;

            case 4:

                following(activeUser);
                break;

            case 5:

                welcome();

        }

    }

    public void addPost(User user) {

        System.out.println(" ");
        System.out.println("======================= CREAR POST =======================");
        System.out.println(" ");
        System.out.println("Introduce el tipo de publicación: ");
        System.out.println(" ");

        int opt2 = (Utils.integer("1 (texto) / 2 (imagen) / 3 (vídeo): "));
        System.out.println(" ");

        switch (opt2) {

            case 1:

                addPostText(user);
                break;

            case 2:

                addPostImage(user);
                break;

            case 3:

                addPostVideo(user);
                break;

        }

    }

    public void addPostText(User user) {

        LocalDateTime date = java.time.LocalDateTime.now();

        int id = (Utils.integer("Introduce un id: "));
        String title = (Utils.string("Introduce el título: "));
        String content = (Utils.string("Introduce el tipo de contenido: "));

        System.out.println(" ");

        PostText ptt = new PostText(id, user, title, date, content);

        getPostsList().add(ptt);
        user.getUserPostList().add(ptt);

        System.out.println("Post " + title + " publicado correctamente");

        System.out.println(" ");
        int opt3 = (Utils.integer("Pulsa 1 para volver atrás: "));
        System.out.println(" ");

        switch (opt3) {

            case 1:

                userOptions(activeUser);
                break;

        }

        System.out.println(" ");

    }

    public void addPostImage(User user) {

        LocalDateTime date = java.time.LocalDateTime.now();

        int id = (Utils.integer("Introduce un id: "));
        String title = (Utils.string("Introduce el título: "));
        String size = (Utils.string("Introduce el tamaño: "));

        PostImage pti = new PostImage(id, user, title, date, size);

        getPostsList().add(pti);
        user.getUserPostList().add(pti);

        System.out.println(" ");
        System.out.println("Post " + title + " publicado correctamente");
        System.out.println(" ");

        int opt4 = (Utils.integer("Pulsa 1 para volver atrás: "));

        switch (opt4) {

            case 1:

                userOptions(activeUser);
                break;

        }

        System.out.println(" ");

    }

    public void addPostVideo(User user) {

        LocalDateTime date = java.time.LocalDateTime.now();

        int id = (Utils.integer("Introduce un id: "));
        String title = (Utils.string("Introduce el título: "));
        String quality = (Utils.string("Introduce la calidad: "));
        int duration = (Utils.integer("Introduce la duración: "));

        PostVideo ptv = new PostVideo(id, user, title, date, quality, duration);

        getPostsList().add(ptv);
        user.getUserPostList().add(ptv);

        System.out.println(" ");
        System.out.println("Post " + title + " publicado correctamente");
        System.out.println(" ");

        int opt5 = (Utils.integer("Pulsa 1 para volver atrás: "));

        switch (opt5) {

            case 1:

                userOptions(activeUser);
                break;

        }

        System.out.println(" ");

    }

    public void deletePost(Post post, User user) {

        if (getPostsList().contains(post)) {

            getPostsList().remove(post);
            System.out.println(" ");
            System.out.println("Publicación borrada de la lista general de posts!");

        }

        if (user.getUserPostList().contains(post)) {

            user.getUserPostList().remove(post);
            System.out.println(" ");
            System.out.println("Publicación borrada de la lista de posts del usuario " + user.getName());

        }

        userOptions(user);

    }

    public void listPosts(User user) {

        System.out.println(" ");
        System.out.println("=================================== MURO =========================================");
        System.out.println(" ");

        for (Post p : postsList) {

            if (user.getFollowingList().contains(p.getUser())) {

                System.out.println(" ");
                System.out.println("TITULO      : " + p.getTitle());
                System.out.println("USUARIO     : " + p.getUser().getName());
                System.out.println("FECHA       : " + p.getDate());
                System.out.println(" ");

                System.out.println(p.getPostCommentList().size() + " comentario/s : ");

                for (Comment c : p.getPostCommentList()) {

                    System.out.println(" ");
                    System.out.println("            USUARIO : " + c.getUser().getName());
                    System.out.println("            FECHA : " + c.getDate());
                    System.out.println("            COMENTARIO : " + c.getContent());
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println(" ");

                }

                int opt6 = (Utils.integer("Pulsa 1 para añadir un comentario o 2 para ver más publicaciones: "));

                switch (opt6) {

                    case 1:

                        addComment(p, activeUser);
                        break;

                    case 2:

                        continue;

                }

                System.out.println("-----------------------------------------------------------------------------------");

                int opt7 = (Utils.integer("Pulsa 1 para volver atrás: "));

                switch (opt7) {

                    case 1:

                        userOptions(activeUser);
                        break;

                }

                System.out.println(" ");

            }

        }

    }

    public void listMyPosts(User user) {

        System.out.println(" ");
        System.out.println("=========================== MIS PUBLICACIONES =========================================");

        for (Post p : user.getUserPostList()) {

            System.out.println(" ");
            System.out.println("TITULO      : " + p.getTitle());
            System.out.println("USUARIO     : " + p.getUser().getName());
            System.out.println("FECHA       : " + p.getDate());
            System.out.println(" ");

            System.out.println(p.getPostCommentList().size() + " comentario/s : ");

            for (Comment c : p.getPostCommentList()) {

                System.out.println(" ");
                System.out.println("            USUARIO     : " + c.getUser().getName());
                System.out.println("            FECHA       : " + c.getDate());
                System.out.println("            COMENTARIO  : " + c.getContent());

                System.out.println(" ");

                int opt12 = (Utils.integer("Pulsa 1 para eliminar el comentario anterior o 2 para ver más comentarios: "));

                switch (opt12) {

                    case 1:

                        deleteComment(p, c, user);
                        break;

                    case 2:

                        continue;

                }

            }

            System.out.println("----------------------------------------------------------------------------------");
            int opt8 = (Utils.integer("Pulsa 1 para eliminar la publicación o 2 para ver más publicaciones: "));
            System.out.println(" ");

            switch (opt8) {

                case 1:

                    deletePost(p, user);
                    break;

                case 2:

                    continue;

            }

        }

        System.out.println("-----------------------------------------------------------------------------------");

        int opt9 = (Utils.integer("Pulsa 1 para volver atrás: "));

        switch (opt9) {

            case 1:

                userOptions(activeUser);
                break;

        }

        System.out.println(" ");

    }

    public void addComment(Post post, User user) {

        LocalDateTime date = java.time.LocalDateTime.now();

        String content = (Utils.string("Introduce el contenido del comentario: "));

        Comment cm = new Comment(user, post, date, content);

        post.getPostCommentList().add(cm);

        System.out.println(" ");

        System.out.println("Comentario añadido correctamente!");

        System.out.println(" ");

        userOptions(user);

    }

    public void deleteComment(Post post, Comment comment, User user) {

        if (post.getPostCommentList().contains(comment)) {

            post.getPostCommentList().remove(comment);

            System.out.println(" ");

            System.out.println("Comentario borrado correctamente!");

        }

        userOptions(user);

    }

    public void following(User user) {

        user = activeUser;

        System.out.println(" ");
        System.out.println("========================= USUARIOS QUE SIGO =======================================");

        for (User u : user.getFollowingList()) {

            System.out.println(" ");
            System.out.println(u.getName());
            System.out.println(" ");

            int opt10 = (Utils.integer("Pulsa 1 para dejar de seguir a este usuario o 2 para seguir viendo más usuarios: "));

            switch (opt10) {

                case 1:

                    unfollowUser(activeUser, u);
                    break;

                case 2:

                    continue;

            }

        }

        int opt11 = (Utils.integer("Pulsa 1 para volver atrás o 2 para mostrar cuentas sugeridas: "));

        switch (opt11) {

            case 1:

                userOptions(activeUser);
                break;

            case 2:

                followUser(activeUser);

        }

    }

    public void unfollowUser(User userActive, User user) {

        if (activeUser.getFollowingList().contains(user)) {

            activeUser.getFollowingList().remove(user);

            System.out.println(" ");
            System.out.println("Has dejado de seguir a " + user.getName() + ".");

        }

        userOptions(userActive);

    }

    public void followUser(User userActive) {

        System.out.println(" ");
        System.out.println("===================== USUARIOS QUE PUEDEN INTERESAERTE ============================");
        System.out.println("Estos son algunos perfiles que siguen otros usuarios. Échale un vistazo.");
        System.out.println(" ");

        if (userActive.getFollowingList().isEmpty()) {

            System.out.println("No puedes seguir a nuevos usuarios ahora mismo");
            System.out.println(" ");
            userOptions(activeUser);

        } else {

            for (User u1 : userActive.getFollowingList()) {

                if (!userActive.getFollowingList().equals(u1.getFollowingList())) {

                    for (User u2 : u1.getFollowingList()) {

                        if (!userActive.getFollowingList().contains(u2) && (userActive != u2)) {

                            System.out.println("USUARIO : " + u2.getName());

                            int opt13 = (Utils.integer("Pulsa 1 para seguir a este usuario o 2 para seguir viendo más recomendaciones: "));

                            switch (opt13) {

                                case 1:

                                    userActive.getFollowingList().add(u2);
                                    System.out.println(" ");
                                    System.out.println("Has comenzado a seguir al usuario " + u2.getName());

                                    userOptions(userActive);

                                    // break;

                                case 2:

                                    continue;

                            }

                        }

                    }

                }

            }

        }

    }

}