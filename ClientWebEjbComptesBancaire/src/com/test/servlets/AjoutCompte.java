package com.test.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.modele.Compte;

/**
 * Servlet implementation class AjoutCompte
 */
@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private tp.ejbCompte.EjbComptesBancairesLocal ejb;
    /**
     * Default constructor. 
     */
    public AjoutCompte() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/ajoutCompte.jsp" ).forward(    request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Compte compte=new Compte();
		compte.setIdCompte(Integer.parseInt(request.getParameter("idCompte")));
		compte.setSolde(Double.parseDouble(request.getParameter("solde")));
		compte.setDateCreation(Date.valueOf(request.getParameter("dateCreation")));
		compte.setProprietaire((request.getParameter("proprietaire")));
		
		
		ejb.ajouterCompte(compte);
		request.setAttribute("message", "compte ajoutée avec succes");
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/ajoutCompte.jsp" ).forward(    request, response );

	}
}
