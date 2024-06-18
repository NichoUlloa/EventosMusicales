package com.eventos.eventosmusicales.model.data.dao;

import com.eventos.eventosmusicales.model.EventoMusical;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class EventoMusicalDAO {
    public static void agregarEventoMusical(DSLContext query, EventoMusical evento) {
        Table<?> tablaEvento = table(name("EventoMusical"));
        Field<String> nombre = field(name("nombreEvento"), VARCHAR(100));

        query.insertInto(tablaEvento, nombre)
                .values(evento.getNombreEvento())
                .execute();
    }

    public static void modificarEventoMusical(DSLContext query, int idEvento, String columnaTabla, Object dato) {
        query.update(DSL.table("EventoMusical")).set(DSL.field(columnaTabla), dato)
                .where(DSL.field("idEvento").eq(idEvento)).execute();
    }

    public static List<EventoMusical> obtenerEventoMusical(DSLContext query, String columnaTabla, Object dato) {
        Result<?> resultados = query.select().from(DSL.table("EventoMusical")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaEventos(resultados);
    }

    public static List<EventoMusical> obtenerEventosMusicales(DSLContext query) {
        Result<?> resultados = query.select().from(DSL.table("EventoMusical")).fetch();
        return obtenerListaEventos(resultados);
    }

    public static void eliminarEventoMusical(DSLContext query, int idEvento) {
        query.delete(DSL.table("EventoMusical")).where(DSL.field("idEvento").eq(idEvento)).execute();
    }

    private static List<EventoMusical> obtenerListaEventos(Result<?> resultados) {
        List<EventoMusical> eventos = new ArrayList<>();
        for (Record resultado : resultados) {
            int idEvento = resultado.get("idEvento", Integer.class);
            String nombreEvento = resultado.get("nombreEvento", String.class);
            eventos.add(new EventoMusical(idEvento, nombreEvento));
        }
        return eventos;
    }
}
