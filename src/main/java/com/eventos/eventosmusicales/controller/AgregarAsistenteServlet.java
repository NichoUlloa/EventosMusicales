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

import java.io.IOException;

@WebServlet(name = "agregarAsistenteServlet", value = "/agregarAsistente")
public class    AgregarAsistenteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroAsistente.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if (req.getParameter("nombre").length() != 0 && req.getParameter("apellido").length() != 0 &&
                req.getParameter("edad").length() != 0 && req.getParameter("rut").length() != 0) {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Asistente asistente = new Asistente(0, nombre, apellido, edad, rut);
            try {
                if (agregarAsistente(asistente)) {
                    req.setAttribute("asistente", asistente);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean agregarAsistente(Asistente asistente) throws ClassNotFoundException {
        AsistenteDAO.agregarAsistente(DBGenerator.conectarBD("EventosBD"), asistente);
        return true;
    }
}
