package com.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.controller.GuestAction;
import com.utils.BackgroundImage;
import com.utils.FrameOption;
import com.utils.MenuBar;
import com.utils.SetTable;

public class guestView {
	JFrame main = new JFrame("Car Sale System");
	Container container = main.getContentPane();
	private JScrollPane scrollPane;
	private JButton buttonAdd;
	private JButton buttonReset;
	private JButton buttonChange;
	private JButton buttonDel;
	JTable table;
	JTextField guestNameField, contactInformationField, addressField, businessRecordField;
	private GuestAction guestAction;

	public guestView() {
		// TODO Auto-generated constructor stub
		main.setLayout(null);
		new BackgroundImage(main, container, "GuestBackground.jpg");
		new FrameOption(main);
		new MenuBar(main);
		// 实例化标签和文本框
		JLabel guestNameJLabel = new JLabel("GuestName");
		guestNameJLabel.setForeground(Color.green);
		guestNameJLabel.setBounds(100, 350, 125, 20);
		JTextField guestNameField = new JTextField();
		guestNameField.setBounds(225, 350, 175, 20);
		JLabel contactInformationJLabel = new JLabel("ContactInformation");
		contactInformationJLabel.setForeground(Color.green);
		contactInformationJLabel.setBounds(500, 350, 125, 20);
		JTextField contactInformationField = new JTextField();
		contactInformationField.setBounds(625, 350, 150, 20);
		JLabel addressJLabel = new JLabel("Address");
		addressJLabel.setForeground(Color.green);
		addressJLabel.setBounds(100, 400, 125, 20);
		JTextField addressField = new JTextField();
		addressField.setBounds(225, 400, 175, 20);
		JLabel businessRecordJLabel = new JLabel("BusinessRecord");
		businessRecordJLabel.setForeground(Color.green);
		businessRecordJLabel.setBounds(500, 400, 125, 20);
		JTextField businessRecordField = new JTextField();
		businessRecordField.setBounds(625, 400, 150, 20);

		// 修改输入字体颜色
		guestNameField.setForeground(new Color(19, 190, 196));
		contactInformationField.setForeground(new Color(19, 190, 196));
		addressField.setForeground(new Color(19, 190, 196));
		businessRecordField.setForeground(new Color(19, 190, 196));

		// 使文本框透明
		guestNameField.setOpaque(false);
		contactInformationField.setOpaque(false);
		addressField.setOpaque(false);
		businessRecordField.setOpaque(false);

		container.add(guestNameJLabel);
		container.add(guestNameField);
		container.add(contactInformationJLabel);
		container.add(contactInformationField);
		container.add(addressJLabel);
		container.add(addressField);
		container.add(businessRecordJLabel);
		container.add(businessRecordField);

		// 实例化按钮
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(100, 480, 100, 20);

		buttonDel = new JButton("Delect");
		buttonDel.setBounds(300, 480, 100, 20);

		buttonChange = new JButton("Change");
		buttonChange.setBounds(500, 480, 100, 20);
		
		buttonReset = new JButton("Query");
		buttonReset.setBounds(700, 480, 100, 20);


		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonChange);
		container.add(buttonReset);
		
		guestAction = new GuestAction();
		//初始化表格
		setTable();
		//添加按钮监听
		//添加按钮
		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					guestAction.addGuestInformation(guestNameField, contactInformationField, addressField,
							businessRecordField);
					main.setVisible(false);
					new guestView();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		//删除按钮
		buttonDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					guestAction.delGuestInformation(guestNameField.getText());
					main.setVisible(false);
					new guestView();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		//修改按钮
		buttonChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					guestAction.changeGuestInformation(guestNameField, contactInformationField, addressField,
							businessRecordField);
					main.setVisible(false);
					new guestView();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		//查询按钮
		buttonReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					setTable();
					main.setVisible(false);
					new guestView();
					JOptionPane.showMessageDialog(null, "数据更新成功", "tips", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "数据更新失败", "tips", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
	
	private void setTable() {
		String[] columnNames = { "姓名", "联系方式", "地址", "业务联系记录" };
		try {
			GuestAction guestAction = new GuestAction();
			Object[][] results = guestAction.query(columnNames);

			table = new JTable(results, columnNames);
			scrollPane = new JScrollPane(table);
			// 设置表格
			new SetTable(scrollPane, table, columnNames, main);

			table.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
//					String guest_name, contact_inf, address, business_re;
//
//					int selRow = table.getSelectedRow();
//
//					guest_name = table.getValueAt(selRow, 0).toString();
//					contact_inf = table.getValueAt(selRow, 1).toString();
//					address = table.getValueAt(selRow, 2).toString();
//					business_re = table.getValueAt(selRow, 3).toString();
//
//					guestNameField.setText(guest_name);
//					contactInformationField.setText(contact_inf);
//					addressField.setText(address);
//					businessRecordField.setText(business_re);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
