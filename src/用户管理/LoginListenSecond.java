package 用户管理;

import 主页面.WindowMain;
import 图书维护.WindowGoods;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginListenSecond implements ActionListener {
	WindowLoginInterface win;
	JTextField inputNumberOne;
	JPasswordField inputNumberTwo;
	String inputUserid,inputPwd;
	static String regex = "[^[A-Za-z0-9]+]";
	
	public void setWindowLogin(WindowLoginInterface win) {
		this.win = win;
	}
	
	public LoginListenSecond(JTextField inputNumberOne,JPasswordField inputNumberTwo) {
		this.inputNumberOne = inputNumberOne;
		this.inputNumberTwo = inputNumberTwo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		inputUserid = inputNumberOne.getText().toString().trim();
		inputPwd = inputNumberTwo.getText().toString().trim();
		regex = "[A-Za-z0-9]+";
		
		if (inputUserid.length()==0 || inputPwd.length()==0) {
			JOptionPane.showMessageDialog(win, "请输入用户名或密码", "消息对话框", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if(!inputPwd.matches(regex)) {
				JOptionPane.showMessageDialog(win,"用户名或密码有非法字符","消息对话框",JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(win,"登陆成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
				new WindowGoods();
			}
		}
	}
}
