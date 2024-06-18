package com.eventos.eventosmusicales.controller;

import com.eventos.eventosmusicales.model.data.DBGenerator;
import com.eventos.eventosmusicales.model.data.dao.AsistenteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "eliminarAsistenteServlet", value = "/eliminarAsistente")
public class EliminarAsistenteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminarAsistente.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/eliminacionErronea.jsp");
        if (req.getParameter("id").length() != 0) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                if (eliminarAsistente(id)) {
                    respuesta = req.getRequestDispatcher("/eliminacionExitosa.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean eliminarAsistente(int id) throws ClassNotFoundException {
        AsistenteDAO.eliminarAsistente(DBGenerator.conectarBD("EventosBD"), id);
        return true;
    }
}
