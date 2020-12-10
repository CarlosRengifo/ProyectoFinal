/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carlos david
 */
@WebServlet(name = "PosiblesClientesControllers", urlPatterns = {"/PosiblesClientesControllers"})
public class PosiblesClientesControllers extends HttpServlet {

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
        //VALIDAMOS QUE SE HAYA PRESIONADO EL BOTON DE GUARDAR
        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnModificar") != null) {

        } else if (request.getParameter("btnCancelar") != null) {

        }else if (request.getParameter ("codigoSeleccionado")!=null){
            if (request.getParameter("stOpcion") .equals("M")){
                cargarModificar(request, response);
                
            }else if  (request.getParameter("stOpcion") .equals("E")) {
                
            }
        }
           
    }
    
    public void cargarModificar(HttpServletRequest request, 
        HttpServletResponse response) throws IOException,ServletException{
        try{
            
        }catch (Exception ex ) {
            
            
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            //DEFINICION DE MODELOS
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
            //ASIGNACION DE ATRIBUTOS O PROPIEDADES 

            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));

            }

            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));

            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));

            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));

            }
            if (request.getParameter("txtCorreoelectronico") != null) {
                obclsPosiblesClientes.setStCorreoelectronico(request.getParameter("txtCorreoelectronico"));

            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));

            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));

            }
            if (request.getParameter("txtSitioWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtSitioWeb"));

            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //MODELO HIJO
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                String stDescripcion = "";
                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";

                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    stDescripcion = "Aviso";

                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    stDescripcion = "Llamada no solicitada";

                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    stDescripcion = "Recomendacion de empleado";

                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    stDescripcion = "Recomendacion externa";

                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    stDescripcion = "Tienda en linea";
                }

                obclsFuentePosibleCliente.setStDescripcion(stDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);

            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                //MODELO HIJO
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                String stDescripcion = "";
                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    stDescripcion = "Ninguno";

                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    stDescripcion = "Intento de contacto";

                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    stDescripcion = "Contactar en el futuro";

                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    stDescripcion = "Contactado";

                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    stDescripcion = "Posible cliente no solicitado";

                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    stDescripcion = "Posible cliente perdido";
                }

                obclsEstadoPosibleCliente.setStDescripcion(stDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);

            }

            if (request.getParameter("ddlSector") != null) {
                //MODELO HIJO
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                String stDescripcion = "";
                if (request.getParameter("ddlSector").equals("1")) {
                    stDescripcion = "Ninguno";

                } else if (request.getParameter("ddlSector").equals("2")) {
                    stDescripcion = "  APS(Proveedor de servicios de aplicaciones)";

                } else if (request.getParameter("ddlSector").equals("3")) {
                    stDescripcion = " OEM de datos  ";

                } else if (request.getParameter("ddlSector").equals("4")) {
                    stDescripcion = "ERP(Planificación de recursos de empresa)";

                } else if (request.getParameter("ddlSector").equals("5")) {
                    stDescripcion = " Gobierno/Ejercito  ";

                } else if (request.getParameter("ddlSector").equals("6")) {
                    stDescripcion = "Empresa grande  ";
                }

                obclsSector.setStDescripcion(stDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsSector(obclsSector);

            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }

            if (request.getParameter("txtIngresosAnuales") != null) {
                obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }

            if (request.getParameter("ddlCalificacion") != null) {
                //MODELO HIJO
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                String stDescripcion = "";
                if (request.getParameter("ddlCalificacion").equals("1")) {
                    stDescripcion = "Ninguna";

                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    stDescripcion = " Adquirido ";

                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    stDescripcion = "  Activo";

                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    stDescripcion = "Contactado";

                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    stDescripcion = " Fallo de mercado";

                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    stDescripcion = " Proyecto cancelado ";
                } else if (request.getParameter("ddlCalificacion").equals("7")) {
                    stDescripcion = " Apagar  ";
                }

                obclsCalificacion.setStDescripcion(stDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);

            }
            if (request.getParameter("chkNoparticipacioncorreoElectronico") != null) {
                char chSeleccion = request.getParameter("chkNoparticipacioncorreoElectronico").equals("on")
                        ? 'S' : 'N';
                obclsPosiblesClientes.setBlNoparticipacioncorreoelectronico(chSeleccion);

            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIdSkype(request.getParameter("txtIDSkype"));
            }

            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }

            if (request.getParameter("txtCorreoelectronicosecundario") != null) {
                obclsPosiblesClientes.setStCorreoelectronico(request.getParameter("txtCorreoelectronicosecundario"));
            }

            HttpSession session = request.getSession(true);

            // lISTA DE OBJETOS
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = 
                    new ArrayList<Models.clsPosiblesClientes>();

            //VALIDAMOS PREVIA EXISTENCIA DE LA VARIABLE DE SESSION 
            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) 
                        session.getAttribute("session_lstclsPosiblesClientes");

            }
            //PARA CALCULO AUTOMATICO QUE IDENTIFICA ESE REGISTRO
            int inCodigo = lstclsPosiblesClientes.size() + 1;
            obclsPosiblesClientes.setInCodigo(inCodigo);
            //AGREGAMOS EL OBJETO A LA LISTA 
            lstclsPosiblesClientes.add(obclsPosiblesClientes);
            //CREAMOS LA VARIABLE DE SESSION
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);

            //DEFINIR PARAMETROS DESDE EL CONTROLADOR 
            request.setAttribute("stMensaje", "Se realizó proceso con éxito");
            request.setAttribute("stTipo", "success");

            //REDIRECCIONO Y ENVIO LOS VALORES 
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            //DEFINIR PARAMETROS DESDE EL CONTROLADOR 
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //REDIRECCIONO Y ENVIO LOS VALORES 
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        }

    }
}
