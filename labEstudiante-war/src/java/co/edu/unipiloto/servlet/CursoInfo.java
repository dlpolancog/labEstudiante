/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.estudiante.entity.Curso;
import co.edu.unipiloto.estudiante.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpol
 */

public class CursoInfo extends HttpServlet {
    
    @EJB
    private CursoFacadeLocal cursoFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String nombreCurso = request.getParameter("nombreCurso");
            String codigoCursoStr = request.getParameter("codigoCurso");
            String numeroCreditosStr = request.getParameter("numeroCreditos");
            String semestreStr = request.getParameter("semestre");
            String estudiantesAdmitidosStr = request.getParameter("estudiantesAdmitidos");
            Integer codigoCurso=0;
            Integer semestre=0;
            Integer numeroCreditos=0;
            Integer estudiantesAdmitidos=0;
            
            if (codigoCursoStr != null && !codigoCursoStr.equals("")) {
                codigoCurso = Integer.parseInt(codigoCursoStr);
            }
            if (numeroCreditosStr != null && !numeroCreditosStr.equals("")) {
                numeroCreditos = Integer.parseInt(numeroCreditosStr);
            }
            if (semestreStr != null && !semestreStr.equals("")) {
                semestre = Integer.parseInt(semestreStr);
            }
            if (estudiantesAdmitidosStr != null && !estudiantesAdmitidosStr.equals("")) {
                estudiantesAdmitidos = Integer.parseInt(estudiantesAdmitidosStr);
            }
            
            Curso cursoinf = new Curso (codigoCurso, nombreCurso, semestre, estudiantesAdmitidos,numeroCreditos);
            
            if (action.equals("Add")) {
                cursoFacade.create(cursoinf);
            } else if (action.equals("Search")) {
                cursoinf=cursoFacade.find(cursoinf.getCodigoCurso());
            }
            
            request.setAttribute("course", cursoinf);
            //request.setAttribute("allStudents", cursoFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteCursoInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteCursoInfo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
