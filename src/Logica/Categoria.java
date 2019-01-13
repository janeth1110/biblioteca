package Logica;

public class Categoria {

    private int id;
    private String categoria;

    public Categoria() {
    }

    public Categoria(int id, String cate) {
        this.id = id;
        this.categoria = cate;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
}
