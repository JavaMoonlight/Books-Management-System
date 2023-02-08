package 图书维护;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.Iterator;
import java.util.LinkedList;

public class WindowStack extends JPanel {
	JTable table;
	Object book[][],name[] = {"书名","作者","类型","ISBN号","标价"}; 
	public WindowStack() {
		setLayout(new BorderLayout());
		table = new JTable();
		add(table);
	}
	public void show(LinkedList<Goods> goodsList) {
		remove(table);													//remove()方法移除某个对象或者某个位置的item
		int length = goodsList.size();
		book = new Object[length][5];
		table = new JTable(book, name);
		add(new JScrollPane(table),BorderLayout.CENTER);
		Iterator<Goods> iter = goodsList.iterator();					//创建迭代器
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
		table.repaint();												//重绘组件table
	}
}
