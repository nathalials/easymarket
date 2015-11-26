/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import easymarket.model.dao.FilialDAO;
import easymarket.model.dao.ProdutoDAO;
import easymarket.model.dao.VendaDAO;
import easymarket.model.pojo.Filial;
import easymarket.model.pojo.Produto;
import easymarket.model.pojo.Venda;
import easymarket.model.pojo.Venda_Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nliggia-ibm
 */
@WebServlet(name = "ConsultaProduto", urlPatterns = {"/ConsultaProduto"})
public class ConsultaProduto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

    private VendaDAO dao;
    public Produto produto = new Produto();

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
            out.println("<title>Servlet ConsultaProduto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaProduto at " + request.getContextPath() + "</h1>");
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

        String forward = "";
        ProdutoDAO dao = new ProdutoDAO();

        //float precoVendaProduto = 0;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json");
        List<Venda> listaVenda = new ArrayList<Venda>();
        List<Venda_Produtos> listaVenda_Produtos = new ArrayList<Venda_Produtos>();
        //List<Produto> listaProdutos = new ArrayList<Produto>();
        VendaDAO novoVenda = new VendaDAO();
        Venda venda = new Venda();
        // Venda_Produtos venda_produtos = new Venda_Produtos();
        String action = request.getParameter("action");
        int qtdTotalProdutos = 0;
        float valorTotalVenda = 0;
        long codDeBarras = 0;

        if (action != null) {
            try {
                if (action.equals("list")) {

                    listaVenda_Produtos = novoVenda.listaProdutosVendidos();

                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", listaVenda_Produtos);

                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);

                    response.getWriter().print(jsonArray);
                } else if (action.equalsIgnoreCase("save")) {

                    codDeBarras = Long.parseLong(request.getParameter("codigoDeBarras"));

                    try {
                        produto = dao.buscarProduto(codDeBarras);
                        //precoVendaProduto = produto.getPrecoVenda();

                        //processRequest(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //precoVendaProduto = produto.getPrecoVenda();
                    request.setAttribute("codigoDeBarras", produto.getCodigoDeBarras());
                    request.setAttribute("nome", produto.getNome());
                    request.setAttribute("precoVenda", produto.getPrecoVenda());

                    //int userId = Integer.parseInt(request.getParameter("userId"));
                    //dao.deleteUser(userId);
                    forward = "registroVendas.jsp";

                    //request.setAttribute("users", dao.getAllUsers());
                } else if (action.equals("add")) {

                    String status = "F";

                    int qtdVendida = Integer.parseInt(request.getParameter("qtdVendida"));
                    codDeBarras = produto.getCodigoDeBarras();
                   
                    //float totalProduto = qtdVendida * produto.getPrecoVenda();
                    //result
                    float precoVendaProduto = produto.getPrecoVenda();
                    float totalProduto = precoVendaProduto * qtdVendida;
                    //Venda venda = new Venda(totalProduto, qtdVendida, status);
                    venda.setQtd_total(qtdVendida);
                    venda.setValorTotal(totalProduto);
                    venda.setStatus(status);
                    novoVenda.incluirVenda(venda);

                    Venda_Produtos venda_produtos = new Venda_Produtos();
                    venda_produtos.setidVenda(venda.getidVenda());
                    venda_produtos.setId_produto(produto.getIdProduto());
                    venda_produtos.setQtd_vendida(qtdVendida);
                    venda_produtos.setValor_venda(totalProduto);
                    novoVenda.incluirVendaProduto(venda_produtos);
                    qtdTotalProdutos = qtdTotalProdutos + venda_produtos.getQtd_vendida();
                    valorTotalVenda = (float) (valorTotalVenda + venda_produtos.getValor_venda());
                    
                    novoVenda.BaixaEstoque(qtdTotalProdutos, codDeBarras);

                    forward = "registroVendas.jsp";

                } 
//                if (action.equalsIgnoreCase("fecharVenda")) {
//
//                    novoVenda.AlterarVenda(valorTotalVenda, qtdTotalProdutos, venda.getidVenda());
//                     //novoVenda.BaixaEstoque(qtdTotalProdutos, codDeBarras);
//
//                    forward = "registroVendas.jsp";
//
//                }

                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);

            } catch (Exception ex) {
                JSONROOT.put("Result", "ERROR");
                JSONROOT.put("Message", ex.getMessage());
                String error = gson.toJson(JSONROOT);
                response.getWriter().print(error);
            }
        }
    }

}
