/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Contestacao;
import MODEL.Email;
import MODEL.User;
import UTIL.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author RENAN.SOUSA
 */
public class ContestacaoDAO {

    public ArrayList<String> listar_lojas() throws SQLException {

        ArrayList<String> list_lojas = new ArrayList<>();

        try (Connection conexao = ConectaBanco.getConexao()) {

            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM CANT.gas.CGAS_Lojas ORDER BY NOME");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {

                String nome_loja = (rs.getString("NOME"));
                list_lojas.add(nome_loja);

            }
        }
        return list_lojas;
    }

    public Contestacao consultar_contestacao(Contestacao c) throws SQLException {

        Contestacao contestacao;
        try (Connection conexao = ConectaBanco.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM CANT.gas.CGAS_Contestation WHERE NUM_OCORRENCIA = ?");
            sql.setString(1, c.getNum_ocorrencia());
            ResultSet rs = sql.executeQuery();
            contestacao = new Contestacao();
            while (rs.next()) {
                
                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                sql = conexao.prepareStatement(sql_email);
                sql.setString(1, contestacao.getNum_ocorrencia());
                ResultSet rs_email = sql.executeQuery();
                
                while (rs_email.next()) {
                    email.setData_envio(rs_email.getDate("dt_envio"));
                    email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                }
            }
        }
        return contestacao;

    }

    public void carregar_contestacao() {

        ArrayList<Contestacao> backlog = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT\n"
                    + "\n"
                    + "		ODS_OC.OCCURRENCE_TYPE_NAME         								TIPO\n"
                    + "	   ,ODS_OC.NATURE_TYPE_NAME 			 								NATUREZA\n"
                    + "	   ,ODS_OC.OCCURRENCE_CODE              								NUM_OCORRENCIA\n"
                    + "	   ,ODS_OC.OCCURRENCE_DESC              								DESCRICAO\n"
                    + "	   ,ODS_CT.QTD_ITENS         											QTD_ITENS\n"
                    + "	   ,ODS_CT.VLR_CONTESTADO     										    VLR_CONTESTADO\n"
                    + "	   ,ODS_OC.LOGIN_CREATE                 								LOGIN_ABERTURA\n"
                    + "	   ,CAD_CUST.CUSTOMER_CODE		     									NRC\n"
                    + "	   ,CAD_CUST.CUSTOMER_NAME												NOME_CLIENTE\n"
                    + "	   ,CAD_CUST.DOCUMENT_TYPE					 							TIPO_PESSOA\n"
                    + "	   ,CAD_CUST.DOCUMENT_F													CPF_CNPJ\n"
                    + "	   ,ODS_OC.CREATION_DATE									DATA_ABERTURA\n"
                    + "	   ,ODS_OC.UNIDADE_NAME													POSTO_DE_APOIO\n"
                    + "	   ,CASE WHEN DEMANDAS.EQUIPE= 'PRIORIZAÇÃO' THEN\n"
                    + "			 CASE WHEN CHARINDEX('cartão', ODS_OC.OCCURRENCE_DESC) > 0 THEN 'FINANCEIRO' ELSE\n"
                    + "			 CASE WHEN CHARINDEX('detalh', ODS_OC.OCCURRENCE_DESC) > 0 THEN 'PRIORIZAÇÃO' ELSE \n"
                    + "		'NULL' END END ELSE\n"
                    + "		DEMANDAS.EQUIPE\n"
                    + "		END\n"
                    + "		AS EQUIPE\n"
                    + "	   ,CASE \n"
                    + "	         WHEN CANAIS.LOGIN IS NOT NULL THEN '1'\n"
                    + "			 WHEN DEMANDAS.EQUIPE = 'VALE PEDÁGIO' THEN '1'\n"
                    + "			 WHEN DEMANDAS.EQUIPE = 'TAG TROCADO' THEN '1'\n"
                    + "			 ELSE '0' END\n"
                    + "      AS CANAIS_CRITICOS\n"
                    + "	  ,CASE WHEN ACC.account_balance < 0 THEN 'INADIMPLENTE' ELSE 'ADIMPLENTE' END AS STATUS_CLIENTE\n"
                    + "	  ,ACC.account_due_day															  VENCIMENTO_FATURA\n"
                    + "	  ,ACC.account_balance															  SALDO_BALANCE\n"
                    + "	  ,ACC.account_payment_modality													  MODO_PAGAMENTO\n"
                    + "	  \n"
                    + "FROM ODS.ATTENDANCE.ODS_OCCURRENCE ODS_OC\n"
                    + "\n"
                    + "LEFT JOIN  (                                                                  \n"
                    + "			SELECT   OCCURRENCE_CODE\n"
                    + "					,COUNT(CONTESTATION_ITEM_CODE)                                   QTD_ITENS\n"
                    + "					,SUM(CONTESTATION_VALUE)                                         VLR_CONTESTADO\n"
                    + "			FROM    ODS.ATTENDANCE.ODS_CONTESTATION\n"
                    + "					GROUP BY   OCCURRENCE_CODE\n"
                    + "			)   ODS_CT\n"
                    + "				ON  ODS_OC.OCCURRENCE_CODE = ODS_CT.OCCURRENCE_CODE	\n"
                    + "\n"
                    + "INNER JOIN ODS.CAD.ODS_CUSTOMER CAD_CUST\n"
                    + "		   ON CAD_CUST.CUSTOMER_ID = ODS_OC.CUSTOMER_ID\n"
                    + "\n"
                    + "LEFT JOIN CANT.dbo.CGAS_Demandas DEMANDAS\n"
                    + "		  ON DEMANDAS.NATUREZA = ODS_OC.NATURE_TYPE_NAME\n"
                    + "\n"
                    + "LEFT JOIN CANT.dbo.CGAS_CanaisCriticos CANAIS\n"
                    + "		  ON CANAIS.LOGIN = ODS_OC.LOGIN_CREATE\n"
                    + "\n"
                    + "LEFT JOIN ODS.CAD.ods_account ACC\n"
                    + "		  ON ACC.customer_code = CAD_CUST.customer_code\n"
                    + "		  AND ACC.account_type_id = 1\n"
                    + "	\n"
                    + "WHERE\n"
                    + "\n"
                    + "			ODS_OC.REG_STATUS_CODE IN ('1','2')\n"
                    + "        AND ODS_OC.OCCURRENCE_CODE NOT IN (SELECT TAREFA FROM CANT.dbo.CGAS_ReportErros2)\n"
                    + "		AND ODS_OC.OCCURRENCE_CODE NOT IN (SELECT NUM_TAREFA FROM CANT.dbo.CGAS_Ocorrencias)\n"
                    + "		AND ODS_OC.OCCURRENCE_CODE NOT IN (SELECT NUM_OCORRENCIA FROM CANT.gas.CGAS_Contestation)\n"
                    + "         AND ODS_OC.LOGIN_CREATE NOT IN ('user_contesta_vp', 'user_contesta_pass', 'kelly.araujo', 'maria.carvalho', 'adrianas.gomes')"
                    + "		AND	ODS_OC.UNIDADE_CODE IN (100021)\n"
                    + "		AND	ODS_OC.NATURE_TYPE_CODE NOT IN ('101638','100062000','101259','101548','101544','101169','101019',\n"
                    + "				'101018','101016','101015','101071','101069','101066','101060','101055',\n"
                    + "				'101052','101048','101035','100091','100076','100035003','100026003',\n"
                    + "				'100026002','100036005','100009002','100017006','100024046','100024019',\n"
                    + "				'101394','100068','100066','100007','100009006','101085','100003002',\n"
                    + "				'101522','101471','101416','100075')\n"
                    + "       ORDER BY ODS_OC.CREATION_DATE;";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_DE_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));

                backlog.add(contestacao);

            }

            for (Contestacao ct : backlog) {

                java.sql.Date dataAbertura = new java.sql.Date(ct.getData_abertura().getTime());
                dateFormat.format(dataAbertura);

                conexao = ConectaBanco.getConexao();
                String sql2 = "INSERT INTO CANT.gas.CGAS_Contestation  "
                        + "(TIPO, NATUREZA, NUM_OCORRENCIA , DESCRICAO, "
                        + "QTD_ITENS, VLR_CONTESTADO, LOGIN_ABERTURA, "
                        + "NRC, NOME_CLIENTE, TIPO_PESSOA, CPF_CNPJ, "
                        + "DATA_ABERTURA, POSTO_APOIO, "
                        + "EQUIPE, CANAIS_CRITICOS, STATUS_CLIENTE, VENCIMENTO_FATURA, "
                        + "SALDO_BALANCE, MODO_PAGAMENTO) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pstmt = conexao.prepareStatement(sql2);
                pstmt.setString(1, ct.getTipo());
                pstmt.setString(2, ct.getNatureza());
                pstmt.setString(3, ct.getNum_ocorrencia());
                pstmt.setString(4, ct.getDescricao());
                pstmt.setInt(5, ct.getQtd_itens());
                pstmt.setDouble(6, ct.getValor_contestado());
                pstmt.setString(7, ct.getLogin_abertura());
                pstmt.setString(8, ct.getNrc());
                pstmt.setString(9, ct.getNome_cliente());
                pstmt.setString(10, ct.getTipo_pessoa());
                pstmt.setString(11, ct.getCpf_cnpj());
                pstmt.setDate(12, dataAbertura);
                pstmt.setString(13, ct.getPosto_de_apoio());
                pstmt.setString(14, ct.getEquipe());
                pstmt.setInt(15, ct.getCanais_criticos());
                pstmt.setString(16, ct.getStatus_cliente());
                pstmt.setString(17, ct.getVencimento_fatura());
                pstmt.setDouble(18, ct.getSaldo_balance());
                pstmt.setString(19, ct.getModo_pagamento());
                pstmt.execute();

            }

        } catch (SQLException erro) {

        }

    }

    public ArrayList<Contestacao> verificar_pendencias(User user) {

        ArrayList<Contestacao> backlog = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation WHERE USER_GAS = ? AND RESULTADO NOT IN ('Procedente', 'Improcedente', 'Contingencia','Finalizado por outro colaborador') ORDER BY DATA_ABERTURA ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, user.getLogin());
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }
                    
                    /*    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    if (email.getData_envio() != null){
                        email.setData_envio_s(dateFormat.format(email.getData_envio()));
                        contestacao.setEmail(email);
                    }if (email.getData_recebimento() != null){
                        email.setData_receb_s(dateFormat.format(email.getData_recebimento()));
                        contestacao.setEmail(email);
                    }*/
                    
                
                backlog.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return backlog;
    }

    public ArrayList<Contestacao> verificar_status(User user) throws ParseException {

        ArrayList<Contestacao> backlog = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        java.util.Date dataUtil = new java.util.Date();
        java.sql.Timestamp dataSql = new java.sql.Timestamp(dataUtil.getTime());
        String dataSql2 = dateFormat.format(dataSql.getTime() - 48000000);
        Date dataSql3 = dateFormat.parse(dataSql2);
        java.sql.Timestamp data_formatada = new java.sql.Timestamp(dataSql3.getTime());

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation WHERE \n"
                    + "\n"
                    + "(user_gas = ? AND (\n"
                    + "	(RESULTADO NOT IN ('Procedente', 'Improcedente', 'Contingencia','Finalizado por outro colaborador') AND data_alt < ?) \n"
                    + "		OR RESULTADO = 'Pendente')\n"
                    + ")\n"
                    + "\n"
                    + "ORDER BY DATA_ABERTURA;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, user.getLogin());
            pstmt.setTimestamp(2, data_formatada);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }

                backlog.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return backlog;
    }

    public Contestacao selecionar_equipe(String equipe) {

        Contestacao contestacao = new Contestacao();

        switch (equipe) {
            case "Canais Criticos - Abastece":
                contestacao.setEquipe("ABASTECE");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Estacione":
                contestacao.setEquipe("ESTACIONE");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Pedagio":
                contestacao.setEquipe("PEDÁGIO");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Multa por Evasao":
                contestacao.setEquipe("MULTA P/ EVASÃO");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Drive Thru":
                contestacao.setEquipe("RESTAURANTE");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Pagamento Indevido":
                contestacao.setEquipe("FINANCEIRO");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Tag Trocado":
                contestacao.setEquipe("TAG TROCADO");
                contestacao.setCanais_criticos(1);
                break;
            case "Canais Criticos - Vale Pedagio":
                contestacao.setEquipe("VALE PEDÁGIO");
                contestacao.setCanais_criticos(1);
                break;
            case "Estacione":
                contestacao.setEquipe("ESTACIONE");
                contestacao.setCanais_criticos(0);
                break;
            case "Abastece":
                contestacao.setEquipe("ABASTECE");
                contestacao.setCanais_criticos(0);
                break;
            case "Drive Thru":
                contestacao.setEquipe("RESTAURANTE");
                contestacao.setCanais_criticos(0);
                break;
            case "Multa por Evasao":
                contestacao.setEquipe("MULTA P/ EVASÃO");
                contestacao.setCanais_criticos(0);
                break;
            case "Pagamento Indevido":
                contestacao.setEquipe("FINANCEIRO");
                contestacao.setCanais_criticos(0);
                break;
            case "Taxas FCR":
                contestacao.setEquipe("Taxas FCR");
                break;
            case "Taxas B2B":
                contestacao.setEquipe("Taxas B2B");
                break;
            case "Transacoes Worklist":
                contestacao.setEquipe("PEDÁGIO");
                contestacao.setCanais_criticos(0);
                break;
            case "Priorizacao":
                contestacao.setEquipe("PRIORIZAÇÃO");
                contestacao.setCanais_criticos(0);
                break;
        }

        return contestacao;
    }

    public Contestacao selecionar_natureza(String natureza) {

        Contestacao natureza_financeiro = new Contestacao();

        switch (natureza) {
            case "COBRANCA INDEVIDA":
                natureza_financeiro.setNatureza("COBRANCA INDEVIDA");
                break;
            case "CONFIRMACAO DE DADOS BANCARIOS":
                natureza_financeiro.setNatureza("CONFIRMAÇÃO DE DADOS BANCÁRIOS");
                break;
            case "CREDITO A LIQUIDAR":
                natureza_financeiro.setNatureza("CREDITO A LIQUIDAR");
                break;
            case "DADOS PARA REEMBOLSO":
                natureza_financeiro.setNatureza("DADOS PARA REEMBOLSO");
                break;
            case "DEBITO CC - NAO CLIENTE":
                natureza_financeiro.setNatureza("DÉBITO C/C - NÃO CLIENTE");
                break;
            case "EFETUAR REEMBOLSO ORDEM DE PAGAMENTO":
                natureza_financeiro.setNatureza("EFETUAR REEMBOLSO ORDEM DE PAGAMENTO");
                break;
            case "ENVIAR COMPROVANTE REEMBOLSO":
                natureza_financeiro.setNatureza("ENVIAR COMPROVANTE REEMBOLSO");
                break;
            case "REEMBOLSO PGTO. A MAIOR":
                natureza_financeiro.setNatureza("REEMBOLSO PGTO. A MAIOR");
                break;
            case "REEMBOLSO PGTO. DUPLICIDADE":
                natureza_financeiro.setNatureza("REEMBOLSO PGTO. DUPLICIDADE");
                break;
            case "REEMBOLSO PGTO. INDEVIDO":
                natureza_financeiro.setNatureza("REEMBOLSO PGTO. INDEVIDO");
                break;
            case "REEMBOLSO SALDO DE CARTAO":
                natureza_financeiro.setNatureza("REEMBOLSO SALDO DE CARTÃO");
                break;
            case "REEMBOLSO SEDEX - INDENIZACAO":
                natureza_financeiro.setNatureza("REEMBOLSO SEDEX / INDENIZAÇÃO");
                break;
            case "REVERSAO PROCESSO DE CREDITO\"":
                natureza_financeiro.setNatureza("REVERSÃO PROCESSO DE CRÉDITO");
                break;
        }

        return natureza_financeiro;
    }

    public ArrayList<Contestacao> atribuir_financeiro(Contestacao natureza_financeiro, User user) {

        ArrayList<Contestacao> backlog_financeiro = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation CGAS_OC\n"
                    + "                     	\n"
                    + "					INNER JOIN CANT.dbo.CGAS_Demandas CGAS_DM\n"
                    + "                    ON CGAS_DM.EQUIPE = CGAS_OC.EQUIPE\n"
                    + "                     \n"
                    + "					WHERE CGAS_DM.NATUREZA = CGAS_OC.NATUREZA\n"
                    + "                    AND CGAS_DM.DEMANDA = ?\n"
                    + "					 \n"
                    + "					AND CGAS_OC.NRC = (\n"
                    + "                    SELECT TOP 1 NRC FROM CANT.gas.CGAS_Contestation CGAS_OC\n"
                    + "                     \n"
                    + "					INNER JOIN CANT.dbo.CGAS_Demandas CGAS_DM\n"
                    + "                    ON CGAS_DM.EQUIPE = CGAS_OC.EQUIPE\n"
                    + "                     \n"
                    + "					WHERE CGAS_DM.NATUREZA = CGAS_OC.NATUREZA\n"
                    + "                    AND CGAS_DM.DEMANDA = ?\n"
                    + "                    AND RESULTADO IS NULL)";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, natureza_financeiro.getNatureza());
            pstmt.setString(2, natureza_financeiro.getNatureza());

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }

                backlog_financeiro.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return backlog_financeiro;

    }

    public ArrayList<Contestacao> atribuir_taxasb2b() {

        ArrayList<Contestacao> list_taxas = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation OCORR \n"
                    + "WHERE\n"
                    + "(OCORR.EQUIPE = 'TAXAS' AND OCORR.tipo_pessoa = 'CNPJ') AND RESULTADO IS NULL	\n"
                    + "AND\n"
                    + "OCORR.NRC =                      					\n"
                    + "(SELECT TOP 1 OCORR.NRC \n"
                    + "FROM CANT.gas.CGAS_Contestation  OCORR WHERE    \n"
                    + "(OCORR.EQUIPE = 'TAXAS' AND OCORR.tipo_pessoa = 'CNPJ' AND RESULTADO IS NULL) ORDER BY OCORR.DATA_ABERTURA )                     					 	\n"
                    + "AND RESULTADO IS NULL\n"
                    + "ORDER BY OCORR.DATA_ABERTURA";
            pstmt = conexao.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }

                list_taxas.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return list_taxas;

    }

    public ArrayList<Contestacao> atribuir_taxasb2c() {

        ArrayList<Contestacao> list_taxas = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation OCORR \n"
                    + "WHERE\n"
                    + "(OCORR.EQUIPE = 'TAXAS' AND OCORR.tipo_pessoa = 'CPF') AND RESULTADO IS NULL	\n"
                    + "AND\n"
                    + "OCORR.NRC =                      					\n"
                    + "(SELECT TOP 1 OCORR.NRC \n"
                    + "FROM CANT.gas.CGAS_Contestation  OCORR WHERE    \n"
                    + "(OCORR.EQUIPE = 'TAXAS' AND OCORR.tipo_pessoa = 'CPF' AND RESULTADO IS NULL) ORDER BY OCORR.DATA_ABERTURA )                     					 	\n"
                    + "AND RESULTADO IS NULL\n"
                    + "ORDER BY OCORR.DATA_ABERTURA";
            pstmt = conexao.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }

                list_taxas.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return list_taxas;

    }

    public ArrayList<Contestacao> atribuir_contestacao(Contestacao equipe, User user) {

        ArrayList<Contestacao> list_contestacao = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "SELECT DISTINCT * FROM CANT.gas.CGAS_Contestation OCORR \n"
                    + "WHERE\n"
                    + "	OCORR.EQUIPE = ? AND OCORR.CANAIS_CRITICOS = ?	\n"
                    + "AND RESULTADO IS NULL\n"
                    + "AND OCORR.NRC = (SELECT TOP 1 OCORR.NRC FROM CANT.gas.CGAS_Contestation OCORR \n"
                    + "				WHERE \n"
                    + "				OCORR.EQUIPE = ? AND OCORR.CANAIS_CRITICOS = ? \n"
                    + "				AND RESULTADO IS NULL ) \n"
                    + "ORDER BY OCORR.DATA_ABERTURA";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, equipe.getEquipe());
            pstmt.setInt(2, equipe.getCanais_criticos());
            pstmt.setString(3, equipe.getEquipe());
            pstmt.setInt(4, equipe.getCanais_criticos());

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Contestacao contestacao = new Contestacao();

                contestacao.setTipo(rs.getString("TIPO"));
                contestacao.setNatureza(rs.getString("NATUREZA"));
                contestacao.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                contestacao.setDescricao(rs.getString("DESCRICAO"));
                contestacao.setQtd_itens(rs.getInt("QTD_ITENS"));
                contestacao.setValor_contestado(rs.getFloat("VLR_CONTESTADO"));
                contestacao.setLogin_abertura(rs.getString("LOGIN_ABERTURA"));
                contestacao.setNrc(rs.getString("NRC"));
                contestacao.setNome_cliente(rs.getString("NOME_CLIENTE"));
                contestacao.setTipo_pessoa(rs.getString("TIPO_PESSOA"));
                contestacao.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                contestacao.setData_abertura(rs.getDate("DATA_ABERTURA"));
                contestacao.setPosto_de_apoio(rs.getString("POSTO_APOIO"));
                contestacao.setEquipe(rs.getString("EQUIPE"));
                contestacao.setCanais_criticos(rs.getInt("CANAIS_CRITICOS"));
                contestacao.setStatus_cliente(rs.getString("STATUS_CLIENTE"));
                contestacao.setVencimento_fatura(rs.getString("VENCIMENTO_FATURA"));
                contestacao.setSaldo_balance(rs.getFloat("SALDO_BALANCE"));
                contestacao.setModo_pagamento(rs.getString("MODO_PAGAMENTO"));
                contestacao.setMsg(rs.getString("MSG"));
                contestacao.setLoja(rs.getString("LOJA"));
                contestacao.setFront(rs.getInt("FRONT"));
                contestacao.setResultado(rs.getString("RESULTADO"));
                
                Email email = new Email();
                email.setContestacao(contestacao);
                email.setData_envio(null);
                email.setData_recebimento(null);
                contestacao.setEmail(email);
                
                    String sql_email = "SELECT DISTINCT * FROM CANT.gas.CGAS_Email WHERE NUM_OCORRENCIA = ? ";
                    pstmt = conexao.prepareStatement(sql_email);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    ResultSet rs_email = pstmt.executeQuery();
                        
                    while (rs_email.next()) {
                        email.setData_envio(rs_email.getDate("dt_envio"));
                        email.setData_recebimento(rs_email.getDate("dt_recebido"));
                    contestacao.setEmail(email);
                    }

                list_contestacao.add(contestacao);

            }
        } catch (SQLException erro) {

        }
        return list_contestacao;

    }

    public void atualizar_contestacao(ArrayList<Contestacao> list_contestacao, User user) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        int i = 1;

        try {
            for (Contestacao contestacao : list_contestacao) {

                conexao = ConectaBanco.getConexao();

                String sql = "UPDATE CANT.gas.CGAS_Contestation SET RESULTADO = ?, USER_GAS = ? \n"
                        + "WHERE NUM_OCORRENCIA = ?;";
                pstmt = conexao.prepareStatement(sql);

                pstmt.setString(i, "Pendente");
                i = i + 1;
                pstmt.setString(i, user.getLogin());
                i = i + 1;
                pstmt.setString(i, contestacao.getNum_ocorrencia());

                pstmt.executeUpdate();

                i = 1;
            }

        } catch (SQLException erro) {

        }

    }

    public void inserir_resultado(Contestacao contestacao) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        java.util.Date dataUtil = new java.util.Date();
        java.sql.Timestamp dataSql = new java.sql.Timestamp(dataUtil.getTime());
        dateFormat.format(dataSql.getTime());

        try {

            conexao = ConectaBanco.getConexao();
            String sql = "UPDATE CANT.gas.CGAS_Contestation SET DATA_ALT = ?, RESULTADO = ?, FRONT = ?, LOJA = ?, MSG = ?, CONVENIADO = ?, PRACA = ? WHERE NUM_OCORRENCIA = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setTimestamp(1, dataSql);
            pstmt.setString(2, contestacao.getResultado());
            pstmt.setInt(3, contestacao.getFront());
            pstmt.setString(4, contestacao.getLoja());
            pstmt.setString(5, contestacao.getMsg());
            pstmt.setString(6, contestacao.getConveniado().getNome());
            pstmt.setString(7, contestacao.getConveniado().getPraca());
            pstmt.setString(8, contestacao.getNum_ocorrencia());
            pstmt.execute();
            
            if (contestacao.getEmail().getData_envio() != null) {

                PreparedStatement sql_email = conexao.prepareStatement("SELECT * FROM CANT.gas.CGAS_Email WHERE num_ocorrencia = ?");
                sql_email.setString(1, contestacao.getNum_ocorrencia());
                rs = sql_email.executeQuery();

                Email email = new Email();
                Contestacao ct = new Contestacao();

                while (rs.next()) {
                    ct.setNum_ocorrencia(rs.getString("NUM_OCORRENCIA"));
                    email.setContestacao(ct);
                }

                if (ct.getNum_ocorrencia() != null) {
                    
                    if(contestacao.getEmail().getData_envio() == null){
                    
                    String sql_update = "UPDATE CANT.gas.CGAS_Email SET dt_recebido = ? WHERE num_ocorrencia = ?";
                    pstmt = conexao.prepareStatement(sql_update);
  
                    Timestamp ts_recebido = new Timestamp(contestacao.getEmail().getData_recebimento().getTime());
                    pstmt.setTimestamp(1, ts_recebido);
                    pstmt.setString(2, contestacao.getNum_ocorrencia());
                    pstmt.execute();
                    
                    } else if (contestacao.getEmail().getData_recebimento() == null){
                    
                    String sql_update = "UPDATE CANT.gas.CGAS_Email SET dt_envio = ? WHERE num_ocorrencia = ?";
                    pstmt = conexao.prepareStatement(sql_update);
  
                    Timestamp ts_envio = new Timestamp(contestacao.getEmail().getData_envio().getTime());
                    pstmt.setTimestamp(1, ts_envio);
                    pstmt.setString(2, contestacao.getNum_ocorrencia());
                    pstmt.execute();    
                    
                    } else {
                    
                    String sql_update = "UPDATE CANT.gas.CGAS_Email SET dt_envio = ?, dt_recebido = ? WHERE num_ocorrencia = ?";
                    pstmt = conexao.prepareStatement(sql_update);
                    
                    Timestamp ts_envio = new Timestamp(contestacao.getEmail().getData_envio().getTime());
                    Timestamp ts_recebido = new Timestamp(contestacao.getEmail().getData_recebimento().getTime());

                    pstmt.setTimestamp(1, ts_envio);
                    pstmt.setTimestamp(2, ts_recebido);
                    pstmt.setString(3, contestacao.getNum_ocorrencia());
                    pstmt.execute();
                    
                    }
                } else {
                    
                     if(contestacao.getEmail().getData_envio() == null){
                    
                    String sql_insert = "INSERT INTO CANT.gas.CGAS_Email (num_ocorrencia, dt_recebido) VALUES (?, ?)";

                    Timestamp ts_recebido = new Timestamp(contestacao.getEmail().getData_recebimento().getTime());

                    pstmt = conexao.prepareStatement(sql_insert);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    pstmt.setTimestamp(2, ts_recebido);
                    pstmt.execute();
                    
                    } else if (contestacao.getEmail().getData_recebimento() == null){
                    
                    String sql_insert = "INSERT INTO CANT.gas.CGAS_Email (num_ocorrencia, dt_envio) VALUES (?, ?)";

                    Timestamp ts_envio = new Timestamp(contestacao.getEmail().getData_envio().getTime());

                    pstmt = conexao.prepareStatement(sql_insert);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    pstmt.setTimestamp(2, ts_envio);
                    pstmt.execute();
                    
                    }
                     
                     else {
                    
                    String sql_insert = "INSERT INTO CANT.gas.CGAS_Email (num_ocorrencia, dt_envio, dt_recebido) VALUES (?, ?, ?)";

                    Timestamp ts_envio = new Timestamp(contestacao.getEmail().getData_envio().getTime());
                    Timestamp ts_recebido = new Timestamp(contestacao.getEmail().getData_recebimento().getTime());

                    pstmt = conexao.prepareStatement(sql_insert);
                    pstmt.setString(1, contestacao.getNum_ocorrencia());
                    pstmt.setTimestamp(2, ts_envio);
                    pstmt.setTimestamp(3, ts_recebido);
                    pstmt.execute();
                     }
                }
            }

        } catch (SQLException erro) {

        }

    }
    
    public void designar_oc(User user_gas1, User user_gas2, Contestacao oc) throws SQLException{
                
        Connection conexao = ConectaBanco.getConexao();
        
        PreparedStatement sql = conexao.prepareStatement("UPDATE CANT.gas.CGAS_Contestation SET RESULTADO = ?, USER_GAS = ? WHERE NUM_OCORRENCIA = ?");
        sql.setString(1, "Pendente");
        sql.setString(2, user_gas2.getLogin());
        sql.setString(3, oc.getNum_ocorrencia());
        sql.execute();
        
        PreparedStatement pstmt = null;
                
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Timestamp dataSql = new java.sql.Timestamp(dataUtil.getTime());
        dateFormat.format(dataSql.getTime());
        
        String sql2 = "INSERT INTO CANT.dbo.CGAS_HistAtribuicao (NOME_GAS1, NOME_GAS2,  NUM_TAREFA, DATA_ALTERACAO) VALUES (?, ?, ?, ?)";      
        pstmt = conexao.prepareStatement(sql2);
        
        pstmt.setString(1, user_gas1.getLogin());
        pstmt.setString(2, user_gas2.getLogin());
        pstmt.setString(3, oc.getNum_ocorrencia());
        pstmt.setTimestamp(4, dataSql);
        pstmt.execute();
        
     }

}
