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

import com.controller.WorkerAction;
import com.utils.BackgroundImage;
import com.utils.FrameOption;
import com.utils.MenuBar;
import com.utils.SetTable;

public class workerView {
	JFrame main = new JFrame("Car Sale System");
	Container container = main.getContentPane();
	private JScrollPane scrollPane;
	JButton buttonAdd, buttonDel, buttonChange, buttonReset;
	private JTable table;
	JTextField	
	workerIDField,
	nameField,
	sexField,
	ageField,
	originField,
	educationField;
	private WorkerAction workerAction;
	public workerView() {
		main.setLayout(null);
		new BackgroundImage(main, container, "WorkerBackground.jpg");
		new FrameOption(main);
		new MenuBar(main);
		// 实例化标签和文本框
				JLabel workerIDJLabel = new JLabel("CarID");
				workerIDJLabel.setForeground(Color.green);
				workerIDJLabel.setBounds(75, 350, 100, 20);
				JTextField workerIDField= new JTextField();
				workerIDField.setBounds(175, 350, 100, 20);
				JLabel nameJLabel = new JLabel("Name");
				nameJLabel.setForeground(Color.green);
				nameJLabel.setBounds(350, 350, 100, 20);
				JTextField nameField = new JTextField();
				nameField.setBounds(450, 350, 100, 20);
				JLabel sexJLabel = new JLabel("Sex");
				sexJLabel.setForeground(Color.green);
				sexJLabel.setBounds(625, 350, 100, 20);
				JTextField sexField = new JTextField();
				sexField.setBounds(725, 350, 100, 20);
				JLabel ageJLabel = new JLabel("Age");
				ageJLabel.setForeground(Color.green);
				ageJLabel.setBounds(75, 400, 100, 20);
				JTextField ageField = new JTextField();
				ageField.setBounds(175, 400, 100, 20);
				JLabel originJLabel = new JLabel("Origin");
				originJLabel.setForeground(Color.green);
				originJLabel.setBounds(350, 400, 100, 20);
				JTextField originField = new JTextField();
				originField.setBounds(450, 400, 100, 20);
				JLabel educationJLabel  = new JLabel("Education");
				educationJLabel.setForeground(Color.green);
				educationJLabel.setBounds(625, 400, 100, 20);
				JTextField educationField = new JTextField();
				educationField.setBounds(725, 400, 100, 20);
				
				//修改输入字体颜色
				workerIDField.setForeground(new Color(19, 190, 196)); 
				nameField.setForeground(new Color(19, 190, 196)); 
				sexField.setForeground(new Color(19, 190, 196)); 
				ageField.setForeground(new Color(19, 190, 196)); 
				originField.setForeground(new Color(19, 190, 196)); 
				educationField.setForeground(new Color(19, 190, 196)); 
				
				//使文本框透明
				workerIDField.setOpaque(false);
				nameField.setOpaque(false);
				sexField.setOpaque(false);
				ageField.setOpaque(false);
				originField.setOpaque(false);
				educationField.setOpaque(false);
				
				container.add(workerIDJLabel);
				container.add(workerIDField);
				container.add(nameJLabel);
				container.add(nameField);
				container.add(sexJLabel);
				container.add(sexField);
				container.add(ageJLabel);
				container.add(ageField);
				container.add(originJLabel);
				container.add(originField);
				container.add(educationJLabel);
				container.add(educationField);

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
				
				workerAction = new WorkerAction();
				//初始化表格
				setTable();
				//添加按钮监听
				//添加按钮
				buttonAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							workerAction.addWorkerInformation(workerIDField, nameField, sexField,
									ageField, originField, educationField);
							main.setVisible(false);
							new workerView();
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				});
				//刪除按鈕
				buttonDel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							workerAction.delWorkerInformation(Integer.parseInt(workerIDField.getText()));
							main.setVisible(false);
							new workerView();
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				});
				//修改按鈕
				buttonChange.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							workerAction.changeWorkerinformation(nameField, sexField, ageField, 
									originField, educationField, table);
							main.setVisible(false);
							new workerView();
						} catch (Exception e2) {
							// TODO: handle exception
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
							new workerView();
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
		String[] columnNames = { "员工编号","姓名","性别","年龄","籍贯","学历" };
		try {
			WorkerAction workerAction = new WorkerAction();
			Object[][] results = workerAction.query(columnNames);

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
//					String worker_id,name,sex,age,origin,education;
//
//					int selRow = table.getSelectedRow();
//
//					worker_id = table.getValueAt(selRow, 0).toString();
//					name = table.getValueAt(selRow, 1).toString();
//					sex = table.getValueAt(selRow, 2).toString();
//					age = table.getValueAt(selRow, 3).toString();
//					origin = table.getValueAt(selRow, 4).toString();
//					education = table.getValueAt(selRow, 5).toString();
//
//					workerIDField.setText(worker_id);
//					nameField.setText(name);
//					sexField.setText(sex);
//					ageField.setText(age);
//					originField.setText(origin);
//					educationField.setText(education);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
