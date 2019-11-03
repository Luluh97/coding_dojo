package com.codingdojo.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int random_num;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Random rand = new Random();
		random_num = rand.nextInt(100);
		session.setAttribute("random_num", random_num);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer random_num = (Integer) session.getAttribute("random_num");
		Integer answer = Integer.parseInt(request.getParameter("answer"));
		if(random_num == answer ) {
			session.setAttribute("result", "correct");
		}
		else if(random_num > answer ) {
			session.setAttribute("result", "too low");
		}
		else if(random_num < answer ) {
			session.setAttribute("result", "too high");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/result.jsp");
        view.forward(request, response);
		doGet(request, response);
	}

}
