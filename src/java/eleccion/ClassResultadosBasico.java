/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class ClassResultadosBasico {
    private String nombre_dignidad;
    private String color;
    private String listas;
    private String siglas;
    private int idorganizacion;
    private String nombre_organizacion;
    private String nombre;
    private int total_votos;
    private float porcentaje;
    private int total_votos_validos;
    private int total_votos_no_voto;
    private int total_votos_nulos;
    private int total_votos_blancos;

    public int getIdorganizacion() {
        return idorganizacion;
    }

    public void setIdorganizacion(int idorganizacion) {
        this.idorganizacion = idorganizacion;
    }

    
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    
    public String getNombre_organizacion() {
        return nombre_organizacion;
    }

    public void setNombre_organizacion(String nombre_organizacion) {
        this.nombre_organizacion = nombre_organizacion;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getListas() {
        return listas;
    }

    public void setListas(String listas) {
        this.listas = listas;
    }

    public ClassResultadosBasico() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_dignidad() {
        return nombre_dignidad;
    }

    public int getTotal_votos() {
        return total_votos;
    }

    public int getTotal_votos_blancos() {
        return total_votos_blancos;
    }

    public int getTotal_votos_no_voto() {
        return total_votos_no_voto;
    }

    public int getTotal_votos_nulos() {
        return total_votos_nulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre_dignidad(String nombre_dignidad) {
        this.nombre_dignidad = nombre_dignidad;
    }

    public void setTotal_votos(int total_votos) {
        this.total_votos = total_votos;
    }

    public void setTotal_votos_blancos(int total_votos_blancos) {
        this.total_votos_blancos = total_votos_blancos;
    }

    public void setTotal_votos_no_voto(int total_votos_no_voto) {
        this.total_votos_no_voto = total_votos_no_voto;
    }

    public void setTotal_votos_nulos(int total_votos_nulos) {
        this.total_votos_nulos = total_votos_nulos;
    }

    public void setTotal_votos_validos(int total_votos_validos) {
        this.total_votos_validos = total_votos_validos;
    }

    public int getTotal_votos_validos() {
        return total_votos_validos;
    }
     
}
