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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mostrarAsistentesServlet", value = "/mostrarAsistentes")
public class MostrarAsistentesServlet extends HttpServlet {
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
        try {
            req.setAttribute("asistentes", obtenerAsistentes());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarAsistentes.jsp");
        respuesta.forward(req, resp);
    }

    private List<Asistente> obtenerAsistentes() throws ClassNotFoundException {
        List<Asistente> asistentes = new ArrayList<>();
        asistentes = AsistenteDAO.obtenerAsistentes(DBGenerator.conectarBD("EventosBD"));
        return asistentes;
    }
}
