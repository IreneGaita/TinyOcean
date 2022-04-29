package it.tinyOcean.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.tinyOcean.model.*;

/**
 * Servlet implementation class AddressControl
 */
@WebServlet("/IndirizzoServlet")
public class IndirizzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static IndirizzoDAO IndirizzoDAO = new IndirizzoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndirizzoServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String via = request.getParameter("via");
		int numCivico = Integer.parseInt(request.getParameter("numCivico"));
		int cap = Integer.parseInt(request.getParameter("cap"));
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		
		IndirizzoBean address = new IndirizzoBean();
		
		UtenteBean user = (UtenteBean) request.getSession().getAttribute("currentSessionUser");
		address.setVia(via);
		address.setNumCivico(numCivico);
		address.setCap(cap);
		address.setCitta(citta);
		address.setProvincia(provincia);
		IndirizzoDAO.doSave(user, address);
		response.sendRedirect("CheckoutPage.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}