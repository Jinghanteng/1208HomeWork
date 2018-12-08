package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dbUilt.DBUilt;
import model.Type;

public class TypeDao {
	//获取类型
	public List<Type> getAllType(){
		List<Type> list=new ArrayList<>();
		Connection connection=DBUilt.getConnection();
		String sql="select * from type";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Type type=new Type(resultSet.getInt("id"),resultSet.getString("name"));
				list.add(type);
				
			}
			DBUilt.close(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
