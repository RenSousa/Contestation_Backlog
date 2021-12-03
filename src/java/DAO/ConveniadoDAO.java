/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Conveniado;
import MODEL.User;
import UTIL.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RENAN.SOUSA
 */
public class ConveniadoDAO {
    
    public ArrayList<Conveniado> listar_conveniados() throws SQLException{
        
        ArrayList<Conveniado> list_conveniado;
        
        try (Connection conexao = ConectaBanco.getConexao()) {
            
            list_conveniado = new ArrayList<>();
            PreparedStatement sql = conexao.prepareStatement("SELECT NOME_CONV FROM CANT.gas.CGAS_Concessionaria ORDER BY NOME_CONV");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                Conveniado search_conv = new Conveniado();
                search_conv.setNome(rs.getString("NOME_CONV"));
                list_conveniado.add(search_conv);
            } }
      return list_conveniado;
    }
    
    public ArrayList<String> list_autocomplete_conv(String query) throws SQLException {
            	
    	String conveniado = null;
        query = query.toLowerCase();
        
        ArrayList<String>  matched = new ArrayList<>();
        ConveniadoDAO conveniadoDAO = new ConveniadoDAO();
        
        ArrayList<Conveniado> conveniados = conveniadoDAO.listar_conveniados();
        
        for(int i=0; i < conveniados.size(); i++) {
            conveniado = conveniados.get(i).getNome().toLowerCase();
            if(conveniado.startsWith(query)) {
                matched.add(conveniados.get(i).getNome());
            }
        }
        return matched;
    }
    
    
    
}
