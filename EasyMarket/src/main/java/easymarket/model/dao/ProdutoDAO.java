/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import easymarket.model.pojo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipe F5
 */
public class ProdutoDAO extends DAO {

    public void incluirProduto(Produto produto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_PRODUTO (NOME,  MARCA, FORNECEDOR, CODIGODEBARRA, LOTE, "
                + "DATAVALIDADE, SETOR, PRECOCOMPRA, PRECOVENDA, ESTOQUEMINIMO, ESTOQUEMAXIMO, QTDATUAL, ATIVO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
        
        
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getFornecedor());
            stmt.setLong(4, produto.getCodigoDeBarras());
            stmt.setLong(5, produto.getLote());
            stmt.setString(6, produto.getDataValidade());
            stmt.setString(7, produto.getSetor());
            stmt.setFloat(8, produto.getPrecoCompra());
            stmt.setFloat(9, produto.getPrecoVenda());
            stmt.setInt(10, (int) produto.getEstoqueMinimo());
            stmt.setInt(11, (int) produto.getEstoqueMaximo());
            stmt.setInt(12, (int) produto.getQtdAtual());
            stmt.setString(13, produto.getAtivo());

            stmt.executeUpdate();
            
            sql = "SELECT MAX(ID_PRODUTO) ID_PRODUTO FROM TB_PRODUTO";            
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                produto.setIdProduto(rs.getInt("ID_PRODUTO"));
            }
            //System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void alterarProduto(String nome, String marca, String fornecedor, long codigoDeBarras, long lote, String dataValidade, String setor,
            float precoCompra, float precoVenda, int estoqueMinimo, int estoqueMaximo, int qtdAtual, String ativo, int idProduto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_PRODUTO SET NOME=?, MARCA=?,FORNECEDOR=?,CODIGODEBARRA=?,LOTE=?,DATAVALIDADE=?, "
                + "SETOR=?,PRECOCOMPRA=?,PRECOVENDA=?,ESTOQUEMINIMO=?,ESTOQUEMAXIMO=?,QTDATUAL=?, ATIVO=? WHERE ID_PRODUTO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, fornecedor);
            stmt.setLong(4, codigoDeBarras);
            stmt.setLong(5, lote);
            stmt.setString(6, dataValidade);
            stmt.setString(7, setor);
            stmt.setFloat(8, precoCompra);
            stmt.setFloat(9, precoVenda);
            stmt.setInt(10, estoqueMinimo);
            stmt.setInt(11, estoqueMaximo);
            stmt.setInt(12, qtdAtual);
            stmt.setString(13, ativo);
            stmt.setInt(14, idProduto);

            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void desativarProduto(int idProduto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_PRODUTO SET ATIVO='N' WHERE ID_PRODUTO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);

            stmt.executeUpdate();
            //System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Produto> getLista() throws SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TB_PRODUTO";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Produto> produtos = new ArrayList<Produto>();
        while (rs.next()) {
            //Criando um objeto tipo Contato  
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("ID_PRODUTO"));
            produto.setNome(rs.getString("NOME"));
            produto.setMarca(rs.getString("MARCA"));
            produto.setFornecedor(rs.getString("FORNECEDOR"));;
            produto.setCodigoDeBarras(rs.getLong("CODIGODEBARRA"));
            produto.setLote(rs.getLong("LOTE"));
            produto.setDataValidade(rs.getString("DATAVALIDADE"));
            produto.setSetor(rs.getString("SETOR"));
            produto.setPrecoCompra(rs.getFloat("PRECOCOMPRA"));
            produto.setPrecoVenda(rs.getFloat("PRECOVENDA"));
            produto.setEstoqueMinimo(rs.getInt("ESTOQUEMINIMO"));
            produto.setEstoqueMaximo(rs.getInt("ESTOQUEMAXIMO"));
            produto.setQtdAtual(rs.getInt("QTDATUAL"));
            produto.setAtivo(rs.getString("ATIVO"));

            //Adicionando Valores a lista  
            produtos.add(produto);
        }
        rs.close();
        stmt.close();
        return produtos;
    }
}
