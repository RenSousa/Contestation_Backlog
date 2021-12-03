/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DAO.UserDAO;
import MODEL.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author renan.sousa
 */
public class ControllerUser extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String txt_login = request.getParameter("txt_login");
            String txt_senha = request.getParameter("txt_senha");
            
            User user = new User();
            UserDAO userDAO = new UserDAO();
            
            if (request.getParameter("btn_entrar") != null) {
            
            user.setLogin(txt_login);
            user.setSenha(txt_senha);
                        
            boolean validado = userDAO.validar_user(user);
            
            if (validado == true) {
                
                user = userDAO.consultar_user(user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                
            } else {
            
                request.setAttribute("msg", "Usuário ou Senha inválidos!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            
            }
            
            if (request.getParameter("btn_cadastrar") != null) {
                request.getRequestDispatcher("cadastrar_user.jsp").forward(request, response);
            }
            
            if (request.getParameter("btn_cadastraruser") != null) {
                
                txt_login = request.getParameter("txt_login");
                txt_senha = request.getParameter("txt_senha");
                String txt_nome  = request.getParameter("txt_nome");
                String txt_email = request.getParameter("txt_email");
                
                user.setLogin(txt_login);
                user.setSenha(txt_senha);
                user.setNome(txt_nome);
                user.setEmail(txt_email);
                
                userDAO.cadastrar_user(user);
                request.setAttribute("msg", "Usuário cadastrado com sucesso!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                                                
            }
            
            if (request.getParameter("btn_alterarsenha") != null) {
                request.getRequestDispatcher("alterarsenha_user.jsp").forward(request, response);
            }
            
            if (request.getParameter("btn_alterarsenhauser") != null) {
                
                txt_login = request.getParameter("txt_login");
                user.setLogin(txt_login);
                
                user = userDAO.consultar_user(user);
                
                txt_senha = request.getParameter("txt_senha");
                user.setSenha(txt_senha);
                
                userDAO.alterar_user(user);
                request.setAttribute("msg", "Senha alterada!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                                                
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
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
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
