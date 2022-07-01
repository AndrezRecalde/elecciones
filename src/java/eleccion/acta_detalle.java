/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

import java.sql.Timestamp;

/**
 *
 * @author root
 */
public class acta_detalle {
    private int idacta_detalle;
    private int fr_id_acta;
    private int fr_id_candidato;
    private int fr_id_organizacion;
    private String candidato_nombre;
    private String organizacion_nombre;
    private String lista_nombre;
    private String num_votos_letras;
    private String imagen;
    private int num_votos;
    private Timestamp act_det_fi;
    private Timestamp act_det_um;
    private boolean poco_legible;

    public int getFr_id_organizacion() {
        return fr_id_organizacion;
    }

    public void setFr_id_organizacion(int fr_id_organizacion) {
        this.fr_id_organizacion = fr_id_organizacion;
    }

    
    public acta_detalle() {
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public acta_detalle(int idacta_detalle, int fr_id_acta, int fr_id_candidato, String candidato_nombre, String organizacion_nombre, String lista_nombre, String num_votos_letras, int num_votos, Timestamp act_det_fi, Timestamp act_det_um, boolean poco_legible) {
        this.idacta_detalle = idacta_detalle;
        this.fr_id_acta = fr_id_acta;
        this.fr_id_candidato = fr_id_candidato;
        this.candidato_nombre = candidato_nombre;
        this.organizacion_nombre = organizacion_nombre;
        this.lista_nombre = lista_nombre;
        this.num_votos_letras = num_votos_letras;
        this.num_votos = num_votos;
        this.act_det_fi = act_det_fi;
        this.act_det_um = act_det_um;
        this.poco_legible = poco_legible;
    }

    public String getLista_nombre() {
        return lista_nombre;
    }

    public String getOrganizacion_nombre() {
        return organizacion_nombre;
    }

    public void setLista_nombre(String lista_nombre) {
        this.lista_nombre = lista_nombre;
    }

    public void setOrganizacion_nombre(String organizacion_nombre) {
        this.organizacion_nombre = organizacion_nombre;
    }

    public Timestamp getAct_det_fi() {
        return act_det_fi;
    }

    public Timestamp getAct_det_um() {
        return act_det_um;
    }

    public String getCandidato_nombre() {
        return candidato_nombre;
    }

    public int getFr_id_acta() {
        return fr_id_acta;
    }

    public int getFr_id_candidato() {
        return fr_id_candidato;
    }

    public int getIdacta_detalle() {
        return idacta_detalle;
    }

    public int getNum_votos() {
        return num_votos;
    }

    public String getNum_votos_letras() {
        return num_votos_letras;
    }

    public boolean isPoco_legible() {
        return poco_legible;
    }

    public void setAct_det_fi(Timestamp act_det_fi) {
        this.act_det_fi = act_det_fi;
    }

    public void setAct_det_um(Timestamp act_det_um) {
        this.act_det_um = act_det_um;
    }

    public void setCandidato_nombre(String candidato_nombre) {
        this.candidato_nombre = candidato_nombre;
    }

    public void setFr_id_acta(int fr_id_acta) {
        this.fr_id_acta = fr_id_acta;
    }

    public void setFr_id_candidato(int fr_id_candidato) {
        this.fr_id_candidato = fr_id_candidato;
    }

    public void setIdacta_detalle(int idacta_detalle) {
        this.idacta_detalle = idacta_detalle;
    }

    public void setNum_votos(int num_votos) {
        this.num_votos = num_votos;
    }

    public void setNum_votos_letras(String num_votos_letras) {
        this.num_votos_letras = num_votos_letras;
    }

    public void setPoco_legible(boolean poco_legible) {
        this.poco_legible = poco_legible;
    }
    
}
