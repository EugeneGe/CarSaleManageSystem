package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.entity.Car;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.utils.DBUtil;

public class CarDao {
    // 添加表信息
    public void addCar(Car car) throws Exception {
        Connection con = (Connection) DBUtil.getConnection();
        String sql = "insert into car_info"
                + "(car_id,model,color,manufactory,factory_date,price)"
                + "values(?,?,?,?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1, car.getCar_id());
        psmt.setString(2, car.getModel());
        psmt.setString(3, car.getColor());
        psmt.setString(4, car.getManufactory());
        psmt.setString(5, car.getFactory_date());
        psmt.setString(6, car.getPrice());
        try {
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "数据插入成功", "tips", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据插入失败 ", "tips", JOptionPane.PLAIN_MESSAGE);
        }
        con.close();
    }

    //删除汽车信息
    public void delCar(int car_id) throws SQLException {
        Connection con = (Connection) DBUtil.getConnection();
        String sql = "" +
                "DELETE FROM car_info " +
                "WHERE car_id = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1, car_id);
        try {
            psmt.execute();
            JOptionPane.showMessageDialog(null, "数据删除成功", "tips", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "数据删除失败", "tips", JOptionPane.PLAIN_MESSAGE);
        }

    }

    // 修改Car信息
    public void changeCar(Car car) throws SQLException {
//	System.out.println(car.getCar_id()+car.getColor()+car.getModel()+car.getManufactory()+car.getFactory_date()+car.getPrice());
        String model = car.getModel();
        String color = car.getColor();
        String manufactory = car.getManufactory();
        String factory_date = car.getFactory_date();
        String price = car.getPrice();
        Integer car_id = car.getCar_id();
        Connection con = (Connection) DBUtil.getConnection();
        String sql = "update car_info "
                + "set model=\"" + model + "\","
                + "color=\"" + color + "\","
                + "manufactory=\"" + manufactory + "\","
                + "factory_date=\"" + factory_date + "\","
                + "price=\"" + price + "\" "
                + "where car_id =" + car_id + ";";
        Statement psmt = (Statement) con.createStatement();
        try {
            psmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "tips", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "数据修改失败", "tips", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // 查询表信息
    public List<Car> query() throws Exception {
        Connection con = (Connection) DBUtil.getConnection();
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery("select car_id,model,color,manufactory," +
                "factory_date,price from car_info");
        List<Car> carList = new ArrayList<Car>();
        Car car = null;
        while (rs.next()) {
            car = new Car();
            car.setCar_id(Integer.parseInt(rs.getString("car_id")));
            car.setModel(rs.getString("model"));
            car.setColor(rs.getString("color"));
            car.setManufactory(rs.getString("manufactory"));
            car.setFactory_date(rs.getString("factory_date"));
            car.setPrice(rs.getString("price"));
            carList.add(car);
        }
        return carList;

    }
}
