package com.view;

import java.awt.Container;

import javax.swing.*;
import com.utils.*;

public class MainFrame {

	JFrame main = new JFrame("Car Sale System");
	Container container = main.getContentPane();

	public void MainGUI() {
		new FrameOption(main);
		new BackgroundImage(main, container, "MainBackground.jpg");
		new MenuBar(main);
	}
}
