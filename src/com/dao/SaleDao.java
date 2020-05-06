package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.entity.Sale;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.utils.DBUtil;

public class SaleDao {
	//添加销售信息
	public void addSale(Sale sale) throws Exception {
		Connection con = (Connection) DBUtil.getConnection();
		String sql="insert into sales_info"
				+"(sale_date,car_type,color,number,handler)"
				+"values(?,?,?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, sale.getSale_date());
		psmt.setString(2, sale.getCar_type());
		psmt.setString(3, sale.getColor());
		psmt.setInt(4, sale.getNumber());
		psmt.setString(5, sale.getHandler());
		
		try {
			psmt.execute();
			JOptionPane.showMessageDialog(null, "数据添加成功","tips",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据添加失败","tips",JOptionPane.PLAIN_MESSAGE);
		}
	}
	//删除销售信息
	public void delSale(String sale_date) throws SQLException{
		Connection con=(Connection) DBUtil.getConnection();
		String sql="" + 
                "DELETE FROM sales_info "+               
                "WHERE sale_date = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, sale_date);
        try {
        	psmt.execute(); 
        	JOptionPane.showMessageDialog(null, "数据删除成功","tips",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据删除失败","tips",JOptionPane.PLAIN_MESSAGE);
		}
	}
	//修改销售信息
	public void changeSale(Sale sale)throws SQLException {
		String sale_date=sale.getSale_date();
		String car_type =sale.getCar_type();
		String color = sale.getColor();
		Integer number = sale.getNumber();
		String handler=sale.getHandler();
		Connection con=(Connection) DBUtil.getConnection();
		String sql= "update sales_info"
				+" set sale_date=\""+sale_date+"\","
				+ "car_type=\""+car_type+"\","
				+ "color=\""+color+"\","
				+ "number=\""+number+"\""
				+ " where handler=\""+handler+"\";";
		Statement stm = (Statement) con.createStatement();
		try {
			stm.execute(sql);
        	JOptionPane.showMessageDialog(null, "数据修改成功","tips",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
        	JOptionPane.showMessageDialog(null, "数据修改失败","tips",JOptionPane.PLAIN_MESSAGE);

		}
	}
	// 查询表信息
		public List<Sale> query() throws Exception {
			Connection con = (Connection) DBUtil.getConnection();
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select  sale_date,car_type,color,number,handler from sales_info");
			List<Sale> saleList = new ArrayList<Sale>();
			Sale sale = null;
			while (rs.next()) {
				sale = new Sale();
				sale.setSale_date(rs.getString("sale_date"));
				sale.setCar_type(rs.getString("car_type"));
				sale.setColor(rs.getString("color"));
				sale.setNumber(rs.getInt("number"));
				sale.setHandler(rs.getString("handler"));
				saleList.add(sale);
			}
			return saleList;
		}
}
