/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Erros;
import UTIL.ConectaBanco;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import jxl.*;
import jxl.read.biff.BiffException;

/**
 *
 * @author RENAN.SOUSA
 */
public class ErrosDAO {
    
    
    public void relatorio_erros(Date data_ini, Date data_fim) throws SQLException, IOException {
    
        ArrayList<Erros> reporterros = new ArrayList<>();
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        try {
        
        conexao =  ConectaBanco.getConexao();
        String sql = "SELECT * FROM CANT.gas.erros where DATA_ALT >= ? AND DATA_ALT <= ? ";      
        pstmt = conexao.prepareStatement(sql);
        
        java.sql.Date data_ini_f = new java.sql.Date(data_ini.getTime());
        pstmt.setDate(1, data_ini_f);
        java.sql.Date data_fim_f = new java.sql.Date(data_fim.getTime());
        pstmt.setDate(2, data_fim_f);
        
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            
            Erros erros = new Erros();
            
            erros.setCod_erro(String.format("%f", rs.getDouble("TAREFA")));
            erros.setCod_erro_contingencia(rs.getString("TAREFA_ORIGINAL"));
            erros.setMotivo(rs.getString("OBS"));
            erros.setTipo(rs.getString("TIPO"));
            erros.setLogin(rs.getString("LOGIN"));
            erros.setMsg(rs.getString("MSG"));
            erros.setData_alt(rs.getDate("DATA_ALT"));
            
            reporterros.add(erros);
            
        }
        
         Date hoje = new Date();
         java.sql.Date hoje_f = new java.sql.Date(hoje.getTime());
         
    
        FileWriter writer = new FileWriter("B:\\GERAL\\APP CGAS\\REPORT ERROS\\Relatórios\\Report_Erros " + hoje_f +".csv");

        writer.append("TAREFA_ORIGINAL");
        writer.append(';');
        writer.append("MOTIVO");
        writer.append(';');
        writer.append("TAREFA_CONTINGENCIA");
        writer.append(';');
        writer.append("TIPO");
        writer.append(';');
        writer.append("LOGIN");
        writer.append(';');
        writer.append("DATA_ALT");
        writer.append(';');
        writer.append("MSG");
        writer.append('\n');
        
        
        
        for (Erros rep : reporterros) {
            
            
            
            writer.append(rep.getCod_erro());
            writer.append(';');
            writer.append(rep.getMotivo());
            writer.append(';');
            writer.append(rep.getCod_erro_contingencia());
            writer.append(';');
            writer.append(rep.getTipo());
            writer.append(';');
            writer.append(rep.getLogin());
            writer.append(';');
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            writer.append(formato.format(rep.getData_alt()));
            writer.append(';');
            writer.append(rep.getMsg());
            writer.append('\n');
        
        }
        

        writer.flush();
        writer.close();
            
        
                } catch (SQLException erro)  {
        
    }
        
    }
    
    
    public void receber_planilha(String caminho) throws IOException, BiffException, ParseException, SQLException {

        Workbook workbook = Workbook.getWorkbook(new File("B:\\GERAL\\APP CGAS\\REPORT ERROS\\" + caminho));
        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();

        int y = 0;

        ArrayList<Erros> list_erros = new ArrayList<>();
            
        /* x linha e y coluna */
        
        for (int x = 1; x <= linhas - 1;) {

            jxl.Cell a2 = sheet.getCell(y, x);
            jxl.Cell b2 = sheet.getCell(y + 1, x);
            jxl.Cell c2 = sheet.getCell(y + 2, x);
            jxl.Cell d2 = sheet.getCell(y + 3, x);
            jxl.Cell e2 = sheet.getCell(y + 4, x);
            jxl.Cell f2 = sheet.getCell(y + 5, x);
            
            String as2 = a2.getContents();
            String bs2 = b2.getContents();
            String cs2 = c2.getContents();
            String ds2 = d2.getContents();
            String es2 = e2.getContents();
            String fs2 = f2.getContents();
            
            Erros erro = new Erros();

            erro.setCod_erro(as2);
            erro.setMotivo(bs2);
            erro.setCod_erro_contingencia(cs2);
            erro.setTipo(ds2);
            erro.setLogin(es2);
            erro.setMsg(fs2);
            
            list_erros.add(erro);

            x++;
        }

        workbook.close();
        
        for (Erros r : list_erros){
        
        Connection conexao = ConectaBanco.getConexao();
        
        PreparedStatement sql = conexao.prepareStatement("INSERT INTO CANT.gas.erros (TAREFA, OBS, TAREFA_ORIGINAL, TIPO, LOGIN, DATA_ALT, MSG) VALUES (? , ?, ?, ?, ?, ?, ?)");
        sql.setString(1, r.getCod_erro());
        sql.setString(2, r.getMotivo());
        sql.setString(3, r.getCod_erro_contingencia());
        sql.setString(4, r.getTipo());
        sql.setString(5, r.getLogin());
        Date data_alt = new Date();
        java.sql.Date dataSQL = new java.sql.Date(data_alt.getTime());
        sql.setDate(6, dataSQL);
        sql.setString(7, r.getMsg());
        sql.execute();
        
        }

    }


    
}
