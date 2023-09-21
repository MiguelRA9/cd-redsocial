import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Usuario {
    private String nombre;
    private List<Usuario> siguiendo;
    private List<Post> posts;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.siguiendo = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void seguirUsuario(Usuario usuario) {
        if (!siguiendo.contains(usuario)) {
            siguiendo.add(usuario);
        }
    }

    public void dejarDeSeguirUsuario(Usuario usuario) {
        siguiendo.remove(usuario);
    }

    public void publicarPost(Post post) {
        posts.add(post);
    }

    public void eliminarPost(Post post) {
        posts.remove(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Usuario> getSiguiendo() {
        return siguiendo;
    }

    public List<Comentario> listarComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        for (Post post : posts) {
            comentarios.addAll(post.getComentarios());
        }
        return comentarios;
    }

    public List<Post> mostrarMuro() {
        List<Post> muro = new ArrayList<>();
        for (Usuario amigo : siguiendo) {
            muro.addAll(amigo.getPosts());
        }
        muro.sort((p1, p2) -> p2.getFecha().compareTo(p1.getFecha())); // Ordenar por fecha descendente
        return muro.subList(0, Math.min(muro.size(), 10)); // Mostrar los primeros 10 posts
    }
}

class Post {
    private Date fecha;
    private List<Comentario> comentarios;

    public Post(Date fecha) {
        this.fecha = fecha;
        this.comentarios = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}

class Comentario {
    private String texto;
    private Date fecha;
    private Usuario propietario;

    public Comentario(String texto, Usuario propietario) {
        this.texto = texto;
        this.fecha = new Date();
        this.propietario = propietario;
    }

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public Usuario getPropietario() {
        return propietario;
    }
}

/*

public class RedSocial {


    public static void main(String[] args) {

        // Aquí puedes implementar un menú para interactuar con la red social.
        // Crea usuarios, publica posts, agrega comentarios y realiza otras operaciones.

    }

}

*/