package com.utils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SetScrollPane {

	public SetScrollPane(JScrollPane scrollPane,JTable table) {
		// TODO Auto-generated method stub
		// 将JScrollPane设置为透明
		scrollPane.setOpaque(false);
		//将viewport设置为透明
		scrollPane.getViewport().setOpaque(false);
		//转载table
		scrollPane.setViewportView(table);
		//设置头部透明
		scrollPane.setColumnHeaderView(table.getTableHeader());
		scrollPane.getColumnHeader().setOpaque(false);
		// 设置滚动条位置
		scrollPane.setBounds(50, 50, 800, 250);
	}
}
