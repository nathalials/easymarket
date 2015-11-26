/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.controller;

import easymarket.model.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarLogin
 */
@WebServlet(urlPatterns = "/ValidarLogin")
public class ControllerLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDAO dao = new UsuarioDAO();
        String cargo = null;
        try {
            cargo = dao.buscarUsuario(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (cargo != null) {
            if (cargo.equalsIgnoreCase("G")) {
                response.sendRedirect("index.jsp");
            } else if (cargo.equalsIgnoreCase("B")) {
                response.sendRedirect("indexBackOffice.jsp");

            } else if (cargo.equalsIgnoreCase("C")) {
                response.sendRedirect("index_caixa.jsp");
            }

        } else {
            response.sendRedirect("loginAgain.jsp"); 
        }

    }
}
