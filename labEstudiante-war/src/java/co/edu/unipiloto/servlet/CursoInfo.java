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
            Integer codigoCurso = Integer.parseInt(codigoCursoStr);
            String numeroCreditosStr = request.getParameter("numeroCreditos");
            Integer numeroCreditos = Integer.parseInt(numeroCreditosStr);
            String semestreStr = request.getParameter("semestre");
            Integer semestre = Integer.parseInt(semestreStr);
            String estudiantesAdmitidosStr = request.getParameter("estudiantesAdmitidos");
            Integer estudiantesAdmitidos=Integer.parseInt(estudiantesAdmitidosStr);
            
            Curso curso = new Curso (codigoCurso, nombreCurso, numeroCreditos, semestre, estudiantesAdmitidos);
            
            if (action.equals("Agregar")) {
                cursoFacade.create(curso);
            } else if (action.equals("Buscar")) {
                curso=cursoFacade.find(curso.getCodigoCurso());
            }
            
            request.setAttribute("allCurso", cursoFacade.findAll());
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
