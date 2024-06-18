package com.eventos.eventosmusicales.model.data.dao;

import com.eventos.eventosmusicales.model.Artista;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class ArtistaDAO {
    public static void agregarArtista(DSLContext query, Artista artista) {
        Table<?> tablaArtista = table(name("Artista"));
        Field<String> nombre = field(name("nombreArtista"), VARCHAR(100));
        Field<String> apellido = field(name("apellidoArtista"), VARCHAR(100));
        Field<Integer> edad = field(name("edadArtista"), INTEGER);
        Field<String> rut = field(name("rutArtista"), VARCHAR(12));

        query.insertInto(tablaArtista, nombre, apellido, edad, rut)
                .values(artista.getNombreArtista(), artista.getApellidoArtista(), artista.getEdadArtista(), artista.getRutArtista())
                .execute();
    }

    public static void modificarArtista(DSLContext query, int idArtista, String columnaTabla, Object dato) {
        query.update(DSL.table("Artista")).set(DSL.field(columnaTabla), dato)
                .where(DSL.field("idArtista").eq(idArtista)).execute();
    }

    public static List<Artista> obtenerArtista(DSLContext query, String columnaTabla, Object dato) {
        Result<?> resultados = query.select().from(DSL.table("Artista")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArtistas(resultados);
    }

    public static List<Artista> obtenerArtistas(DSLContext query) {
        Result<?> resultados = query.select().from(DSL.table("Artista")).fetch();
        return obtenerListaArtistas(resultados);
    }

    public static void eliminarArtista(DSLContext query, int idArtista) {
        query.delete(DSL.table("Artista")).where(DSL.field("idArtista").eq(idArtista)).execute();
    }

    private static List<Artista> obtenerListaArtistas(Result<?> resultados) {
        List<Artista> artistas = new ArrayList<>();
        for (Record resultado : resultados) {
            int idArtista = resultado.get("idArtista", Integer.class);
            String nombreArtista = resultado.get("nombreArtista", String.class);
            String apellidoArtista = resultado.get("apellidoArtista", String.class);
            int edadArtista = resultado.get("edadArtista", Integer.class);
            String rutArtista = resultado.get("rutArtista", String.class);
            artistas.add(new Artista(idArtista, nombreArtista, apellidoArtista, edadArtista, rutArtista));
        }
        return artistas;
    }
}
