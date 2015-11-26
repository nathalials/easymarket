/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import easymarket.model.pojo.Produto;
import easymarket.model.pojo.Usuario;
import easymarket.model.pojo.Venda;
import easymarket.model.pojo.Venda_Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipe F5
 */
public class VendaDAO extends DAO {

    public void incluirVenda(Venda venda) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_VENDA(QTD_TOTAL,VALOR_TOTAL,STATUS) VALUES(?,?,?)";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, venda.getQtd_total());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.setString(3, venda.getStatus());

            stmt.executeUpdate();

            sql = "SELECT MAX(ID_VENDA) ID_VENDA FROM TB_VENDA";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                venda.setidVenda(rs.getInt("ID_VENDA"));
            }
            
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void AlterarVenda(double valor_total, int qtd_total, int id_venda) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_VENDA SET VALOR_TOTAL=?,QTD_TOTAL=? WHERE ID_VENDA=?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, valor_total);
            stmt.setInt(2, qtd_total);
            stmt.setInt(3, id_venda);

            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /*
     public List<Filial> getLista()  {

     PreparedStatement stmt = null;
     Connection conn = null;
     ResultSet rs = null;
     String sql = "SELECT * FROM TB_FILIAL";

     try {
     conn = obterConexao();
     stmt = conn.prepareStatement(sql);
     rs = stmt.executeQuery();
     } catch (ClassNotFoundException ex) {
     Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
     }

     List<Filial> filiais = new ArrayList<Filial>();
     while (rs.next()) {
     //Criando um objeto tipo Contato  
     Filial filial = new Filial();
     filial.setidFilial(rs.getInt("ID_FILIAL"));
     filial.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
     filial.setCnpj(rs.getLong("CNPJ"));
     filial.setEndereco(rs.getString("ENDERECO"));
     filial.setCep(rs.getLong("CEP"));
     filial.setBairro(rs.getString("BAIRRO"));
     filial.setCidade(rs.getString("CIDADE"));
     filial.setEstado(rs.getString("ESTADO"));
     filial.setTelefone(rs.getLong("TELEFONE"));
     filial.setAtivo(rs.getString("ATIVO"));

     //Adicionando Valores a lista  
     filiais.add(filial);
     }
     rs.close();
     stmt.close();
     return filiais;
     }
     */
    public void incluirVendaProduto(Venda_Produtos vendaprodutos) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO VENDA_PRODUTOS(ID_VENDA,ID_PRODUTO,QTD_VENDIDA,VALOR_VENDA) VALUES(?,?,?,?)";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, vendaprodutos.getidVenda());
            stmt.setInt(2, vendaprodutos.getId_Produto());
            stmt.setInt(3, vendaprodutos.getQtd_vendida());
            stmt.setDouble(4, vendaprodutos.getValor_venda());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public List<Venda_Produtos> listaProdutosVendidos() throws SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM VENDA_PRODUTOS";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Venda_Produtos> produtosVendidos = new ArrayList<Venda_Produtos>();
        while (rs.next()) {
            //Criando um objeto tipo Contato  
            Venda_Produtos venda_produto = new Venda_Produtos();
            venda_produto.setidVenda(rs.getInt("ID_VENDA"));
            venda_produto.setId_produto(rs.getInt("ID_PRODUTO"));
            venda_produto.setQtd_vendida(rs.getInt("QTD_VENDIDA"));
            venda_produto.setValor_venda(rs.getDouble("VALOR_VENDA"));

            produtosVendidos.add(venda_produto);

            //Adicionando Valores a lista  
        }
        rs.close();
        stmt.close();
        return produtosVendidos;
    }
    
    public void BaixaEstoque(int qtdVendida, long codBarras) throws SQLException {
        Produto produto = new Produto();
        ProdutoDAO produtoDao = new ProdutoDAO();
        produto = produtoDao.buscarProduto(codBarras);
        int qtdAtual = produto.getQtdAtual();
        qtdAtual = qtdAtual - qtdVendida;
        int idProduto = produto.getIdProduto();
        
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_PRODUTO SET QTDATUAL=? WHERE ID_PRODUTO=?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, qtdAtual);
            stmt.setInt(2, idProduto);

            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
