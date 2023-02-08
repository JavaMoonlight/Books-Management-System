package ͼ��ά��;

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
	InputArea inputMessage;												//¼�����
	WindowStack showMessage;											//��ʾ����
	JPanel pCenter;
	CardLayout card;
	public WindowGoods() {
		file = new File("���.txt");									//���������ļ�
		login = new JMenuItem("¼��");
		show = new JMenuItem("��ʾ");
		bar = new JMenuBar();
		fileMenu = new JMenu("�˵�ѡ��");
		fileMenu.add(login);
		fileMenu.add(show);
		bar.add(fileMenu);
		setJMenuBar(bar);
		login.addActionListener(this);
		show.addActionListener(this);
		inputMessage = new InputArea(file);								//����¼�����
		showMessage = new WindowStack();								//������ʾ����
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("¼��", inputMessage);
		pCenter.add("��ʾ", showMessage);
		add(pCenter,BorderLayout.CENTER);
		card.show(pCenter, "¼��");
		
		setTitle("��������鿯");
		setVisible(true);
		setBounds(500, 200, 500, 400);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			card.show(pCenter, "¼��");
		}
		else if(e.getSource() == show) {
			try {
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				LinkedList<Goods> goodsList = (LinkedList<Goods>)oi.readObject();
				fi.close();
				oi.close();
				card.show(pCenter, "��ʾ");
				showMessage.show(goodsList);
			}
			catch(Exception ee) {
				System.out.println(ee);
				JOptionPane.showMessageDialog(this, "û����Ϣ","���ѶԻ���",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
