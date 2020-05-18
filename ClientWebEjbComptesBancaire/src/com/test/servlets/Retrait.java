package com.test.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Retrait
 */
@WebServlet("/Retrait")
public class Retrait extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idCompte;  
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private tp.ejbCompte.EjbComptesBancairesLocal ejb;
    public Retrait() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		idCompte=Integer.parseInt(request.getParameter("idCompte"));
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/retrait.jsp" ).forward(    request, response );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double montant=(Double.parseDouble(request.getParameter("montant")));
		ejb.retirer(idCompte, montant);
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/retrait.jsp" ).forward(    request, response );

	}
}
