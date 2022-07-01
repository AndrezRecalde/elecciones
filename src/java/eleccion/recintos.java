/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class recintos {
    private int cod_recinto;
    private int cod_parroquia;
    private String parroquia_nombre;
    private String nombre_recinto;
    private String direccion_recinto;
    private int cod_zona;
    private int num_jun_mas;
    private int num_jun_fem;
    private int num_juntas;
    private int jun_ini_f;
    private int jun_fin_f;
    private int jun_ini_m;
    private int jun_fin_m;

    public recintos() {
    }

    public recintos(int cod_recinto, int cod_parroquia, String parroquia_nombre, String nombre_recinto, String direccion_recinto, int cod_zona, int num_jun_mas, int num_jun_fem, int num_juntas, int jun_ini_f, int jun_fin_f, int jun_ini_m, int jun_fin_m) {
        this.cod_recinto = cod_recinto;
        this.cod_parroquia = cod_parroquia;
        this.parroquia_nombre = parroquia_nombre;
        this.nombre_recinto = nombre_recinto;
        this.direccion_recinto = direccion_recinto;
        this.cod_zona = cod_zona;
        this.num_jun_mas = num_jun_mas;
        this.num_jun_fem = num_jun_fem;
        this.num_juntas = num_juntas;
        this.jun_ini_f = jun_ini_f;
        this.jun_fin_f = jun_fin_f;
        this.jun_ini_m = jun_ini_m;
        this.jun_fin_m = jun_fin_m;
    }

    public int getCod_parroquia() {
        return cod_parroquia;
    }

    public int getCod_recinto() {
        return cod_recinto;
    }

    public int getCod_zona() {
        return cod_zona;
    }

    public String getDireccion_recinto() {
        return direccion_recinto;
    }

    public int getJun_fin_f() {
        return jun_fin_f;
    }

    public int getJun_fin_m() {
        return jun_fin_m;
    }

    public int getJun_ini_f() {
        return jun_ini_f;
    }

    public int getJun_ini_m() {
        return jun_ini_m;
    }

    public String getNombre_recinto() {
        return nombre_recinto;
    }

    public int getNum_jun_fem() {
        return num_jun_fem;
    }

    public int getNum_jun_mas() {
        return num_jun_mas;
    }

    public int getNum_juntas() {
        return num_juntas;
    }

    public String getParroquia_nombre() {
        return parroquia_nombre;
    }

    public void setCod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setCod_recinto(int cod_recinto) {
        this.cod_recinto = cod_recinto;
    }

    public void setCod_zona(int cod_zona) {
        this.cod_zona = cod_zona;
    }

    public void setDireccion_recinto(String direccion_recinto) {
        this.direccion_recinto = direccion_recinto;
    }

    public void setJun_fin_f(int jun_fin_f) {
        this.jun_fin_f = jun_fin_f;
    }

    public void setJun_fin_m(int jun_fin_m) {
        this.jun_fin_m = jun_fin_m;
    }

    public void setJun_ini_f(int jun_ini_f) {
        this.jun_ini_f = jun_ini_f;
    }

    public void setJun_ini_m(int jun_ini_m) {
        this.jun_ini_m = jun_ini_m;
    }

    public void setNombre_recinto(String nombre_recinto) {
        this.nombre_recinto = nombre_recinto;
    }

    public void setNum_jun_fem(int num_jun_fem) {
        this.num_jun_fem = num_jun_fem;
    }

    public void setNum_jun_mas(int num_jun_mas) {
        this.num_jun_mas = num_jun_mas;
    }

    public void setNum_juntas(int num_juntas) {
        this.num_juntas = num_juntas;
    }

    public void setParroquia_nombre(String parroquia_nombre) {
        this.parroquia_nombre = parroquia_nombre;
    }

}
