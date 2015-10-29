/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Equipe F5
 */

//classe do prof que conecta com o banco de dados
//https://github.com/ftsuda82/IntegracaoJBDC/blob/master/src/main/java/br/senac/tads/pi3/ftsuda/integracaojdbc/ContatosApp.java

public class DAO {

    public Connection obterConexao() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        // Passo 1: Registrar driver JDBC.
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        // Passo 2: Abrir a conexão
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/easymarket;SecurityMechanism=3",
                "easymarket", // usuario
                "easymarket"); // senha
        return conn;
    }

}
