package fr.eni.encheres.servlets;

import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDeProfil
 */
@WebServlet("/profil")
public class ServletDeProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurManager utilisateurManager;

	@Override
	public void init() throws ServletException {
	    utilisateurManager = new UtilisateurManager();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/afficherProfil.jsp");
	    dispatcher.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
