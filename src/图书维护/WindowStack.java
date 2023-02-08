package ͼ��ά��;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.Iterator;
import java.util.LinkedList;

public class WindowStack extends JPanel {
	JTable table;
	Object book[][],name[] = {"����","����","����","ISBN��","���"}; 
	public WindowStack() {
		setLayout(new BorderLayout());
		table = new JTable();
		add(table);
	}
	public void show(LinkedList<Goods> goodsList) {
		remove(table);													//remove()�����Ƴ�ĳ���������ĳ��λ�õ�item
		int length = goodsList.size();
		book = new Object[length][5];
		table = new JTable(book, name);
		add(new JScrollPane(table),BorderLayout.CENTER);
		Iterator<Goods> iter = goodsList.iterator();					//����������
		int i = 0;
		while(iter.hasNext()) {
			Goods goods = iter.next();
			book[i][0] = goods.getName();
			book[i][1] = goods.getWriter();
			book[i][2] = goods.getType();
			book[i][3] = goods.getISBN();
			book[i][4] = goods.getPrice();
			i++;
		}
		table.repaint();												//�ػ����table
	}
}
