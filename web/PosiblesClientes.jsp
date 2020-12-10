<%-- 
    Document   : PosiblesClientes
    Created on : 5/12/2020, 01:42:00 AM
    Author     : carlos david
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Posibles Clientes</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <link href="css/sweetalert.css" rel="stylesheet"/>
        <script src="js/sweetalert.min.js" type="text/javascript"/> </script>


</head>
<body>
    <%
        Models.clsPosiblesClientes ObclsPosiblesClientes = new Models.clsPosiblesClientes();
        
        if(request.getAttribute("ObclsPosiblesClientes") !=null){
            ObclsPosiblesClientes = (Models.clsPosiblesClientes)  request.getAttribute("ObclsPosiblesClientes");
        }
                
        List<Models.clsPosiblesClientes> lstclsPosiblesClientes = 
                new ArrayList<Models.clsPosiblesClientes>();

        //EXISTENCIA DE LA VARIABLE DE SESSION
        if (session.getAttribute("session_lstclsPosiblesClientes") != null) {

            //CASTING PARA DARLE UN TIPO DE DATO A LA VARIABLE DE SESSION 
            lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");

        }
        if (request.getAttribute("stMensaje") != null
                && request.getAttribute("stTipo") != null) {


    %>
    <input type="text" hidden="" id="txtMensaje"
           value="<%= request.getAttribute("stMensaje")%>" />
    <input type="text" hidden="" id="txtTipo"
           value="<%= request.getAttribute("stTipo")%>" />

    <script>
        var mensaje = document.getElementById("txtMensaje").value;
        var tipo = document.getElementById("txtTipo").value;

        swal("Mensaje", mensaje, tipo);


    </script>
    <%
        }

    %>
    <div class="container">
        <div class="card mx-auto mt-5">
            <div class="card-header"> Crear Posibles Clientes </div>
            <div class="card-body">
                <form action="PosiblesClientesControllers" method="POST">
                    <!--FILA-->
                    <div class="form-group">
                        <div class="form-row">
                            <!--COLUMNA-->
                            <div class="col-md-6">
                                <input type="submit" value="Guardar" class="btn btn-primary" 
                                       name="btnGuardar"/>
                                <input type="submit" value="Modificar" class="btn btn-primary" 
                                       name="btnModificar"/>
                                <input type="submit" value="Cancelar"  class="btn btn-primary" 
                                       name="btnCancelar"/>

                                <a class="btn btn-primary" href="Index.jsp">Volver</a>



                            </div>

                        </div>

                    </div>
                    <!--FILA-->
                    <div class="form-group">
                        <div class="form-row">
                            <h1>  Información de Posible cliente </h1>
                        </div>

                    </div>
                    <!--FILA-->
                    <div class="form-group">
                        <div class form-row>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblEmpresa">Empresa</label>
                                <input type="text" placeholder="Empresa" 
                                       name="txtEmpresa" 
                                       class="form-control" 
                                       value="<%=ObclsPosiblesClientes.getStEmpresa() !=null ? ObclsPosiblesClientes.getStEmpresa(): ""%>"/>
                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblNombre">Nombre</label>
                                <input type="text" placeholder="Nombre" 
                                       name="txtNombre"
                                       class="form-control" 
                                        value="<%=ObclsPosiblesClientes.getStEmpresa() !=null ? ObclsPosiblesClientes.getStEmpresa(): ""%>"/>

                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblApellidos">Apellidos</label>
                                <input type="text" placeholder="Apellidos" 
                                       name="txtApellidos" 
                                       class="form-control" />
                                          
                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblTitulo">Titulo</label>
                                <input type="text" placeholder="Titulo" 
                                       name="txtTitulo"
                                       class="form-control"  />

                            </div>

                        </div>
                    </div>
                    <!--FILA-->
                    <div class="form-group">
                        <div class form-row>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblCorreoElectronico">CorreoElectronico</label>
                                <input type="email" placeholder="CorreoElectronico" 
                                       name="txtCorreoElectronico" 
                                       class="form-control" />
                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblTelefono">Telefono</label>
                                <input type="text" placeholder="Telefono" 
                                       name="txtTelefono" 
                                       class="form-control" />

                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblFax">Fax</label>
                                <input type="text" placeholder="Fax" 
                                       name="txtFax" 
                                       class="form-control" />

                            </div>
                            <!--COLUMNA-->

                            <div class="col-md-3">
                                <label name="lblMovil">Movil</label>
                                <input type="text" placeholder="Movil" 
                                       name="txtMovil" 
                                       class="form-control" />

                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class form-row>

                            <div class="col-md-3">
                                <label name="lblSitioWeb">Sitio web</label>
                                <input type="text" placeholder="SitioWeb" 
                                       name="txtSitioWeb" 
                                       class="form-control" />
                            </div>


                            <div class="col-md-3">
                                <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                <select class="form-control" name="ddlFuentePosibleCliente">
                                    <option value="1">Ninguno</option>
                                    <option value="2">Aviso</option>
                                    <option value="3">Llamada no solicitada</option>
                                    <option value="4">Recomendación de empleado</option>
                                    <option value="5">Recomendación externa</option>
                                    <option value="6">Tienda en linea</option>


                                </select>
                            </div>


                            <div class="col-md-3">
                                <label name="lblEstadoPosibleCliente">Estado de posible cliente</label>
                                <select class="form-control" name="ddlEstadoPosibleCliente">

                                    <option value="1">Ninguno</option>
                                    <option value="2">Intento de contacto</option>
                                    <option value="3">Contactar en el futuro</option>
                                    <option value="4">Contactado</option>
                                    <option value="5">Posible cliente no solicitado</option>
                                    <option value="6">Posible cliente perdido </option>

                                </select>

                            </div>


                            <div class="cold-md-3">
                                <label name="lblSector">Sector</label>
                                <select class="form-control" name="ddlSector">

                                    <option value="1">Ninguno</option>
                                    <option value="2">APS(Proveedor de servicios de aplicaciones)</option>
                                    <option value="3">OEM de datos</option>
                                    <option value="4">ERP(Planificación de recursos de empresa)</option>
                                    <option value="5">Gobierno/Ejercito</option>
                                    <option value="6">Empresa grande </option>
                                </select>

                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class form-row>

                            <div class="col-md-3">
                                <label name="lblCantidadEmpleados">Cantidad de empleados</label>
                                <input type="number" placeholder="CantidadEmpleados" 
                                       name="txtCantidadEmpleados" 
                                       class="form-control" />
                            </div>


                            <div class="col-md-3">
                                <label name="lblIngresosAnuales">Ingresos Anuales</label>
                                <input type="number" placeholder="IngresosAnuales"
                                       name="txtIngresosAnuales" 
                                       class="form-control" />


                            </div>


                            <div class="col-md-3">
                                <label name="lblCalificacion">Calificacion</label>
                                <select class="form-control" name="ddlCalificacion">

                                    <option value="1">Ninguna</option>
                                    <option value="2">Adquirido</option>
                                    <option value="3">Activo</option>
                                    <option value="4">Contactado</option>
                                    <option value="5">Fallo de mercado</option>
                                    <option value="6">Proyecto cancelado </option>
                                    <option value="7">Apagar </option>

                                </select>

                            </div>


                            <div class="cold-md-3">
                                <br>
                                <label name="lblNoparticipacioncorreoElectronico">
                                    <input  type="checkbox" class="form-control" name="chkNoparticipacioncorreoElectronico"/>
                                    No participacion correo electronico
                                </label>


                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class form-row>

                            <div class="col-md-3">
                                <label name="lblIDSkype">ID de Skype</label>
                                <input type="text" placeholder="ID de Skype" 
                                       name="txtIDSkype" 
                                       class="form-control" />
                            </div>


                            <div class="col-md-3">
                                <label name="lblTwitter">Ingresos Anuales</label>
                                <input type="text" placeholder="Twitter" 
                                       name="txtTwitter" 
                                       class="form-control" />


                            </div>


                            <div class="col-md-6">
                                <label name="lblCalificacion">Correo electronico secundario</label>
                                <input type="text" placeholder="Correoelectronicosecundario" 
                                       name="txtCorreoelectronicosecundario" 
                                       class="form-control" />


                            </div>


                        </div>
                    </div>
                     <!-- FILA -->
                    <div class="form-group"> 
                        <div class="form-row"> 
                            <!--COLUMNA-->
                            <div class="col-12">
                                <b>
                                    <i class="fa fa-clipboard"></i>
                                Registros: <%= lstclsPosiblesClientes.size()%>
                                </b>
                            </div>
                            
                        </div>
                        
                    </div>
                                    


                    <!-- FILA -->
                    <div class="form-group"> 
                        <div class="form-row"> 
                            <!--COLUMNA-->
                            <div class="col-12">
                                <table class="table table-bordered table-primary table-responsive">
                                    <!--FILA-->
                                    <tr>
                                        <!--COLUMNA-->
                                        <td>Empresa</td>
                                        <td>Nombre</td>
                                        <td>Apellidos</td>
                                        <td>Titulo</td>
                                        <td>Correoelectronico</td>
                                        <td>Telefono</td>
                                        <td>Fax</td>
                                        <td>Movil</td>
                                        <td>SitioWeb</td>
                                        <td>Fuente Posible Cliente</td>
                                        <td>Sector</td>
                                        <td>Cantidad de empleados</td>
                                        <td>Ingresos anuales</td>
                                        <td>Calificacion</td>
                                        <td>No participacion correo electronico</td>
                                        <td>ID de Skype</td>
                                        <td>Twitter</td>
                                        <td>Correo electronico secundario</td>



                                    </tr>

                                    <%                                        
                                            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                                            Models.clsFuentePosibleCliente obcFuentePosibleCliente = item.getObclsFuentePosibleCliente();
                                            Models.clsEstadoPosibleCliente obcEstadoPosibleCliente = item.getObclsEstadoPosibleCliente();
                                            Models.clsSector obcSector = item.getObclsSector();
                                            Models.clsCalificacion obcCalificacion = item.getObclsCalificacion();


                                    %>    
                                    <tr>
                                        <td><%= item.getStEmpresa()%></td>
                                        <td> <%= item.getStNombre()%></td>
                                        <td><%= item.getStApellidos()%></td>
                                        <td><%= item.getStTitulo()%></td>
                                        <td><%= item.getStCorreoelectronico()%></td>
                                        <td><%= item.getStTelefono()%></td>
                                        <td><%= item.getStFax()%></td>
                                        <td><%= item.getStMovil()%></td>
                                        <td><%= item.getStSitioWeb()%></td>
                                        <td> <%= obcFuentePosibleCliente.getStDescripcion()%> </td>
                                        <td><%= obcEstadoPosibleCliente.getStDescripcion()%></td>
                                        <td><%= obcSector.getStDescripcion()%> </td>
                                        <td><%= item.getInCantidadEmpleados()%> </td>
                                        <td><%= item.getDbIngresosAnuales()%></td>
                                        <td> <%= obcCalificacion.getStDescripcion()%>  </td>
                                        <td> <%= item.getChNoparticipacioncorreoelectronico()%> </td>
                                        <td><%= item.getStIdSkype()%></td>
                                        <td><%= item.getStTwitter()%>  </td>
                                        <td><%= item.getStcorreoelectronicosecundario()%>  </td>
                                        
                                        <td>
                                            <a class="btn btn-success btn-sm"
                                               href="PosiblesClientesControllers?stOpcion=M&codigoSeleccionado=<%= item.getInCodigo() %>">
                                                Modificar</a>
                                                 <a class="btn-danger btn-sm"
                                               href="PosiblesClientesControllers?stOpcion=E&codigoSeleccionado=<%= item.getInCodigo() %>">
                                                Eliminar</a>
                                                
                                            
                                            </a>
                                            
                                        </td>

                                    </tr>

                                    <%

                                        }
                                    %>


                                </table>

                            </div>


                        </div>

                    </div>

                </form>

            </div>
        </div>

    </div>
</body>
</html>
