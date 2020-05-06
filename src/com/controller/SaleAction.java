package com.controller;

import java.util.List;

import javax.swing.JTextField;

import com.dao.SaleDao;
import com.entity.Sale;


public class SaleAction {
	//添加销售信息
	public void addSaleInformation(JTextField saleDateField, 
			JTextField carTypeField,
			JTextField colorField,
			JTextField numberField,
			JTextField handlerField)throws Exception {
		SaleDao saleDao = new SaleDao();
		Sale sale = new Sale();
		sale.setSale_date(saleDateField.getText());
		sale.setCar_type(carTypeField.getText());
		sale.setColor(colorField.getText());
		sale.setNumber(Integer.parseInt(numberField.getText()));
		sale.setHandler(handlerField.getText());
		
		saleDao.addSale(sale);
	}
	//删除销售信息
	public void delSaleInformation(String sale_date)throws Exception {

		SaleDao saleDao = new SaleDao();
		saleDao.delSale(sale_date);
	}
	//修改销售信息
	public void changeSaleInformation(JTextField saleDateField, 
			JTextField carTypeField,
			JTextField colorField,
			JTextField numberField,
			JTextField handlerField) throws Exception{
		SaleDao saleDao = new SaleDao();
		Sale sale = new Sale();
		sale.setSale_date(saleDateField.getText());
		sale.setCar_type(carTypeField.getText());
		sale.setColor(colorField.getText());
		sale.setNumber(Integer.parseInt(numberField.getText()));
		sale.setHandler(handlerField.getText());
		
		saleDao.changeSale(sale);
		
	}
	//查询表信息并放入二维数组中保存
	public Object[][] query(String[] columnNames) throws Exception{
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDao();
		List<Sale> list = saleDao.query();
		Object[][] results= new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			Sale sale= (Sale)list.get(i);
			
			results[i][0] = sale.getSale_date();
			results[i][1] = sale.getCar_type();
			results[i][2]=sale.getColor();
			results[i][3]=sale.getNumber();
			results[i][4]=sale.getHandler();

		}
		return results;
	}
}
