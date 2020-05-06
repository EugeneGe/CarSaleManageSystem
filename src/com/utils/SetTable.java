package com.utils;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SetTable {

	public SetTable(JScrollPane scrollPane,JTable table,String[] columnNames,JFrame main) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// 自动调整列表状态
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		//设置表格数据颜色
		table.setForeground(Color.green);
		table.setBackground(Color.black);
//		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
//		renderer.setOpaque(false);//render单元格的属性
//		//遍历表格中所有列，将其渲染器设置为renderer
//		table.setDefaultRenderer(Object.class, renderer);
//		for(int i = 0 ; i < columnNames.length ; i ++)
//		{
//			table.getColumn(columnNames[i]).setCellRenderer(renderer);
//		}

		table.setOpaque(false);//将table设置为透明
		scrollPane.setOpaque(false);//将scrollPane根面板设置为透明
		scrollPane.getViewport().setOpaque(false);//将scrollPane的viewport设置为透明
		// 设置滚动条位置
		scrollPane.setBounds(50, 50, 800, 250);
		main.add(scrollPane);
	}
}
