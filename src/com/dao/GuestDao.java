package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.entity.Guest;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.utils.DBUtil;

public class GuestDao {
	// 增加客户信息
	public void addGuest(Guest guest) throws Exception {
		Connection con = (Connection) DBUtil.getConnection();
		String sql = "insert into guest_info" + "(guest_name,contact_inf,address,business_re)" + "values(?,?,?,?)";
		PreparedStatement psmt = (PreparedStatement) con.prepareStatement(sql);
		psmt.setString(1, guest.getGuest_name());
		psmt.setString(2, guest.getContact_information());
		psmt.setString(3, guest.getAddress());
		psmt.setString(4, guest.getBusiness_record());
		try {
			psmt.execute();
			JOptionPane.showMessageDialog(null, "数据添加成功", "tips", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据添加失败", "tips", JOptionPane.PLAIN_MESSAGE);
		}
	}

//删除客户信息
	public void delGuest(String guest_name) throws SQLException {
		Connection con = (Connection) DBUtil.getConnection();
		String sql = "delete from guest_info where guest_name = ?";
		PreparedStatement psmt = (PreparedStatement) con.prepareStatement(sql);
		psmt.setString(1, guest_name);
		try {
			psmt.execute();
			JOptionPane.showMessageDialog(null, "数据删除成功", "tips", JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据删除失败", "tips", JOptionPane.PLAIN_MESSAGE);

		}
	}

	// 修改客户信息
	public void changeGuest(Guest guest) throws SQLException {
		String contact_inf = guest.getContact_information();
		String address = guest.getAddress();
		String business_re = guest.getBusiness_record();
		String guest_name = guest.getGuest_name();
		Connection con = (Connection) DBUtil.getConnection();
		String sql = "update guest_info" + " set contact_inf=\"" + contact_inf + "\"," + "address=\"" + address + "\","
				+ "business_re=\"" + business_re + "\"" + " where guest_name=\"" + guest_name + "\";";
		Statement stm = (Statement) con.createStatement();

		try {
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "数据修改成功", "tips", JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据修改失败", "tips", JOptionPane.PLAIN_MESSAGE);

		}
	}

	// 查询表信息
	public List<Guest> query() throws Exception {
		Connection con = (Connection) DBUtil.getConnection();
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery("select guest_name,contact_inf,address,business_re" + " from guest_info");
		List<Guest> carList = new ArrayList<Guest>();
		Guest guest = null;
		while (rs.next()) {
			guest = new Guest();
			guest.setGuest_name(rs.getString("guest_name"));
			guest.setContact_information(rs.getString("contact_inf"));
			guest.setAddress(rs.getString("address"));
			guest.setBusiness_record(rs.getString("business_re"));

			carList.add(guest);
		}
		return carList;

	}
}
