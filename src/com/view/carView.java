package com.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.controller.CarAction;
import com.utils.BackgroundImage;
import com.utils.FrameOption;
import com.utils.MenuBar;
import com.utils.SetTable;

public class carView {
	JFrame main = new JFrame("Car Sale System");
	Container container = main.getContentPane();
	JButton buttonAdd, buttonDel, buttonChange, buttonReset;
	JTextField textFieldCarID, // 汽车ID
			textFieldModel, // 汽车型号
			textFieldColor, // 汽车颜色
			textFieldManuFactory, // 生产厂商
			textFieldFactoryDate, // 出厂日期
			textFieldPrice;// 价格
	JTable table;// 表格
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	CarAction carAction;

	public carView() {
		// TODO Auto-generated constructor stub
		main.setLayout(null);
		new BackgroundImage(main, container, "CarBackground.jpg");
		new FrameOption(main);
		new MenuBar(main);

		// 实例化标签和文本框
		JLabel JLabelCarID = new JLabel("CarID");
		JLabelCarID.setForeground(Color.green);
		JLabelCarID.setBounds(75, 350, 100, 20);
		JTextField textFieldCarID = new JTextField();
		textFieldCarID.setBounds(175, 350, 100, 20);
		
		
		JLabel JLabelModel = new JLabel("Model");
		JLabelModel.setForeground(Color.green);
		JLabelModel.setBounds(350, 350, 100, 20);
		JTextField textFieldModel = new JTextField();
		textFieldModel.setBounds(450, 350, 100, 20);
		
		JLabel JLabelColor = new JLabel("Color");
		JLabelColor.setForeground(Color.green);
		JLabelColor.setBounds(625, 350, 100, 20);
		JTextField textFieldColor = new JTextField();
		textFieldColor.setBounds(725, 350, 100, 20);
		
		JLabel JLabelManuFactory = new JLabel("ManuFactory");
		JLabelManuFactory.setForeground(Color.green);
		JLabelManuFactory.setBounds(75, 400, 100, 20);
		JTextField textFieldManuFactory = new JTextField();
		textFieldManuFactory.setBounds(175, 400, 100, 20);
		
		JLabel JLabelFactorydate = new JLabel("FactoryDate");
		JLabelFactorydate.setForeground(Color.green);
		JLabelFactorydate.setBounds(350, 400, 100, 20);
		JTextField textFieldFactoryDate = new JTextField();
		textFieldFactoryDate.setBounds(450, 400, 100, 20);
		
		JLabel JLabelPrice = new JLabel("Price");
		JLabelPrice.setForeground(Color.green);
		JLabelPrice.setBounds(625, 400, 100, 20);
		JTextField textFieldPrice = new JTextField();
		textFieldPrice.setBounds(725, 400, 100, 20);

		// 使文本框透明
		textFieldCarID.setOpaque(false);
		textFieldModel.setOpaque(false);
		textFieldColor.setOpaque(false);
		textFieldColor.setOpaque(false);
		textFieldManuFactory.setOpaque(false);
		textFieldFactoryDate.setOpaque(false);
		textFieldPrice.setOpaque(false);
		//修改输入字体颜色
		textFieldCarID.setForeground(new Color(19, 190, 196)); 
		textFieldModel.setForeground(new Color(19, 190, 196)); 
		textFieldColor.setForeground(new Color(19, 190, 196)); 
		textFieldManuFactory.setForeground(new Color(19, 190, 196)); 
		textFieldFactoryDate.setForeground(new Color(19, 190, 196)); 
		textFieldPrice.setForeground(new Color(19, 190, 196)); 

		container.add(JLabelCarID);
		container.add(JLabelModel);
		container.add(JLabelColor);
		container.add(JLabelManuFactory);
		container.add(JLabelFactorydate);
		container.add(JLabelPrice);

		container.add(textFieldCarID);
		container.add(textFieldModel);
		container.add(textFieldColor);
		container.add(textFieldManuFactory);
		container.add(textFieldFactoryDate);
		container.add(textFieldPrice);

		// 实例化按钮
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(100, 480, 100, 20);
		buttonDel = new JButton("Delect");
		buttonDel.setBounds(300, 480, 100, 20);
		buttonChange = new JButton("Change");
		buttonChange.setBounds(500, 480, 100, 20);
		buttonReset = new JButton("Query");
		buttonReset.setBounds(700, 480, 100, 20);

		//添加按钮
		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonChange);
		container.add(buttonReset);
		
		carAction = new CarAction();
		//初始化表格
		setTable();
		
		//设置按钮监听
		//添加按钮
		buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					carAction.addCarInformation(textFieldCarID, textFieldModel, textFieldColor, 
							textFieldManuFactory, textFieldFactoryDate, textFieldPrice);
					main.setVisible(false);
					new carView();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			
		});
		//删除按钮
		buttonDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					carAction.delCarInformation(Integer.parseInt(textFieldCarID.getText()));
					main.setVisible(false);
					new carView();
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
					carAction.changeCarInformation(textFieldCarID, textFieldModel, textFieldColor, 
							textFieldManuFactory, textFieldFactoryDate, textFieldPrice);
					main.setVisible(false);
					new carView();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
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
					new carView();
					JOptionPane.showMessageDialog(null, "数据更新成功","tips",JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "数据更新失败","tips",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
	}





	private void setTable() {
		// TODO Auto-generated method stub
		// 列名
		String[] columnNames = { "轿车编号", "型号", "颜色", "生产厂家", "出厂日期", "价格(元)" };
		try {
			CarAction carAction = new CarAction();
			Object[][] results = carAction.query(columnNames);

			table = new JTable(results, columnNames);
			scrollPane = new JScrollPane(table);
			// 设置表格
			new SetTable(scrollPane,table,columnNames,main);

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
//					String car_id, model, color, manufactory, factory_date, price;
//
//					int selRow = table.getSelectedRow();
//
//					car_id = table.getValueAt(selRow, 0).toString();
//					model = table.getValueAt(selRow, 1).toString();
//					color = table.getValueAt(selRow, 2).toString();
//					manufactory = table.getValueAt(selRow, 3).toString();
//					factory_date = table.getValueAt(selRow, 4).toString();
//					price = table.getValueAt(selRow, 5).toString();

//					textFieldCarID.setText(car_id);
//					textFieldModel.setText(model);
//					textFieldColor.setText(color);
//					textFieldManuFactory.setText(manufactory);
//					textFieldFactoryDate.setText(factory_date);
//					textFieldPrice.setText(price);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
