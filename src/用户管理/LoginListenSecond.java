package �û�����;

import ��ҳ��.WindowMain;
import ͼ��ά��.WindowGoods;
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
			JOptionPane.showMessageDialog(win, "�������û���������", "��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if(!inputPwd.matches(regex)) {
				JOptionPane.showMessageDialog(win,"�û����������зǷ��ַ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(win,"��½�ɹ�","��Ϣ�Ի���",JOptionPane.INFORMATION_MESSAGE);
				new WindowGoods();
			}
		}
	}
}
