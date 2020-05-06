package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.entity.Worker;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.utils.DBUtil;

public class WorkerDao {
	//添加员工信息
	public void addWorker(Worker worker) throws Exception {
		Connection con= (Connection) DBUtil.getConnection();
		String sql="insert into worker_info"
				+"(worker_id,name,sex,age,origin,education)"
				+"values(?,?,?,?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, worker.getWorker_id());
		psmt.setString(2, worker.getName());
		psmt.setString(3, worker.getSex());
		psmt.setString(4, worker.getAge());
		psmt.setString(5, worker.getOrigin());
		psmt.setString(6, worker.getEducation());
		try {
			psmt.execute();
			JOptionPane.showMessageDialog(null, "数据添加成功","tips",JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据添加失败","tips",JOptionPane.PLAIN_MESSAGE);

		}
	}
	//删除员工信息
	public void delWorker(int worker_id) throws SQLException {
		Connection con=(Connection) DBUtil.getConnection();
		String sql=
				"delete from worker_info where worker_id = ?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setInt(1,worker_id);
		try {
			psmt.execute();
			JOptionPane.showMessageDialog(null, "数据删除成功","tips",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据删除失败","tips",JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	//更新员工信息
	public void changeWorker(Worker worker) throws SQLException {
		String  name = worker.getName();
		String sex= worker.getSex();
		String age = worker.getAge();
		String origin = worker.getOrigin();
		String education = worker.getEducation();
		Integer worker_id = worker.getWorker_id();
		Connection con = (Connection) DBUtil.getConnection();
		String sql ="update worker_info"
				+" set name =\""+name+"\","
				+ "sex = \""+sex+"\","
				+ "age = \""+age+"\","
				+ "origin =\""+origin+"\","
				+ "education =\""+education+"\""
				+" where worker_id ="+worker_id+";";
		Statement smt = (Statement) con.createStatement();
		try {
			smt.execute(sql);
			JOptionPane.showMessageDialog(null, "数据更新成功","tips",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据更新失败","tips",JOptionPane.PLAIN_MESSAGE);

		}
		
	}
// 查询表信息
	public List<Worker> query() throws Exception {
		Connection con = (Connection) DBUtil.getConnection();
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery("select worker_id,name,sex,age,origin,education from worker_info");
		List<Worker> workerList = new ArrayList<Worker>();
		Worker worker = null;
		while (rs.next()) {
			worker = new Worker();
			worker.setWorker_id(Integer.parseInt(rs.getString("worker_id")));
			worker.setName(rs.getString("name"));
			worker.setSex(rs.getString("sex"));
			worker.setAge(rs.getString("age"));
			worker.setOrigin(rs.getString("origin"));
			worker.setEducation(rs.getString("education"));

			workerList.add(worker);
		}
		return workerList;
	}
}
