package admin;/**
 *
 * @author Generador V1.0
 */
public class CObjetoCombo {
    private int id;
    private String valor;

    public CObjetoCombo(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public CObjetoCombo() {
    }

    public int getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}