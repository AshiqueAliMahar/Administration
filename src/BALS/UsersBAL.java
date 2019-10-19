package BALS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Beans.UsersBean;
import MySQlConnection.DBConnect;

public class UsersBAL {
	public static UsersBean isAvail(UsersBean usersBean) {
		try {
			String query="SELECT `Users`.`id`,\n" + 
					"    `Users`.`name`,\n" + 
					"    `Users`.`email`,\n" + 
					"    `Users`.`password`,\n" + 
					"    `Users`.`contact`,\n" + 
					"    `Users`.`address`,\n" + 
					"    `Users`.`status`,\n" + 
					"    `Users`.`role`\n" + 
					"FROM `Administration`.`Users`  where binary email= binary '"+usersBean.getEmail()+"' and binary password='"+usersBean.getPassword()+"';";
			Statement statement=DBConnect.getConnection().createStatement();
			ResultSet rSet=statement.executeQuery(query);
			if (rSet.next()) {
				usersBean.setId(rSet.getInt(1));
				usersBean.setName(rSet.getString(2));
				usersBean.setEmail(rSet.getString(3));
				usersBean.setPassword(rSet.getString(4));
				usersBean.setContact(rSet.getString(5));
				usersBean.setAddress(rSet.getString(6));
				usersBean.setStatus(rSet.getString(7));
				usersBean.setRole(rSet.getString(8));
			}else {
				usersBean=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersBean;
	}
	public static void insert(UsersBean usersBean) {
		String query="INSERT INTO `Administration`.`Users`\n" + 
				"(`id`,\n" + 
				"`name`,\n" + 
				"`email`,\n" + 
				"`password`,\n" + 
				"`contact`,\n" + 
				"`address`,\n" + 
				"`status`,\n" + 
				"`role`)\n" + 
				"VALUES\n" + 
				"("+usersBean.getId()+",'"+usersBean.getName()+"','"+usersBean.getEmail()+"','"+usersBean.getPassword()+"','"+usersBean.getContact()+"','"+usersBean.getAddress()+"','"+usersBean.getStatus()+"','"+usersBean.getRole()+"');";
		Statement statement;
		try {
			statement = DBConnect.getConnection().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void update(UsersBean usersBean) {
		String query="UPDATE `Users`\n" + 
				"SET\n" + 
				"`name` = '"+usersBean.getName()+"',\n" + 
				"`email` = '"+usersBean.getEmail()+"',\n" + 
				"`password` = '"+usersBean.getPassword()+"',\n" + 
				"`contact` = '"+usersBean.getContact()+"',\n" + 
				"`address` = '"+usersBean.getAddress()+"',\n" + 
				"`status` = '"+usersBean.getStatus()+"',\n" + 
				"`role` = '"+usersBean.getRole()+"'\n" + 
				"WHERE `id` = "+usersBean.getId()+";";
		try {
			Statement statement = DBConnect.getConnection().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update(int id,String status) {
		String query="UPDATE `Users`\n" + 
				"SET\n"+ 
				"`status` = '"+status+"'\n" +  
				"WHERE `id` = "+id+";";
		try {
			Statement statement = DBConnect.getConnection().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<UsersBean> getAllEmp(String status,String role) {
		ArrayList<UsersBean> arrayList=new ArrayList<>();
		try {
			String query="SELECT `Users`.`id`,\n" + 
					"    `Users`.`name`,\n" + 
					"    `Users`.`email`,\n" + 
					"    `Users`.`password`,\n" + 
					"    `Users`.`contact`,\n" + 
					"    `Users`.`address`,\n" + 
					"    `Users`.`status`,\n" + 
					"    `Users`.`role`\n" + 
					"FROM `Administration`.`Users` where status='"+status+"' and role='"+role+"';";
			Statement statement=DBConnect.getConnection().createStatement();
			ResultSet rSet=statement.executeQuery(query);
			while (rSet.next()) {
				
				UsersBean usersBean=new UsersBean(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8));
				arrayList.add(usersBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
}
