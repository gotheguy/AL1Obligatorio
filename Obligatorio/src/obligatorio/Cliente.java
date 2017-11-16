package obligatorio;

class Cliente {

private String nombre;
private int id;
private String nickname;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public Cliente (String nombre, int id, String nickname)
    {
        this.setNombre(nombre);
        this.setId(id);
        this.setNickname(nickname);
    
    }
    
}
