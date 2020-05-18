package com.test.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tp.modele.Compte;

/**
 * Servlet implementation class ListeComptes
 */
@WebServlet("/ListeComptes")
public class ListeComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private tp.ejbCompte.EjbComptesBancairesLocal ejb;
    public ListeComptes() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Compte> listeDesComptes;
		listeDesComptes=ejb.listerComptes();
		request.setAttribute("comptes", listeDesComptes);
		this.getServletContext().getRequestDispatcher(    "/WEB-INF/listeComptes.jsp" ).forward(    request, response );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
