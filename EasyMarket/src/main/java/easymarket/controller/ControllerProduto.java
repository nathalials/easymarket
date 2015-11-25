/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import easymarket.model.dao.ProdutoDAO;
import easymarket.model.dao.UsuarioDAO;
import easymarket.model.pojo.Produto;
import easymarket.model.pojo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nliggia-ibm
 */
@WebServlet(urlPatterns = "/ControllerProduto")
public class ControllerProduto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private ProdutoDAO dao;

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
            out.println("<title>Servlet ControllerProduto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProduto at " + request.getContextPath() + "</h1>");
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
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json");
        ProdutoDAO produtoDAO = new ProdutoDAO();

        if (action != null) {
            try {
                if (action.equals("list")) {
                    
                    listaProdutos = produtoDAO.getLista();

                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", listaProdutos);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);

                    response.getWriter().print(jsonArray);
                } else if (action.equals("create") || action.equals("update")) {
                    int idProdutoInt = 0;

                    if (action.equals("update")) {
                        String idProduto = request.getParameter("idProduto");
                        idProdutoInt = Integer.parseInt(idProduto);
                    }

                    
                    String nome = request.getParameter("nome");
                    String marca = request.getParameter("marca");
                    String fornecedor = request.getParameter("fornecedor");
                    //studentId = Integer.parseInt(request.getParameter("StudentId"));
                    long codigoDeBarras = Long.parseLong(request.getParameter("codigoDeBarras"));
                    long lote = Long.parseLong(request.getParameter("lote"));
                    String dataValidade = request.getParameter("dataValidade");
                    String setor = request.getParameter("setor");
                    float precoCompra = Float.parseFloat(request.getParameter("precoCompra"));
                    float precoVenda = Float.parseFloat(request.getParameter("precoVenda"));
                    int estoqueMinimo = Integer.parseInt(request.getParameter("estoqueMinimo"));
                    int estoqueMaximo = Integer.parseInt(request.getParameter("estoqueMaximo"));
                    int qtdAtual = Integer.parseInt(request.getParameter("qtdAtual"));
                    String ativo = request.getParameter("ativo");
                    
                    
                    if (estoqueMaximo < estoqueMinimo) 
                    {
                        throw new erroValidacao("Estoque  máximo não pode ser menor que o estoque mínimo!");
                    }
                    
                    if (qtdAtual > estoqueMaximo) 
                    {
                        throw new erroValidacao("Quantidade atual não pode ser maior que o estoque máximo!");
                    }
                    
                    if (qtdAtual < estoqueMinimo) 
                    {
                        throw new erroValidacao("Quantidade atual não pode ser menor que o estoque mínimo!");
                    }
                    
                    if (precoCompra > precoVenda) 
                    {
                        throw new erroValidacao("Preço da compra não pode ser maior que o preço da venda!");
                    }
                    
                     
                    
                    
                    
                    //response.setContentType("text/html");
                    //PrintWriter out = response.getWriter();
                    Produto produto = new Produto(nome, marca, fornecedor, codigoDeBarras, lote, dataValidade, setor, precoCompra, precoVenda, estoqueMinimo, estoqueMaximo, qtdAtual, ativo);
                    ProdutoDAO novoProduto = new ProdutoDAO();

                    if (action.equals("create")) {
                        novoProduto.incluirProduto(produto);
                        // Create new record
                        //dao.incluirUsuario(usuario);
                    } else if (action.equals("update")) {
                        // Update existing record
                        novoProduto.alterarProduto(nome, marca, fornecedor, codigoDeBarras, lote, dataValidade, setor, precoCompra, precoVenda, estoqueMinimo, estoqueMaximo, qtdAtual, ativo, idProdutoInt);
                    }

                    
                    // Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Record", produto);
                    

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    response.getWriter().print(jsonArray);
                } else if (action.equals("delete")) {
                    // Delete record
                    if (request.getParameter("idProduto") != null) {
                        String idProduto = request.getParameter("idProduto");
                        int idProdutoInt = Integer.parseInt(idProduto);

                        
                        produtoDAO.desativarProduto(idProdutoInt);

                        // Return in the format required by jTable plugin
                        JSONROOT.put("Result", "OK");

                        // Convert Java Object to Json
                        String jsonArray = gson.toJson(JSONROOT);
                        response.getWriter().print(jsonArray);
                    }
                }
            } 
            catch (NumberFormatException  ex) {
                try {
                    throw new erroValidacao("ERRO");
                } catch (erroValidacao ex1) {
                    Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            catch (Exception ex) {
                JSONROOT.put("Result", "ERROR");
                JSONROOT.put("Message", ex.getMessage());
                String error = gson.toJson(JSONROOT);
                response.getWriter().print(error);
            }
        }
    }
    public static boolean isNumeric(String str)
    {
    return str.matches("-?\\d+(\\.\\d+)?");  
    }
}

