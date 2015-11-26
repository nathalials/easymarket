///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package easymarket.controller;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import easymarket.model.dao.VendaDAO;
//import easymarket.model.pojo.Produto;
//import easymarket.model.pojo.Venda;
//import easymarket.model.pojo.Venda_Produtos;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author nliggia-ibm
// */
//@WebServlet(urlPatterns = "/ControllerVenda")
//public class ControllerVenda extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//    private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
//
//    
//    private VendaDAO dao;
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerFilial</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerFilial at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //processRequest(request, response);
//
//        String action = request.getParameter("action");
//        List<Venda> listaVenda = new ArrayList<Venda>();
//        List<Venda_Produtos> listaVenda_Produtos = new ArrayList<Venda_Produtos>();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        response.setContentType("application/json");
//        //VendaDAO filialDAO = new VendaDAO();
//
//        if (action != null) {
//            try {
//                if (action.equals("create")) {
//                    int idFilialInt = 0;
//
//                    if (action.equals("update")) {
//                        //String idFilial = request.getParameter("idFilial");
//                        //idFilialInt = Integer.parseInt(idFilial);
//                    }
//
//                    int ValorTotal = Integer.parseInt(request.getParameter("ValorTotal"));
//                    String Status = "F";
//                    List<String> produtos = Arrays.asList(request.getParameter("ListaProd"));
//                    
//                    //Venda venda = new Venda(ValorTotal, Status);
//                    VendaDAO novoVenda = new VendaDAO();
//                    
//                    Venda_Produtos venda_produtos = new Venda_Produtos();
//                    
//                    if (action.equals("create")) {
//                        novoVenda.incluirVenda(venda);
//                        
//                        for (String item : produtos) 
//                        {
//                            venda_produtos.setidVenda(venda.getidVenda());
//                            venda_produtos.setId_produto(Integer.parseInt(item));
//                            novoVenda.incluirVendaProduto(venda_produtos);
//                        }
//                    }
//                                        
//                    // Return in the format required by jTable plugin
//                     
//                    //JSONROOT.put("Result", "OK");
//                    //JSONROOT.put("Record", filial);
//
//                    // Convert Java Object to Json
//                    //String jsonArray = gson.toJson(JSONROOT);
//                    //response.getWriter().print(jsonArray);
//                }
//            } catch (Exception ex) {
//                JSONROOT.put("Result", "ERROR");
//                JSONROOT.put("Message", ex.getMessage());
//                String error = gson.toJson(JSONROOT);
//                response.getWriter().print(error);
//            }
//        }
//    }
//
//}
//
