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

import com.controller.SaleAction;
import com.utils.BackgroundImage;
import com.utils.FrameOption;
import com.utils.MenuBar;
import com.utils.SetTable;

public class saleView {
	JFrame main = new JFrame("Car Sale System");
	Container container = main.getContentPane();
	private JScrollPane scrollPane;
	private JButton buttonReset;
	private JButton buttonChange;
	private JButton buttonDel;
	private JButton buttonAdd;
	private JTable table;
	private SaleAction saleAction;

	public saleView() {
		// TODO Auto-generated constructor stub
		main.setLayout(null);
		new BackgroundImage(main, container, "SaleBackground.jpg");
		new FrameOption(main);
		new MenuBar(main);

		// 实例化标签和文本框
		JLabel saleDateJLabel = new JLabel("SaleDate");
		saleDateJLabel.setForeground(Color.green);
		saleDateJLabel.setBounds(75, 350, 100, 20);
		JTextField saleDateField = new JTextField();
		saleDateField.setBounds(175, 350, 100, 20);
		JLabel carTypeJLabel = new JLabel("CarType");
		carTypeJLabel.setForeground(Color.green);
		carTypeJLabel.setBounds(350, 350, 100, 20);
		JTextField carTypeField = new JTextField();
		carTypeField.setBounds(450, 350, 100, 20);
		JLabel colorJLabel = new JLabel("Color");
		colorJLabel.setForeground(Color.green);
		colorJLabel.setBounds(625, 350, 100, 20);
		JTextField colorField = new JTextField();
		colorField.setBounds(725, 350, 100, 20);
		JLabel numberJLabel = new JLabel("Number");
		numberJLabel.setForeground(Color.green);
		numberJLabel.setBounds(150, 400, 125, 20);
		JTextField numberField = new JTextField();
		numberField.setBounds(225, 400, 175, 20);
		JLabel handlerJLabel = new JLabel("Handler");
		handlerJLabel.setForeground(Color.green);
		handlerJLabel.setBounds(500, 400, 125, 20);
		JTextField handlerField = new JTextField();
		handlerField.setBounds(625, 400, 150, 20);

		// 修改输入文字颜色
		saleDateField.setForeground(new Color(12, 239, 34));
		carTypeField.setForeground(new Color(12, 239, 34));
		colorField.setForeground(new Color(12, 239, 34));
		numberField.setForeground(new Color(12, 239, 34));
		handlerField.setForeground(new Color(12, 239, 34));

		// 使文本框透明
		saleDateField.setOpaque(false);
		carTypeField.setOpaque(false);
		colorField.setOpaque(false);
		numberField.setOpaque(false);
		handlerField.setOpaque(false);

		container.add(saleDateJLabel);
		container.add(saleDateField);
		container.add(carTypeJLabel);
		container.add(carTypeField);
		container.add(colorJLabel);
		container.add(colorField);
		container.add(numberJLabel);
		container.add(numberField);
		container.add(handlerJLabel);
		container.add(handlerField);

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

		saleAction = new SaleAction();
		// 初始化表格
		setTable();
		// 添加按钮监听
		// 添加按钮
		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					saleAction.addSaleInformation(saleDateField, carTypeField, colorField, numberField, handlerField);
					main.setVisible(false);
					new saleView();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		// 删除按钮
		buttonDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.printf(saleDateField.getText()+handlerField.getText());
				try {
					saleAction.delSaleInformation(saleDateField.getText());
					main.setVisible(false);
					new saleView();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		// 修改按钮
		buttonChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					saleAction.changeSaleInformation(saleDateField, carTypeField, colorField, numberField,
							handlerField);
					main.setVisible(false);
					new saleView();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		// 查询按钮
		buttonReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					setTable();
					main.setVisible(false);
					new saleView();
					JOptionPane.showMessageDialog(null, "数据更新成功", "tips", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "数据更新失败", "tips", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}

	private void setTable() {
		// TODO Auto-generated method stub
		String[] columnNames = { "销售日期", "轿车类型", "颜色", "数量", "经手人" };
		try {
			SaleAction saleAction = new SaleAction();
			Object[][] results = saleAction.query(columnNames);

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
//					String sale_date, car_type, color, number, handler;
//
//					int selRow = table.getSelectedRow();
//
//					sale_date = table.getValueAt(selRow, 0).toString();
//					car_type = table.getValueAt(selRow, 1).toString();
//					color = table.getValueAt(selRow, 2).toString();
//					number = table.getValueAt(selRow, 3).toString();
//					handler = table.getValueAt(selRow, 4).toString();
//
//					saleDateField.setText(sale_date);
//					carTypeField.setText(car_type);
//					colorField.setText(color);
//					numberField.setText(number);
//					handlerField.setText(handler);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
