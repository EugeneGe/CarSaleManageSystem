package com.controller;

import java.util.List;

import javax.swing.JTextField;

import com.dao.GuestDao;
import com.entity.Guest;

public class GuestAction {
	//增加客户信息
	public void addGuestInformation(
			JTextField guestNameField,
			JTextField contactInformationField,
			JTextField addressField,
			JTextField businessRecordField) throws Exception{
		GuestDao guestDao = new GuestDao();
		Guest guest = new Guest();
		guest.setGuest_name(guestNameField.getText());
		guest.setContact_information(contactInformationField.getText());
		guest.setAddress(addressField.getText());
		guest.setBusiness_record(businessRecordField.getText());
		
		guestDao.addGuest(guest);
	}
	//删除客户信息
	public void delGuestInformation(String guest_name)throws Exception {
		GuestDao guestDao = new GuestDao();
		
		guestDao.delGuest(guest_name);
	}
	//修改客户信息
	public void changeGuestInformation(JTextField guestNameField,
			JTextField contactInformationField,
			JTextField addressField,
			JTextField businessRecordField) throws Exception{
		GuestDao guestDao = new GuestDao();
		Guest guest = new Guest();
		
		guest.setGuest_name(guestNameField.getText());
		guest.setContact_information(contactInformationField.getText());
		guest.setAddress(addressField.getText());
		guest.setBusiness_record(businessRecordField.getText());
		
		guestDao.changeGuest(guest);
	}
	//查询表信息并放入二维数组中保存
		public Object[][] query(String[] columnNames) throws Exception{
			// TODO Auto-generated method stub
			GuestDao guestDao = new GuestDao();
			List<Guest> list = guestDao.query();
			Object[][] results= new Object[list.size()][columnNames.length];
			for (int i = 0; i < list.size(); i++) {
				Guest car = (Guest)list.get(i);
				
				results[i][0] = car.getGuest_name();
				results[i][1] = car.getContact_information();
				results[i][2]=car.getAddress();
				results[i][3]=car.getBusiness_record();

				
			}
			return results;
		}
}
