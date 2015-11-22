/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import easymarket.model.dao.UsuarioDAO;
import easymarket.model.pojo.Usuario;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/ControllerUsuario")
public class ControllerUsuario extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private UsuarioDAO dao;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json");
        UsuarioDAO usuarioDao = new UsuarioDAO();

        if (action != null) {
            try {
                if (action.equals("list")) {

                    listaUsuarios = usuarioDao.getLista();
                    
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", listaUsuarios);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);

                    response.getWriter().print(jsonArray);
                } else if (action.equals("create") || action.equals("update")) {
                    int idUsuarioInt= 0; 
                    
                    if (action.equals("update")) 
                    {
                        String idUsuario = request.getParameter("idUsuario");
                        idUsuarioInt = Integer.parseInt(idUsuario);
                    }                    
                                        
                    String nome = request.getParameter("nome");
                    String login = request.getParameter("login");
                    String senha = request.getParameter("senha");
                    String email = request.getParameter("email");
                    String cpf = request.getParameter("cpf");
                    String cargo = request.getParameter("cargo");
                    String ativo = request.getParameter("ativo");

                    //response.setContentType("text/html");
                    //PrintWriter out = response.getWriter();
                    Usuario usuario = new Usuario(nome, login, senha, email, cpf, cargo, ativo);
                    UsuarioDAO novoUsuario = new UsuarioDAO();

                    if (action.equals("create")) {
                        novoUsuario.incluirUsuario(usuario);
                        // Create new record
                        //dao.incluirUsuario(usuario);
                    } else if (action.equals("update")) {
                        // Update existing record
                        novoUsuario.AlterarUsuario(nome,login,senha,email,cpf,cargo,ativo,idUsuarioInt);
                    }

                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Record", usuario);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("delete")) {
                    // Delete record
                    if (request.getParameter("idUsuario") != null) {                                                
                        String idUsuario = request.getParameter("idUsuario");
                        int idUsuarioInt = Integer.parseInt(idUsuario);
                        
                        usuarioDao.DesativarUsuario(idUsuarioInt);

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
