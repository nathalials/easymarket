/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import easymarket.model.dao.FilialDAO;
import easymarket.model.dao.UsuarioDAO;
import easymarket.model.pojo.Filial;
import easymarket.model.pojo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nliggia-ibm
 */
@WebServlet(urlPatterns = "/ControllerFilial")
public class ControllerFilial extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private FilialDAO dao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerFilial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerFilial at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String action = request.getParameter("action");
        List<Filial> listaFilial = new ArrayList<Filial>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json");
        FilialDAO filialDAO = new FilialDAO();

        if (action != null) {
            try {
                if (action.equals("list")) {

                    listaFilial = filialDAO.getLista();

                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", listaFilial);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);

                    response.getWriter().print(jsonArray);
                } else if (action.equals("create") || action.equals("update")) {
                    int idFilialInt = 0;

                    if (action.equals("update")) {
                        String idFilial = request.getParameter("idFilial");
                        idFilialInt = Integer.parseInt(idFilial);
                    }

                    String razaoSocial = request.getParameter("razaoSocial");
                    long cnpj = Long.parseLong(request.getParameter("cnpj"));
                    String endereco = request.getParameter("endereco");
                    //studentId = Integer.parseInt(request.getParameter("StudentId"));
                    long cep = Long.parseLong(request.getParameter("cep"));
                    String bairro = request.getParameter("bairro");
                    String cidade = request.getParameter("cidade");
                    String estado = request.getParameter("estado");
                    long telefone = Long.parseLong(request.getParameter("telefone"));
                    String ativo = request.getParameter("ativo");

                    //response.setContentType("text/html");
                    //PrintWriter out = response.getWriter();
                    Filial filial = new Filial(razaoSocial, cnpj, endereco, cep, bairro, cidade, estado, telefone, ativo);
                    FilialDAO novoFilial = new FilialDAO();

                    if (action.equals("create")) {
                        novoFilial.incluirFilial(filial);
                        // Create new record
                        //dao.incluirUsuario(usuario);
                    } else if (action.equals("update")) {
                        // Update existing record
                        novoFilial.AlterarFilial(razaoSocial, cnpj, endereco, cep, bairro, cidade, estado, telefone, ativo, idFilialInt);
                    }

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Record", filial);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("delete")) {
                    // Delete record
                    if (request.getParameter("idFilial") != null) {
                        String idFilial = request.getParameter("idFilial");
                        int idFilialInt = Integer.parseInt(idFilial);

                        filialDAO.desativarFilial(idFilialInt);

                        // Return in the format required by jTable plugin
                        JSONROOT.put("Result", "OK");

                        // Convert Java Object to Json
                        String jsonArray = gson.toJson(JSONROOT);
                        response.getWriter().print(jsonArray);
                    }
                }
            } catch (Exception ex) {
                JSONROOT.put("Result", "ERROR");
                JSONROOT.put("Message", ex.getMessage());
                String error = gson.toJson(JSONROOT);
                response.getWriter().print(error);
            }
        }
    }

}

