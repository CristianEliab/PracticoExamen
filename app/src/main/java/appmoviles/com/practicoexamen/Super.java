package appmoviles.com.practicoexamen;

public class Super {

    private String id;
    private String nombre;
    private String edad;
    private String telefono;
    private String email;
    private String userID;
    private String tipo_Super;

    //Serializar
    public Super() {
    }

    public Super(String id, String nombre, String edad, String telefono, String email, String userID) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.userID = userID;
    }


    public Super(String nombre, String tipo, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo_Super = tipo;
    }


    public String getTipo_Super() {
        return tipo_Super;
    }

    public void setTipo_Super(String tipo_Super) {
        this.tipo_Super = tipo_Super;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Super) {
            return this.id.equals(((Super) obj).id);
        }
        return false;
    }
}

