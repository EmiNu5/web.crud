package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Persona;
import modeloDAO.interfazPersonaDAO;
import modeloDAO.modeloDAO;

public class Controlador extends HttpServlet {

    modeloDAO dao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        List<Persona> personas = null;
        switch (accion){
            case "listar":
                dao = new modeloDAO();  
                personas= dao.getPersonas();
                request.setAttribute("Personas", personas);//Captura en JSP con el nombre Personas y se le pasa la variable personas
                request.getRequestDispatcher("index.jsp").forward(request,response);//que se muestre en html la lista
                break;
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request,response);
                break;
            case "Agregar":
                int  r=0;//resultado
                String nombre=request.getParameter("textNombre");
                String apellido=request.getParameter("textApellido");
                String correo=request.getParameter("textCorreo");
                Persona p = new Persona ();
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setCorreo(correo);
                r = dao.add(p);
                if(r!=0){
                    request.setAttribute("config","alert alert-success");
                    request.setAttribute("mensaje","Se agregó con éxito!!");
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);
                }else{
                    request.setAttribute("config","alert alert-danger");
                    request.setAttribute("mensaje","Dale McFly!!!");                     
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);                   
                }
                break;
            case "Editar":
                int id = Integer.valueOf(request.getParameter("id"));//obtenemos el id que nos pedie como parrametro
                Persona persona=dao.getId(id);
                request.setAttribute("persona", persona);   
                request.getRequestDispatcher("editar.jsp").forward(request,response);
                break;
            case "Actualizar":
                String nombre1=request.getParameter("textNombre");
                String apellido1=request.getParameter("textApellido");
                String correo1=request.getParameter("textCorreo");
                int idPersona1 =Integer.valueOf(request.getParameter("textIdPersona"));
                Persona per = new Persona(idPersona1,nombre1,apellido1,correo1);
                int respuesta = dao.update(per);
                if(respuesta!=0){
                    request.setAttribute("config","alert alert-success");
                    request.setAttribute("mensaje","Se actualizó con éxito!!");
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);
                }else{
                    request.setAttribute("config","alert alert-danger");
                    request.setAttribute("mensaje","Daleeee!!!");                     
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);                   
                }
                break;
            case "Delete":
                int id2 = Integer.valueOf(request.getParameter("id"));//obtenemos el id que nos pedie como parrametro
                int res2 = dao.delete(id2);               
                if(res2!=0){
                    request.setAttribute("config","alert alert-warning");
                    request.setAttribute("mensaje","Hasta la vista baby");
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);
                }else{
                    request.setAttribute("config","alert alert-danger");
                    request.setAttribute("mensaje","Error inesperatu");                     
                    request.getRequestDispatcher("mensaje.jsp").forward(request,response);                   
                }

                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
