package obligatorio;

class Cliente {

private String nombre;
private String id;
private String nickname;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public Cliente (String nombre, String id, String nickname)
    {
        this.setNombre(nombre);
        this.setId(id);
        this.setNickname(nickname);
    
    }
    
}
