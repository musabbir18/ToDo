package com.servlet;

import java.io.IOException;

import com.DAO.TodoDAO;
import com.DB.DBConnect;
import com.entity.Todo_Details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status=req.getParameter("status");
		System.out.println(id);
		
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		
		Todo_Details t=new Todo_Details();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		
		
		boolean f=dao.updateTodo(t);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "Todo Data SuccessFully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failed", "Something wrong on Server!!");
			resp.sendRedirect("add_todo.jsp");
		}
	}

}
