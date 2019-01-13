package Logica;

public class Usuario {

    private int id;
    private String pass;
    private String names;
    private String lastNames;
    private String rol;

    /**
     * Constructores de la clase
     */
    public Usuario() {
    }

    public Usuario(int id, String password, String name, String lastName, String rol) {
        this.id = id;
        this.pass = password;
        this.names = name;
        this.lastNames = lastName;
        this.rol = rol;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the names
     */
    public String getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * @return the lastNames
     */
    public String getLastNames() {
        return lastNames;
    }

    /**
     * @param lastNames the lastNames to set
     */
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
