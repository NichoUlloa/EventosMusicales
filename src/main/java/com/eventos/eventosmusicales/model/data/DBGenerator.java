package com.eventos.eventosmusicales.model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaArtista(create);
        crearTablaAsistente(create);
        crearTablaEventoMusical(create);
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearTablaArtista(DSLContext create) {
        create.createTableIfNotExists("Artista")
                .column("idArtista", INTEGER.identity(true))
                .column("nombreArtista", VARCHAR(100))
                .column("apellidoArtista", VARCHAR(100))
                .column("edadArtista", INTEGER)
                .column("rutArtista", VARCHAR(12))
                .constraint(primaryKey("idArtista")).execute();
    }

    private static void crearTablaAsistente(DSLContext create) {
        create.createTableIfNotExists("Asistente")
                .column("idAsistente", INTEGER.identity(true))
                .column("nombreAsistente", VARCHAR(100))
                .column("apellidoAsistente", VARCHAR(100))
                .column("edadAsistente", INTEGER)
                .column("rutAsistente", VARCHAR(12))
                .constraint(primaryKey("idAsistente")).execute();
    }

    private static void crearTablaEventoMusical(DSLContext create) {
        create.createTableIfNotExists("EventoMusical")
                .column("idEvento", INTEGER.identity(true))
                .column("nombreEvento", VARCHAR(100))
                .constraint(primaryKey("idEvento")).execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}
