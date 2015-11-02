/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.teste;

import easymarket.model.dao.DAO;
import easymarket.model.dao.UsuarioDAO;
import easymarket.model.pojo.Usuario;
import java.sql.SQLException;

/**
 *
 * @author DU
 */
public class teste {
    
    public static void main (String[]args) throws SQLException, ClassNotFoundException{
        Usuario usuario = new Usuario("Eduardo", "eduardo","eduardo", "eduardo@eduardo.com.br", "433344433", "aluno", "s");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.incluirUsuario(usuario);
    }
    
}
