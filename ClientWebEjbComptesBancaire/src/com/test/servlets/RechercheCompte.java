package com.test.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.modele.Compte;

/**
 * Servlet implementation class RechercheCompte
 */
@WebServlet("/RechercheCompte")
public class RechercheCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private tp.ejbCompte.EjbComptesBancairesLocal ejb;
    public RechercheCompte() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/rechercheCompte.jsp" ).forward(    request, response );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Compte compte;
		compte=ejb.rechercherCompte((Integer.parseInt(request.getParameter("idCompteR"))));
		request.setAttribute("compte", compte);
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/rechercheCompte.jsp" ).forward(    request, response );
	}
}
