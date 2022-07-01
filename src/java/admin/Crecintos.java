package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Generador V1.0
 */
public class Crecintos {

    private int cod_recinto;
    private int cod_canton;
    private String nombre_canton;
    private int cod_parroquia;
    private String parroquia_nombre;
    private String nombre_recinto;
    private String direccion_recinto;
    private int cod_zona;
    private int num_jun_mas;
    private int num_jun_fem;
    private int num_juntas;
    private String responsable_ci;
    private String responsable_nombres;
    private String responsable_telefono;
    private int jun_ini_f;
    private int jun_fin_f;
    private int jun_ini_m;
    private int jun_fin_m;

    public void setNombre_canton(String nombre_canton) {
        this.nombre_canton = nombre_canton;
    }

    public String getNombre_canton() {
        return nombre_canton;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public int getCod_canton() {
        return cod_canton;
    }

    public void setcod_recinto(int cod_recinto) {
        this.cod_recinto = cod_recinto;
    }

    public void setcod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setparroquia_nombre(String parroquia_nombre) {
        this.parroquia_nombre = parroquia_nombre;
    }

    public void setnombre_recinto(String nombre_recinto) {
        this.nombre_recinto = nombre_recinto;
    }

    public void setdireccion_recinto(String direccion_recinto) {
        this.direccion_recinto = direccion_recinto;
    }

    public void setcod_zona(int cod_zona) {
        this.cod_zona = cod_zona;
    }

    public void setnum_jun_mas(int num_jun_mas) {
        this.num_jun_mas = num_jun_mas;
    }

    public void setnum_jun_fem(int num_jun_fem) {
        this.num_jun_fem = num_jun_fem;
    }

    public void setnum_juntas(int num_juntas) {
        this.num_juntas = num_juntas;
    }

    public void setresponsable_ci(String responsable_ci) {
        this.responsable_ci = responsable_ci;
    }

    public void setresponsable_nombres(String responsable_nombres) {
        this.responsable_nombres = responsable_nombres;
    }

    public void setresponsable_telefono(String responsable_telefono) {
        this.responsable_telefono = responsable_telefono;
    }

    public void setjun_ini_f(int jun_ini_f) {
        this.jun_ini_f = jun_ini_f;
    }

    public void setjun_fin_f(int jun_fin_f) {
        this.jun_fin_f = jun_fin_f;
    }

    public void setjun_ini_m(int jun_ini_m) {
        this.jun_ini_m = jun_ini_m;
    }

    public void setjun_fin_m(int jun_fin_m) {
        this.jun_fin_m = jun_fin_m;
    }

    public int getcod_recinto() {
        return cod_recinto;
    }

    public int getcod_parroquia() {
        return cod_parroquia;
    }

    public String getparroquia_nombre() {
        return parroquia_nombre;
    }

    public String getnombre_recinto() {
        return nombre_recinto;
    }

    public String getdireccion_recinto() {
        return direccion_recinto;
    }

    public int getcod_zona() {
        return cod_zona;
    }

    public int getnum_jun_mas() {
        return num_jun_mas;
    }

    public int getnum_jun_fem() {
        return num_jun_fem;
    }

    public int getnum_juntas() {
        return num_juntas;
    }

    public String getresponsable_ci() {
        return responsable_ci;
    }

    public String getresponsable_nombres() {
        return responsable_nombres;
    }

    public String getresponsable_telefono() {
        return responsable_telefono;
    }

    public int getjun_ini_f() {
        return jun_ini_f;
    }

    public int getjun_fin_f() {
        return jun_fin_f;
    }

    public int getjun_ini_m() {
        return jun_ini_m;
    }

    public int getjun_fin_m() {
        return jun_fin_m;
    }
}
