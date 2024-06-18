package com.eventos.eventosmusicales.model;

public class EventoMusical {
    // atributos EventoMusical: nombreEvento
    private String nombreEvento;

    // constructor EventoMusical: nombreEvento
    public EventoMusical(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    // getter y setter
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
}
