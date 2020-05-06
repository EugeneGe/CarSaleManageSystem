package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import com.controller.UserAction;
import com.view.MainFrame;

public class Login {

	public void loginGUi(char[] passwordStrings) {
		JFrame login = new JFrame();
		login.setTitle("Welcome login system");
		login.setSize(500, 400);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setLayout(new GridLayout(3, 1));

		JLabel jl_username = new JLabel("UserName: ", JLabel.CENTER);
		JTextField JTextFieldUser = new JTextField(JTextField.LEFT);
		JLabel jl_password = new JLabel("Password: ", JLabel.CENTER);
		JPasswordField JPasswordField = new JPasswordField(SwingConstants.LEFT);

		jl_username.setFont(new Font("comic sans MS", Font.BOLD, 20));
		JTextFieldUser.setFont(new Font("Segoe Print", Font.BOLD, 20));
		jl_password.setFont(new Font("comic sans MS", Font.BOLD, 20));
		JPasswordField.setFont(new Font("Segoe Print", Font.BOLD, 20));

		JButton jb_login = new JButton("Login");
		JButton jb_exit = new JButton("Exit");

		jb_login.setFont(new Font("Segoe Print", Font.BOLD, 20));
		jb_exit.setFont(new Font("Segoe Print", Font.BOLD, 20));

		ImageIcon bgimg = new ImageIcon("res/Welcome.jpg");
		JLabel imgLabel = new JLabel(bgimg);
		login.add(imgLabel);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(2, 2, 5, 10));
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

		jp1.add(imgLabel);
		jp2.add(jl_username);
		jp2.add(JTextFieldUser);
		jp2.add(jl_password);
		jp2.add(JPasswordField);
		jp3.add(jb_login);
		jp3.add(jb_exit);

		login.add(jp1);
		login.add(jp2);
		login.add(jp3);
		login.setVisible(true);
		// 设置键盘监听事件
		jb_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=JTextFieldUser.getText();
				String passwd = new String(JPasswordField.getPassword());

				com.controller.UserAction userAction = new UserAction();
				String result = userAction.login(username,passwd);

					if (result.equals("1")) {
						login.setVisible(false);
						new MainFrame().MainGUI();
					}else if(result.equals("2")) {
						JOptionPane.showMessageDialog(null,"用户名或密码不能为空","错误"
								,JOptionPane.PLAIN_MESSAGE);
					} else if(result.equals("3")) {
						JOptionPane.showMessageDialog(null,"用户名或密码错误","错误"
								,JOptionPane.PLAIN_MESSAGE);		
					}
			}
		});
		// 退出按钮鼠标监听
		jb_exit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
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

			}
		});
		
	}
}
