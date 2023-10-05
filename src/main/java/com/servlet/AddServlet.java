package com.servlet;

import java.io.IOException;

import javax.sound.midi.Soundbank;

import com.DAO.TodoDAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add_todo")
public class AddServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status=req.getParameter("status");
		
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		
		boolean f=dao.addTodo(username, todo, status);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("sucMsg", "Todo Addes SuccessFully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failed", "Something wrong on Server!!");
			resp.sendRedirect("add_todo.jsp");
		}
	}
}
