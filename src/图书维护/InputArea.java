package 图书维护;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InputArea extends JPanel implements ActionListener {
	File f = null;														//存放链表的文件
	Box baseBox,boxV1,boxV2;
	JTextField name,type,writer,ISBN,price;								//为Goods对象提供的视图
	JButton button;														//控制器
	LinkedList<Goods> goodsList;										//存放Goods对象的链表
	public InputArea(File f) {
		this.f = f;
		goodsList = new LinkedList<Goods>();
		name = new JTextField(12);
		type = new JTextField(12);
		writer = new JTextField(12);
		ISBN = new JTextField(12);
		price = new JTextField(12);
		button = new JButton("录入");
		button.addActionListener(this);
		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("输入名称:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("输入作者:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("输入类型:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("输入ISBN/ISSN[2]号:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("输入标价:"));
		boxV1.add(Box.createVerticalStrut(25));
		
		boxV2 = Box.createVerticalBox();
		boxV1.add(Box.createVerticalStrut(20));
		boxV2.add(name);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(writer);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(type);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(ISBN);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(price);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(button);
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(15));
		baseBox.add(boxV2);
		add(baseBox);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(f.exists()) {												//是否存在指定条件的记录.如果后面的SQL语句有选择到资料,则exists()函数返回true,否则返回false
			try {
				FileInputStream fi = new FileInputStream(f);			//创建字节输入流
				ObjectInputStream oi = new ObjectInputStream(fi);		//创建对象输入流
				goodsList = (LinkedList<Goods>)oi.readObject();			//Goods为泛型
				fi.close();
				oi.close();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setWriter(writer.getText());
				goods.setType(type.getText());
				goods.setISBN(ISBN.getText());
				goods.setPrice(price.getText());
				goodsList.add(goods);
				FileOutputStream fo = new FileOutputStream(f);			//创建字节输出流
				ObjectOutputStream out = new ObjectOutputStream(fo);	//创建对象输出流
				out.writeObject(goodsList);								//使用writeObject()方法将goodsList写入一个文件
				out.close();
				this.name.setText("");
				this.writer.setText("");
				this.type.setText("");
				this.ISBN.setText("");
				this.price.setText("");
			}
			catch(Exception ee) {}
		}
		else {
			try {
				f.createNewFile();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setWriter(writer.getText());
				goods.setType(type.getText());
				goods.setISBN(ISBN.getText());
				goods.setPrice(price.getText());
				goodsList.add(goods);
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream out = new ObjectOutputStream(fo);
				out.writeObject(goodsList);
				out.close();
			}
			catch(Exception ee) {}
		}
	}

}

