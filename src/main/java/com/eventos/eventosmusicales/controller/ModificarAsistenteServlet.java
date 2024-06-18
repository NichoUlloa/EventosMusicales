package com.eventos.eventosmusicales.controller;

import com.eventos.eventosmusicales.model.Asistente;
import com.eventos.eventosmusicales.model.data.DBGenerator;
import com.eventos.eventosmusicales.model.data.dao.AsistenteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "modificarAsistenteServlet", value = "/modificarAsistente")
public class ModificarAsistenteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("EventosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/modificarAsistente.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/modificacionErronea.jsp");
        if (req.getParameter("id").length() != 0 && req.getParameter("nombre").length() != 0 &&
                req.getParameter("apellido").length() != 0 && req.getParameter("edad").length() != 0 &&
                req.getParameter("rut").length() != 0) {
            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Asistente asistente = new Asistente(id, nombre, apellido, edad, rut);
            try {
                if (modificarAsistente(asistente)) {
                    req.setAttribute("asistente", asistente);
                    respuesta = req.getRequestDispatcher("/modificacionExitosa.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean modificarAsistente(Asistente asistente) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("EventosBD");
        AsistenteDAO.modificarAsistente(query, asistente.getIdAsistente(), "nombreAsistente", asistente.getNombreAsistente());
        AsistenteDAO.modificarAsistente(query, asistente.getIdAsistente(), "apellidoAsistente", asistente.getApellidoAsistente());
        AsistenteDAO.modificarAsistente(query, asistente.getIdAsistente(), "edadAsistente", asistente.getEdadAsistente());
        AsistenteDAO.modificarAsistente(query, asistente.getIdAsistente(), "rutAsistente", asistente.getRutAsistente());
        return true;
    }
}
