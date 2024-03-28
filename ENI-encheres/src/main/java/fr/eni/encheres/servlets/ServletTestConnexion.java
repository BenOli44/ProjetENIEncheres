package fr.eni.encheres.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * Servlet implementation class TestConnexion
 */
@WebServlet("/ServletTestConnexion")
public class ServletTestConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		try {
			
			Context context = new InitialContext();
			
			
			// Recherche de la DataSource
		
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
						
					
			// Demande d'une connexion pour effectuer les traitements
			
			Connection cnx = dataSource.getConnection();
			out.print("La connexion est" + (cnx.isClosed()? " fermée":" ouverte")+".");
			
			// Libérer la connexion lorsqu'on n'en a plus besoin
			
			cnx.close();
			
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une erreur est survenue lors de l'utilisation de la base de données");
			
			
		}
		
		
	}


}