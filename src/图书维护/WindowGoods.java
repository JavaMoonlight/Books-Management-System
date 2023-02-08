package 图书维护;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class WindowGoods extends JFrame implements ActionListener {
	File file = null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem login,show;
	InputArea inputMessage;												//录入界面
	WindowStack showMessage;											//显示界面
	JPanel pCenter;
	CardLayout card;
	public WindowGoods() {
		file = new File("书库.txt");									//存放链表的文件
		login = new JMenuItem("录入");
		show = new JMenuItem("显示");
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(login);
		fileMenu.add(show);
		bar.add(fileMenu);
		setJMenuBar(bar);
		login.addActionListener(this);
		show.addActionListener(this);
		inputMessage = new InputArea(file);								//创建录入界面
		showMessage = new WindowStack();								//创建显示界面
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("录入", inputMessage);
		pCenter.add("显示", showMessage);
		add(pCenter,BorderLayout.CENTER);
		card.show(pCenter, "录入");
		
		setTitle("添加物理书刊");
		setVisible(true);
		setBounds(500, 200, 500, 400);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			card.show(pCenter, "录入");
		}
		else if(e.getSource() == show) {
			try {
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				LinkedList<Goods> goodsList = (LinkedList<Goods>)oi.readObject();
				fi.close();
				oi.close();
				card.show(pCenter, "显示");
				showMessage.show(goodsList);
			}
			catch(Exception ee) {
				System.out.println(ee);
				JOptionPane.showMessageDialog(this, "没有信息","提醒对话框",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
