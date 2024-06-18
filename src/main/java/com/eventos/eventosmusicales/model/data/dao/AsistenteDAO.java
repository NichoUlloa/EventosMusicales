package com.eventos.eventosmusicales.model.data.dao;

import com.eventos.eventosmusicales.model.Asistente;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class AsistenteDAO {
    public static void agregarAsistente(DSLContext query, Asistente asistente) {
        Table<?> tablaAsistente = table(name("Asistente"));
        Field<String> nombre = field(name("nombreAsistente"), VARCHAR(100));
        Field<String> apellido = field(name("apellidoAsistente"), VARCHAR(100));
        Field<Integer> edad = field(name("edadAsistente"), INTEGER);
        Field<String> rut = field(name("rutAsistente"), VARCHAR(12));

        query.insertInto(tablaAsistente, nombre, apellido, edad, rut)
                .values(asistente.getNombreAsistente(), asistente.getApellidoAsistente(), asistente.getEdadAsistente(), asistente.getRutAsistente())
                .execute();
    }

    public static void modificarAsistente(DSLContext query, int idAsistente, String columnaTabla, Object dato) {
        query.update(DSL.table("Asistente")).set(DSL.field(columnaTabla), dato)
                .where(DSL.field("idAsistente").eq(idAsistente)).execute();
    }

    public static List<Asistente> obtenerAsistente(DSLContext query, String columnaTabla, Object dato) {
        Result<?> resultados = query.select().from(DSL.table("Asistente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAsistentes(resultados);
    }

    public static List<Asistente> obtenerAsistentes(DSLContext query) {
        Result<?> resultados = query.select().from(DSL.table("Asistente")).fetch();
        return obtenerListaAsistentes(resultados);
    }

    public static void eliminarAsistente(DSLContext query, int idAsistente) {
        query.delete(DSL.table("Asistente")).where(DSL.field("idAsistente").eq(idAsistente)).execute();
    }

    private static List<Asistente> obtenerListaAsistentes(Result<?> resultados) {
        List<Asistente> asistentes = new ArrayList<>();
        for (Record resultado : resultados) {
            int idAsistente = resultado.get("idAsistente", Integer.class);
            String nombreAsistente = resultado.get("nombreAsistente", String.class);
            String apellidoAsistente = resultado.get("apellidoAsistente", String.class);
            int edadAsistente = resultado.get("edadAsistente", Integer.class);
            String rutAsistente = resultado.get("rutAsistente", String.class);
            asistentes.add(new Asistente(idAsistente, nombreAsistente, apellidoAsistente, edadAsistente, rutAsistente));
        }
        return asistentes;
    }
}
