package com.eventos.eventosmusicales.model;

public class Asistente {
    // atributos Asistente: idAsistente, nombreAsistente, apellidoAsistente, edadAsistente, rutAsistente
    private int idAsistente;
    private String nombreAsistente;
    private String apellidoAsistente;
    private int edadAsistente;
    private String rutAsistente;

    // constructor Asistente: idAsistente, nombreAsistente, apellidoAsistente, edadAsistente, rutAsistente
    public Asistente(int idAsistente, String nombreAsistente, String apellidoAsistente, int edadAsistente, String rutAsistente) {
        this.idAsistente = idAsistente;
        this.nombreAsistente = nombreAsistente;
        this.apellidoAsistente = apellidoAsistente;
        this.edadAsistente = edadAsistente;
        this.rutAsistente = rutAsistente;
    }

    // getter y setter
    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    public String getApellidoAsistente() {
        return apellidoAsistente;
    }

    public void setApellidoAsistente(String apellidoAsistente) {
        this.apellidoAsistente = apellidoAsistente;
    }

    public int getEdadAsistente() {
        return edadAsistente;
    }

    public void setEdadAsistente(int edadAsistente) {
        this.edadAsistente = edadAsistente;
    }

    public String getRutAsistente() {
        return rutAsistente;
    }

    public void setRutAsistente(String rutAsistente) {
        this.rutAsistente = rutAsistente;
    }
}
