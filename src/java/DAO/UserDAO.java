/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.User;
import UTIL.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author renan.sousa
 */
public class UserDAO {

    public void cadastrar_user(User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();

        String sql = "INSERT INTO CANT.gas.CGAS_User (login, senha, nome, email) VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getLogin());
        pstmt.setString(2, user.getSenha());
        pstmt.setString(3, user.getNome());
        pstmt.setString(4, user.getEmail());
        pstmt.execute();

    }

    public void alterar_user(User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();

        String sql = "UPDATE CANT.gas.CGAS_User SET login = ?, senha = ?, nome = ?, email = ? WHERE LOGIN = ?";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getLogin());
        pstmt.setString(2, user.getSenha());
        pstmt.setString(3, user.getNome());
        pstmt.setString(4, user.getEmail());
        pstmt.setString(5, user.getLogin());
        pstmt.executeUpdate();

    }

    public User consultar_user(User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();
        ResultSet rs = null;

        String sql = "SELECT * FROM CANT.gas.CGAS_User WHERE LOGIN = ?";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getLogin());
        rs = pstmt.executeQuery();

        User user_consulta = new User();

        while (rs.next()) {

            user_consulta.setLogin(rs.getString("login"));
            user_consulta.setSenha(rs.getString("senha"));
            user_consulta.setNome(rs.getString("nome"));
            user_consulta.setEmail(rs.getString("email"));

        }

        return user_consulta;
    }
    
    public User consultar_user_nome (User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();
        ResultSet rs = null;

        String sql = "SELECT * FROM CANT.gas.CGAS_User WHERE NOME = ?";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getNome());
        rs = pstmt.executeQuery();

        User user_consulta = new User();

        while (rs.next()) {

            user_consulta.setLogin(rs.getString("login"));
            user_consulta.setSenha(rs.getString("senha"));
            user_consulta.setNome(rs.getString("nome"));
            user_consulta.setEmail(rs.getString("email"));

        }

        return user_consulta;
    }
    
    public void excluir_user (User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();
        
        String sql = "DELETE FROM CANT.gas.CGAS_User WHERE LOGIN = ?";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getLogin());
        pstmt.execute();
        
    }
    
    public boolean validar_user (User user) throws SQLException {

        Connection conexao = ConectaBanco.getConexao();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM CANT.gas.CGAS_User WHERE LOGIN = ? AND SENHA = ?";

        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, user.getLogin());
        pstmt.setString(2, user.getSenha());
        rs = pstmt.executeQuery();
        
        User user_consulta = new User();
        
        while (rs.next()) {
        
            user_consulta.setLogin(rs.getString("login"));
            user_consulta.setSenha(rs.getString("senha"));

        }
        
        boolean validado = false;
        
        if (user.getLogin().equals(user_consulta.getLogin()) && (user.getSenha().equals(user_consulta.getSenha()))) {
            
            validado = true;
    
        } else { validado = false;}
        
        return validado;
        
    }
    
    public ArrayList<User> listar_user() throws SQLException{
        
      Connection conexao =  ConectaBanco.getConexao();
      
      ArrayList<User> list_user = new ArrayList<User>();
      
      
      PreparedStatement sql = conexao.prepareStatement("SELECT NOME FROM CANT.gas.CGAS_User");
      ResultSet rs = sql.executeQuery();
      
       while(rs.next()){
          User search_user = new User();
          search_user.setNome(rs.getString("nome"));
          list_user.add(search_user);
      }
      
      conexao.close();
      return list_user;
    }
    
}
