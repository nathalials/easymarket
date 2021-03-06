/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import easymarket.model.pojo.Produto;
import easymarket.model.pojo.Usuario;
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

            sql = "SELECT MAX(ID_USUARIO) FROM TB_USUARIO";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            }

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

    public void AlterarUsuario(String nome, String login, String senha, String email, String cpf, String cargo, String ativo, int IdUsuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_USUARIO SET NM_USUARIO=?, LG_USUARIO=?,PS_USUARIO=?,EMAIL=?,CPF=?,CARGO=?, ATIVO=? WHERE ID_USUARIO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, login);
            stmt.setString(3, senha);
            stmt.setString(4, email);
            stmt.setString(5, cpf);
            stmt.setString(6, cargo);
            stmt.setString(7, ativo);
            stmt.setInt(7, IdUsuario);

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

    public void DesativarUsuario(int idUsuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_USUARIO SET ATIVO='N' WHERE ID_USUARIO=?";
        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

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

    public List<Usuario> getLista() throws SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TB_USUARIO";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Usuario> usuarios = new ArrayList<Usuario>();
        while (rs.next()) {
            //Criando um objeto tipo Contato  
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_USUARIO"));
            usuario.setLogin(rs.getString("LG_USUARIO"));
            usuario.setSenha(rs.getString("PS_USUARIO"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setCpf(rs.getString("CPF"));
            usuario.setCargo(rs.getString("CARGO"));
            usuario.setAtivo(rs.getString("ATIVO"));

            usuarios.add(usuario);

            //Adicionando Valores a lista  
        }
        rs.close();
        stmt.close();
        return usuarios;
    }

    public List<Usuario> getListaFilter(String nome) throws SQLException {

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM TB_USUARIO WHERE NM_USUARIO =?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Usuario> usuarios = new ArrayList<Usuario>();
        while (rs.next()) {
            //Criando um objeto tipo Contato  
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_USUARIO"));
            usuario.setLogin(rs.getString("LG_USUARIO"));
            usuario.setSenha(rs.getString("PS_USUARIO"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setCpf(rs.getString("CPF"));
            usuario.setCargo(rs.getString("CARGO"));
            usuario.setAtivo(rs.getString("ATIVO"));

            usuarios.add(usuario);

        }
        rs.close();
        stmt.close();
        return usuarios;
    }

    public String buscarUsuario(String login, String senha) throws SQLException {

        String cargo = null, loginConsulta = null, senhaConsulta = null;

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        //select * from produto where idproduto = ?  
        String sql = "SELECT * FROM TB_USUARIO WHERE LG_USUARIO = ?";
        //Select * from usuario where login='"+ login + "'"

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (rs.next()) {
            // armazena o conte�do da coluna login numa vari�vel
            loginConsulta = rs.getString("LG_USUARIO");
            senhaConsulta = rs.getString("PS_USUARIO");
            cargo = rs.getString("CARGO");

        }

        // se a senha e usu�rio passados por parametro forem iguais a do banco,
        // retorna o tipo de cargo do usu�rio
        if (login.equals(loginConsulta)
                && senha.equals(senhaConsulta)) {
            return cargo;
        } else {
            // se n�o for igual, deixa a permiss�o como nula
            cargo = null;
        }
        return cargo;

    }
}
