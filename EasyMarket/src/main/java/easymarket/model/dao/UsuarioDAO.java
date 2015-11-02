/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import easymarket.model.pojo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipe F5
 */
public class UsuarioDAO extends DAO {
    /*    
    INSERT INTO TB_USUARIO (NM_USUARIO, LG_USUARIO, PS_USUARIO, EMAIL, CPF, CARGO) VALUES ('JOÃO', 'JOAO', '1234','joao_vidaloka@ig.com.br' ,'123456789', 'CAIXA')
    */
    
    public void incluirUsuario(Usuario usuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_USUARIO (NM_USUARIO,  LG_USUARIO, PS_USUARIO, EMAIL, CPF, CARGO, ATIVO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getCargo());
            stmt.setString(7, usuario.getAtivo());

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
    
    public void AlterarUsuario(Usuario usuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_USUARIO SET NMUSUARIO=?, LG_USUARIO=?,PS_USUARIO=?,EMAIL=?,CPF=?,CARGO=? WHERE ID_USUARIO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getCargo());
            stmt.setString(7, usuario.getIdUsuario());

            stmt.executeUpdate(sql);
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

    public void DesativarUsuario(Usuario usuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE ATIVO=? WHERE ID_USUARIO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getAtivo());
            stmt.setString(2, usuario.getIdUsuario());
            
            stmt.executeUpdate(sql);
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
}
