package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Todo_Details;

public class TodoDAO {
	
	private Connection conn;

	public TodoDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addTodo(String name,String todo, String status) {
		boolean f=false;
		try {
			String sql="insert into todoapp(name,todo,status) values(?,?,?)";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, todo);
			preparedStatement.setString(3, status);
			
			int row=preparedStatement.executeUpdate();
			
			if(row>0) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}
    public List<Todo_Details> geTodo(){
    	List<Todo_Details> list=new ArrayList<>();
    	Todo_Details t=null;
    	try {
			String sql="Select *from todoapp";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				t=new Todo_Details();
				t.setId(resultSet.getInt(1));
				t.setName(resultSet.getString(2));
				t.setTodo(resultSet.getString(3));
				t.setStatus(resultSet.getString(4));
				
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return list;
    }
   
		
	public Todo_Details getTodoById(int id) {
		Todo_Details t=null;
		
		try {
			String sql="Select *from todoapp where id=?";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				t=new Todo_Details();
				t.setId(resultSet.getInt(1));
				t.setName(resultSet.getString(2));
				t.setTodo(resultSet.getString(3));
				t.setStatus(resultSet.getString(4));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}

	public boolean updateTodo(Todo_Details t) {
		boolean f=false;
		try {
			String sql="Update todoapp set name=?,todo=?,status=? where id=?";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getTodo());
			preparedStatement.setString(3, t.getStatus());
			preparedStatement.setInt(4, t.getId());
			
			int row=preparedStatement.executeUpdate();
			
			if(row>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
