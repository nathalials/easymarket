/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import easymarket.model.pojo.Filial;
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
public class FilialDAO extends DAO {

    public void incluirFilial(Filial filial) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_FILIAL (RAZAOSOCIAL , CNPJ, ENDERECO, CEP, BAIRRO, CIDADE, ESTADO,TELEFONE,ATIVO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, filial.getRazaoSocial());
            stmt.setLong(2, filial.getCnpj());
            stmt.setString(3, filial.getEndereco());
            stmt.setLong(4, filial.getCep());
            stmt.setString(5, filial.getBairro());
            stmt.setString(6, filial.getCidade());
            stmt.setString(7, filial.getEstado());
            stmt.setLong(8, filial.getTelefone());
            stmt.setString(9, filial.getAtivo());

            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void AlterarFilial(String razaoSocial, long cnpj, String endereco, long cep, String bairro, String cidade, String estado, long telefone, String ativo, int idFilial) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_FILIAL SET RAZAOSOCIAL=?, CNPJ=?,ENDERECO=?,CEP=?,BAIRRO=?,CIDADE=?,ESTADO=?,TELEFONE=?,ATIVO=? WHERE ID_FILIAL=?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, razaoSocial);
            stmt.setLong(2, cnpj);
            stmt.setString(3, endereco);
            stmt.setLong(4, cep);
            stmt.setString(5, bairro);
            stmt.setString(6, cidade);
            stmt.setString(7, estado);
            stmt.setLong(8, telefone);
            stmt.setString(9, ativo);
            stmt.setInt(10, idFilial);

            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void desativarFilial(int idFilial) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_FILIAL SET ATIVO='N' WHERE ID_FILIAL=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFilial);
            //System.out.println("Registro incluido com sucesso.");

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Filial> getLista() throws SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TB_FILIAL";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}
