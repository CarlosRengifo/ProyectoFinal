/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos david
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
            throws ServletException, IOException {
        try {

            String stMensaje = "";

            if (request.getParameter("txtEmail").equals("")) {
                stMensaje += "Ingrese email,";

            }
            if (request.getParameter("txtPassword").equals("")) {
                stMensaje += "Ingrese password,";

            }
            if  (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 1));

            }
            //Instanciando objeto
            Models.ClsLogin obClsLogin = new Models.ClsLogin();
            //Asignando las propiedades
            obClsLogin.setStEmail(request.getParameter("txtEmail").toString());
            obClsLogin.setStPassword(request.getParameter("txtPassword").toString());
            
            //Instanciando controlador
            BL.clsLogin obBLclsLogin = new BL.clsLogin();
            
            //Invoco el método validarLogin
                    boolean blBandera = obBLclsLogin.validarLogin(obClsLogin);
                    if(blBandera)
                        //Direccionamiento JSP
                        request.getRequestDispatcher("Index.jsp").forward(request,response);
                    else
                        throw new Exception ("Email o password incorrectos");

        } catch (Exception ex) {
            //Envio de parametros o valores
            request.setAttribute("stError", ex.getMessage());
            //Direccionamiento JSP
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
