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
					// Fetch Data from Student Table
					//listaUsuarios = dao.listarUsuarios();
//                                    Usuario usuario1 = new Usuario ("nome1", "login", "senha", "email", "cpf", "cargo", "ativo");
//                                    Usuario usuario2 = new Usuario ("nome2", "login", "senha", "email", "cpf", "cargo", "ativo");
//                                    Usuario usuario3 = new Usuario ("nome3", "login", "senha", "email", "cpf", "cargo", "ativo");
//                                    Usuario usuario4 = new Usuario ("nome4", "login", "senha", "email", "cpf", "cargo", "ativo");
//                                    Usuario usuario5 = new Usuario ("nome5", "login", "senha", "email", "cpf", "cargo", "ativo");
//                                    listaUsuarios.add(usuario1);
//                                    listaUsuarios.add(usuario2);
//                                    listaUsuarios.add(usuario3);
//                                    listaUsuarios.add(usuario4);
//                                    listaUsuarios.add(usuario5);
                                    
					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", listaUsuarios);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				} else if (action.equals("create") || action.equals("update")) {
					Usuario usuario = new Usuario();
					if (request.getParameter("idUsuario") != null) {
						int usuarioId = Integer.parseInt(request.getParameter("idUsuario"));
						usuario.setIdUsuario(usuarioId);
					}

					if (request.getParameter("nome") != null) {
						String nome = request.getParameter("nome");
						usuario.setNome(nome);
					}

					if (request.getParameter("login") != null) {
						String login = request.getParameter("login");
						usuario.setLogin(login);
					}

					if (request.getParameter("senha") != null) {
						String senha = request.getParameter("senha");
						usuario.setSenha(senha);
					}

					if (action.equals("create")) {
						// Create new record
						dao.incluirUsuario(usuario);
					} else if (action.equals("update")) {
						// Update existing record
						dao.AlterarUsuario(usuario);
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
						Usuario usuario = new Usuario();
						dao.DesativarUsuario(usuario);

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