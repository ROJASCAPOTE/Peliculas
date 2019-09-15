/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.vo;

/**
 *
 * @author ACER E5
 */
public class RolVO {

    private int idRol;
    private String nomCorto;
    private String descripcion;

    public RolVO() {
        this.idRol = 0;
        this.nomCorto = "";
        this.descripcion = "";
    }

    public RolVO(int idRol, String nomCorto, String descripcion) {
        this.idRol = idRol;
        this.nomCorto = nomCorto;
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nomCorto;
    }

}
