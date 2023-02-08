package 用户管理;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import 图书维护.WindowGoods;
import 基本业务.WindowBorrowBooks;

public class WindowLoginInterface extends JFrame {
	Box baseBox,boxV1,boxV2;
	JPanel panel;
	Font font;
	JTextField inputNumberOne;
	JPasswordField inputNumberTwo;
	JLabel labelOne,labelTwo,navigation,background;
	JButton buttonOne,buttonTwo;
	LoginListen login;
	LoginListenSecond loginSecond;
	public WindowLoginInterface() {
		init();
		setLayout(new FlowLayout());
		setBounds(600, 250, 300, 200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		validate();
	}
	void init() {
		panel = new JPanel();
		inputNumberOne = new JTextField(22);
		inputNumberTwo = new JPasswordField(22);
		labelOne = new JLabel("用户名:");
		labelTwo = new JLabel("密    码:");
		navigation = new JLabel("用户登录界面");
		buttonOne = new JButton("登录");
		buttonTwo = new JButton("管理员登录");
		login = new LoginListen(inputNumberOne, inputNumberTwo);
		loginSecond = new LoginListenSecond(inputNumberOne, inputNumberTwo);
		login.setWindowLogin(this);
		loginSecond.setWindowLogin(this);
				
		buttonOne.addActionListener(login);
		buttonTwo.addActionListener(loginSecond);
		addWindowListener(new WindowListener() {
												@Override
												public void windowOpened(WindowEvent e) {}
												@Override
												public void windowIconified(WindowEvent e) {}
												@Override
												public void windowDeiconified(WindowEvent e) {}
												@Override
												public void windowDeactivated(WindowEvent e) {}
												@Override
												public void windowClosing(WindowEvent e) {
													int n = JOptionPane.showConfirmDialog(null,"确定要退出吗？","退出",JOptionPane.YES_NO_OPTION);
													if(n == JOptionPane.YES_OPTION) {
														System.exit(0);
													}
												}
												@Override
												public void windowClosed(WindowEvent e) {}
												@Override
												public void windowActivated(WindowEvent e) {}
											});
		panel.setBackground(Color.yellow);
		font = new Font("宋体",Font.BOLD,15);
		navigation.setFont(font);
		panel.add(navigation);
		panel.setPreferredSize(new Dimension(300, 30));
		
		boxV1 = Box.createVerticalBox();
		boxV1.add(labelOne);
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(labelTwo);
		boxV1.add(Box.createVerticalStrut(8));
		boxV2 = Box.createVerticalBox();
		boxV2.add(inputNumberOne);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(inputNumberTwo);
		boxV2.add(Box.createVerticalStrut(8));
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		
		add(panel);
		add(baseBox);
		add(buttonOne);
		add(buttonTwo);
	}
}
