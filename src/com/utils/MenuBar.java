package com.utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.view.*;

public class MenuBar {
	JMenuBar menuBar;
	JMenuItem carInfomationItem;
	JMenuItem workerInformationItem;
	JMenuItem guestInformationItem;
	JMenuItem saleInformationItem;
	JMenuItem exitItem;

	public MenuBar(JFrame frame) {
		// TODO Auto-generated constructor stub
		menuBar = new JMenuBar();
		
		carInfomationItem = new JMenuItem("汽车信息");
		carInfomationItem.setBackground(Color.black);
		carInfomationItem.setForeground(Color.green);
		setCarInfomationItem(frame);
		workerInformationItem = new JMenuItem("员工信息");
		workerInformationItem.setBackground(Color.black);
		workerInformationItem.setForeground(Color.green);
		setWorkerInformationItem(frame);
		guestInformationItem = new JMenuItem("客户信息");
		guestInformationItem.setBackground(Color.black);
		guestInformationItem.setForeground(Color.green);
		setGuestInformationItem(frame);
		saleInformationItem = new JMenuItem("销售信息");
		saleInformationItem.setBackground(Color.black);
		saleInformationItem.setForeground(Color.green);
		setSaleInformationItem(frame);
		exitItem = new JMenuItem("退出系统");
		exitItem.setBackground(Color.black);
		exitItem.setForeground(Color.red);
		setExitItem(frame);
		menuBar.add(carInfomationItem);
		menuBar.add(workerInformationItem);
		menuBar.add(guestInformationItem);
		menuBar.add(saleInformationItem);
		menuBar.add(exitItem);
		
		frame.setJMenuBar(menuBar);

	}

	private void setCarInfomationItem(JFrame main) {
		// TODO Auto-generated method stub
		carInfomationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				main.setVisible(false);
				new carView();
			}
		});
	}
	private void setWorkerInformationItem(JFrame main) {
		// TODO Auto-generated method stub
		workerInformationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.setVisible(false);
				new workerView();
			}
		});
		
	}

	private void setGuestInformationItem(JFrame main) {
		// TODO Auto-generated method stub
		guestInformationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.setVisible(false);
				new guestView();
			}
		});
		
	}
	private void setSaleInformationItem(JFrame main) {
		// TODO Auto-generated method stub
		saleInformationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.setVisible(false);
				new saleView();
			}
		});
	}
	private void setExitItem(JFrame main) {
		// TODO Auto-generated method stub
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.setVisible(false);
				System.exit(0);
			}
		});
	}

}
