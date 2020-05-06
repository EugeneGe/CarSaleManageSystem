package com.utils;

import javax.swing.JFrame;

public class FrameOption {
	public FrameOption(JFrame main) {
		// TODO Auto-generated constructor stub
		main.setSize(900, 600);
		main.setLocationRelativeTo(null);
		main.setResizable(false);// 禁止修改窗口大小
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);

	}
}
