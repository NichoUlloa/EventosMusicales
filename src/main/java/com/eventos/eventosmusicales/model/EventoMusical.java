package com.eventos.eventosmusicales.model;

public class EventoMusical {
    // atributos EventoMusical: idEvento, nombreEvento
    private int idEvento;
    private String nombreEvento;

    // constructor EventoMusical
    public EventoMusical(int idEvento, String nombreEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
    }

    // getter y setter
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
}
