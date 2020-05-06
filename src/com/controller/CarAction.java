package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import com.dao.CarDao;
import com.entity.Car;

public class CarAction {
	
//添加car信息
	public void addCarInformation(JTextField textFieldCarID, // 汽车ID
			JTextField	textFieldModel, // 汽车型号
			JTextField textFieldColor, // 汽车颜色
			JTextField textFieldManuFactory, // 生产厂商
			JTextField textFieldFactoryDate, // 出厂日期
			JTextField textFieldPrice) throws Exception{	
		CarDao carDao = new CarDao();
		Car car = new Car();
		
		int car_id=Integer.parseInt(textFieldCarID.getText());
		car.setCar_id(car_id);//强制类型转换
		car.setModel(textFieldModel.getText());
		car.setColor(textFieldColor.getText());
		car.setManufactory(textFieldManuFactory.getText());
		car.setFactory_date(textFieldFactoryDate.getText());
		car.setPrice(textFieldPrice.getText());
		carDao.addCar(car);
		
	}
//删除car信息
	public void delCarInformation(int car_id) throws SQLException {
		
		CarDao carDao = new CarDao();
//		Car car = new Car();
//		car.setCar_id(car_id);
		//删除汽车信息
		carDao.delCar(car_id);
	}
	//修改car信息
	public void changeCarInformation(JTextField textFieldCarID, // 汽车ID
			JTextField	textFieldModel, // 汽车型号
			JTextField textFieldColor, // 汽车颜色
			JTextField textFieldManuFactory, // 生产厂商
			JTextField textFieldFactoryDate, // 出厂日期
			JTextField textFieldPrice//汽车价钱
			)throws Exception {

		CarDao carDao = new CarDao();
		Car car = new Car();

        car.setCar_id(Integer.parseInt(textFieldCarID.getText()));
        car.setModel(textFieldModel.getText());
        car.setColor(textFieldColor.getText());
        car.setManufactory(textFieldManuFactory.getText());
        car.setFactory_date(textFieldFactoryDate.getText());
        car.setPrice(textFieldPrice.getText());
        //修改汽车信息
        carDao.changeCar(car);
//        System.out.println(car.getCar_id()+car.getColor()+car.getModel()+car.getManufactory()+car.getFactory_date()+car.getPrice());
	}
//查询表信息并放入二维数组中保存
	public Object[][] query(String[] columnNames) throws Exception{
		// TODO Auto-generated method stub
		CarDao carDao=new CarDao();
		List<Car> list = carDao.query();
		Object[][] results= new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			Car car = (Car)list.get(i);
			
			results[i][0] = car.getCar_id();
			results[i][1] = car.getModel();
			results[i][2]=car.getColor();
			results[i][3]=car.getManufactory();
			results[i][4]=car.getFactory_date();
			results[i][5]=car.getPrice();
			
		}
		return results;
	}

}
