/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DAO.ContestacaoDAO;
import DAO.ConveniadoDAO;
import DAO.UserDAO;
import MODEL.Contestacao;
import MODEL.Conveniado;
import MODEL.Email;
import MODEL.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RENAN.SOUSA
 */
public class ControllerContestation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String txt_user = request.getParameter("txt_user");

            ConveniadoDAO conveniadoDAO = new ConveniadoDAO();
            
            User user = new User();
            user.setLogin(txt_user);
            UserDAO userDAO = new UserDAO();
            user = userDAO.consultar_user(user);

            if (request.getParameter("btn_logout") != null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            if (request.getParameter("btn_search") != null) {

                ArrayList<User> list_user = userDAO.listar_user();
                Contestacao contestacao = new Contestacao();
                ContestacaoDAO contestacaoDAO = new ContestacaoDAO();

                String txt_ocorrencia = request.getParameter("txt_ocorrencia");
                contestacao.setNum_ocorrencia(txt_ocorrencia);
                contestacao = contestacaoDAO.consultar_contestacao(contestacao);

                ArrayList<Conveniado> list_conveniado = conveniadoDAO.listar_conveniados();
                request.setAttribute("list_conveniado", list_conveniado);

                ArrayList<String> list_loja = contestacaoDAO.listar_lojas();
                request.setAttribute("list_loja", list_loja);

                request.setAttribute("list_user", list_user);
                request.setAttribute("user", user);
                request.setAttribute("ct_search", contestacao);
                request.getRequestDispatcher("search_contestacao.jsp").forward(request, response);
            }
            
            if (request.getParameter("btn_assignuser") != null) {

                ArrayList<User> list_user = userDAO.listar_user();

                request.setAttribute("list_user", list_user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("atribuir.jsp").forward(request, response);
            }
            
            if(request.getParameter("btn_atribuir") != null){
   
            String list_user = request.getParameter("list_user");
            User user_assign = new User();
         
            user_assign.setNome(list_user);
            user_assign = userDAO.consultar_user_nome(user_assign);
         
            String txt_oc_at = request.getParameter("txt_oc_atribuida");
            Contestacao ct_assign = new Contestacao();
            ct_assign.setNum_ocorrencia(txt_oc_at);       
            
            ContestacaoDAO cDAO = new ContestacaoDAO();
         
            cDAO.designar_oc(user, user_assign, ct_assign);
         
            request.setAttribute("user", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
            }

            if (request.getParameter("btn_error") != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("report_erros.jsp").forward(request, response);
            }
            
            if (request.getParameter("btn_exporterro") != null) {
                request.setAttribute("user", user);
                
                request.getRequestDispatcher("report_erros.jsp").forward(request, response);
            }

            if (request.getParameter("btn_load") != null) {
                ContestacaoDAO contestacaoDAO = new ContestacaoDAO();
                contestacaoDAO.carregar_contestacao();
                request.setAttribute("user", user);
                request.getRequestDispatcher("base_carregada.jsp").forward(request, response);
            }

            if (request.getParameter("btn_assign") != null) {

                String celula = request.getParameter("txt_celula");
                String natureza = request.getParameter("txt_natureza");
                ContestacaoDAO contestacaoDAO = new ContestacaoDAO();

                ArrayList<Conveniado> list_conveniado = conveniadoDAO.listar_conveniados();
                request.setAttribute("list_conveniado", list_conveniado);

                ArrayList<String> list_loja = contestacaoDAO.listar_lojas();
                request.setAttribute("list_loja", list_loja);

                ArrayList<Contestacao> contestacaoes_pendentes = new ContestacaoDAO().verificar_pendencias(user);

                if (contestacaoes_pendentes.size() > 0) {

                    request.setAttribute("list_contestacao", contestacaoes_pendentes);
                    request.setAttribute("user", user);
                    request.setAttribute("celula", celula);
                    request.setAttribute("natureza", natureza);
                    request.getRequestDispatcher("contestacao.jsp").forward(request, response);

                } else {

                    Contestacao equipe = new ContestacaoDAO().selecionar_equipe(celula);

                    if (natureza != null) {

                        Contestacao natureza_financeiro = new ContestacaoDAO().selecionar_natureza(natureza);
                        ArrayList<Contestacao> list_financeiro = new ContestacaoDAO().atribuir_financeiro(natureza_financeiro, user);
                        contestacaoDAO.atualizar_contestacao(list_financeiro, user);

                        if (list_financeiro.size() > 0) {

                            request.setAttribute("list_contestacao", list_financeiro);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);

                        } else {

                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);

                        }
                    }
                    if (celula.equals("Taxas B2B")) {

                        ArrayList<Contestacao> list_taxasb2b = new ContestacaoDAO().atribuir_taxasb2b();
                        contestacaoDAO.atualizar_contestacao(list_taxasb2b, user);

                        if (list_taxasb2b.size() > 0) {
                            
                            request.setAttribute("list_contestacao", list_taxasb2b);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
                            
                        } else {
                            
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                            
                        }

                    } else if (celula.equals("Taxas FCR")) {

                        ArrayList<Contestacao> list_taxasb2c = new ContestacaoDAO().atribuir_taxasb2c();
                        contestacaoDAO.atualizar_contestacao(list_taxasb2c, user);

                        if (list_taxasb2c.size() > 0) {
                            
                            request.setAttribute("list_contestacao", list_taxasb2c);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
 
                        } else {
                            
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                        }

                    } else if (natureza == null) {

                        ArrayList<Contestacao> list_contestacao = new ContestacaoDAO().atribuir_contestacao(equipe, user);
                        contestacaoDAO.atualizar_contestacao(list_contestacao, user);

                        if (list_contestacao.size() > 0) {
                            request.setAttribute("list_contestacao", list_contestacao);
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
                        } else {
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("celula", celula);
                        request.setAttribute("user", user);
                        request.setAttribute("natureza", natureza);
                        request.getRequestDispatcher("info.jsp").forward(request, response);
                    }

                }

            }

            String list_resultado2 = null;

            if (request.getParameter("btn_procedente") != null) {
                String list_resultado = "PROCEDENTE";
                list_resultado2 = list_resultado;
            } else if (request.getParameter("btn_improcedente") != null) {
                String list_resultado = "IMPROCEDENTE";
                list_resultado2 = list_resultado;
            } else if (request.getParameter("btn_enviar") != null) {
                String list_resultado = request.getParameter("list_resultado");
                list_resultado2 = list_resultado;
            } else {
            }
            
            boolean ct_search = false;
            
            if (request.getParameter("btn_procedente_sc") != null) {
                String list_resultado = "PROCEDENTE";
                list_resultado2 = list_resultado;
                ct_search = true;
            } else if (request.getParameter("btn_improcedente_sc") != null) {
                String list_resultado = "IMPROCEDENTE";
                list_resultado2 = list_resultado;
                ct_search = true;
            } else if (request.getParameter("btn_enviar_sc") != null) {
                String list_resultado = request.getParameter("list_resultado");
                list_resultado2 = list_resultado;
                ct_search = true;
            } else {
            }
            
            
            String celula = request.getParameter("txt_celula");
            String natureza = request.getParameter("txt_natureza");
            
            String ocorrencia = request.getParameter("txt_ocorrencia");
            String msg = request.getParameter("txt_msg");
            
            String conveniado = request.getParameter("list_conveniado");
            String praca = request.getParameter("praca");
            
            Conveniado conv = new Conveniado();
            conv.setNome(conveniado);
            conv.setPraca(praca);
            
            String loja = request.getParameter("list_loja");
            int front = 0;
            String front_s = request.getParameter("txt_front");
            if (front_s != (null)){
            front = Integer.parseInt(front_s);
            }
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String dt_envio = request.getParameter("txt_dataenvio");
            String dt_recebido = request.getParameter("txt_datareceb");
            
            java.util.Date data_env_d = null;
            
            if (dt_envio.equals("")){
            } else {data_env_d = formato.parse(dt_envio);            
            }
            
            java.util.Date data_receb_d = null;
            
            if (dt_recebido.equals("")){
            } else {data_receb_d = formato.parse(dt_recebido);            
            }
            
            
            Email email = new Email();  
            email.setData_envio(data_env_d);
            email.setData_recebimento(data_receb_d);
                
            Contestacao contestacao = new Contestacao();

            contestacao.setNum_ocorrencia(ocorrencia);
            contestacao.setUser(user);
            contestacao.setResultado(list_resultado2);
            contestacao.setMsg(msg);
            contestacao.setConveniado(conv);
            contestacao.setLoja(loja);
            contestacao.setFront(front);
            contestacao.setEmail(email);
            
            ContestacaoDAO cDAO = new ContestacaoDAO();
            if (list_resultado2 != null){
            cDAO.inserir_resultado(contestacao);           
            }
            
            if (ct_search == true){
            request.setAttribute("user", user);
             request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            
            
            ArrayList<Conveniado> list_conveniado = conveniadoDAO.listar_conveniados();
                request.setAttribute("list_conveniado", list_conveniado);

                ArrayList<String> list_loja = cDAO.listar_lojas();
                request.setAttribute("list_loja", list_loja);

                ArrayList<Contestacao> contestacaoes_pendentes = new ContestacaoDAO().verificar_status(user);

                if (contestacaoes_pendentes.size() > 0) {

                    request.setAttribute("list_contestacao", contestacaoes_pendentes);
                    request.setAttribute("user", user);
                    request.setAttribute("celula", celula);
                    request.setAttribute("natureza", natureza);
                    request.getRequestDispatcher("contestacao.jsp").forward(request, response);

                } else {

                    Contestacao equipe = new ContestacaoDAO().selecionar_equipe(celula);

                    if (!"null".equals(natureza)) {

                        Contestacao natureza_financeiro = new ContestacaoDAO().selecionar_natureza(natureza);
                        ArrayList<Contestacao> list_financeiro = new ContestacaoDAO().atribuir_financeiro(natureza_financeiro, user);
                        cDAO.atualizar_contestacao(list_financeiro, user);

                        if (list_financeiro.size() > 0) {

                            request.setAttribute("list_contestacao", list_financeiro);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);

                        } else {

                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);

                        }
                    }
                    if (celula.equals("Taxas B2B")) {

                        ArrayList<Contestacao> list_taxasb2b = new ContestacaoDAO().atribuir_taxasb2b();
                        cDAO.atualizar_contestacao(list_taxasb2b, user);

                        if (list_taxasb2b.size() > 0) {
                            
                            request.setAttribute("list_contestacao", list_taxasb2b);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
                            
                        } else {
                            
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                            
                        }

                    } else if (celula.equals("Taxas FCR")) {

                        ArrayList<Contestacao> list_taxasb2c = new ContestacaoDAO().atribuir_taxasb2c();
                        cDAO.atualizar_contestacao(list_taxasb2c, user);

                        if (list_taxasb2c.size() > 0) {
                            
                            request.setAttribute("list_contestacao", list_taxasb2c);
                            request.setAttribute("user", user);
                            request.setAttribute("celula", celula);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
 
                        } else {
                            
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                        }

                    } else if ("null".equals(natureza)) {

                        ArrayList<Contestacao> list_contestacao = new ContestacaoDAO().atribuir_contestacao(equipe, user);
                        cDAO.atualizar_contestacao(list_contestacao, user);

                        if (list_contestacao.size() > 0) {
                            request.setAttribute("list_contestacao", list_contestacao);
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("contestacao.jsp").forward(request, response);
                        } else {
                            request.setAttribute("celula", celula);
                            request.setAttribute("user", user);
                            request.setAttribute("natureza", natureza);
                            request.getRequestDispatcher("info.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("celula", celula);
                        request.setAttribute("user", user);
                        request.setAttribute("natureza", natureza);
                        request.getRequestDispatcher("info.jsp").forward(request, response);
                    }

                }
            
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ControllerContestation.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerContestation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ControllerContestation.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerContestation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
