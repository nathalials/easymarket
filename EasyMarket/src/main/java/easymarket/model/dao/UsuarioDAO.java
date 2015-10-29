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
//
//    public void main(String args[]) {
//
//        Usuario gerente = new Usuario("Joao", "manager", "manager", "joao@email.com", "12345678900", "gerente");
//        
//        incluirUsuario(gerente);
//    }

    public void incluirUsuario(Usuario usuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_USUARIO (NM_USUARIO, LG_USUARIO, PW_USUARIO, EMAIL, CPF, CARGO) VALUES (?, ?, ?, ?, ?, ?)";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getCargo());

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

}
