package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.pipe.Tube;

import dbUilt.DBUilt;
import model.Matter;

public class MatterDao {
	//tianjia 
	public static void addMatter(String title,String content,String author,String type) {
		Connection connection=DBUilt.getConnection();
		String sql="insert into matter(title,content,time,author,type) values(?,?,now(),?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			
			preparedStatement.setString(3, author);
			preparedStatement.setString(4, type);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Matter> getAllMatter(){
		List<Matter> list=new ArrayList<>();
		Connection connection=DBUilt.getConnection();
		String sql="select * from matter";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Matter matter=new Matter(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("content"), resultSet.getString("time"), resultSet.getString("author"), resultSet.getString("type"));
				list.add(matter);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	//É¾³ýÄÚÈÝ
	public void deleteByid(int id) {
		Connection connection=DBUilt.getConnection();
		String sql="delete from matter where id = ?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ÐÞ¸Ä
	public void Update(int id,String title,String content,String type) {
		Connection connection=DBUilt.getConnection();
		String sql="update matter set title=?,content=?,type=? where id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, type);
			preparedStatement.setInt(4, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
