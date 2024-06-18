package com.eventos.eventosmusicales.model;

public class Artista {
    // atributos Artista: idArtista, nombreArtista, apellidoArtista, edadArtista, rutArtista
    private int idArtista;
    private String nombreArtista;
    private String apellidoArtista;
    private int edadArtista;
    private String rutArtista;

    // constructor Artista: idArtista, nombreArtista, apellidoArtista, edadArtista, rutArtista
    public Artista(int idArtista, String nombreArtista, String apellidoArtista, int edadArtista, String rutArtista) {
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.apellidoArtista = apellidoArtista;
        this.edadArtista = edadArtista;
        this.rutArtista = rutArtista;
    }

    // getters y setters
    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public int getEdadArtista() {
        return edadArtista;
    }

    public void setEdadArtista(int edadArtista) {
        this.edadArtista = edadArtista;
    }

    public String getRutArtista() {
        return rutArtista;
    }

    public void setRutArtista(String rutArtista) {
        this.rutArtista = rutArtista;
    }
}
