package Logica;

public class Idioma {

    private int id;
    private String idioma;

    public Idioma() {
    }

    public Idioma(int id, String idio) {
        this.id = id;
        this.idioma = idio;
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
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
