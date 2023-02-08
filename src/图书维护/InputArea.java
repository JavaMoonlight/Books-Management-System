package ͼ��ά��;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InputArea extends JPanel implements ActionListener {
	File f = null;														//���������ļ�
	Box baseBox,boxV1,boxV2;
	JTextField name,type,writer,ISBN,price;								//ΪGoods�����ṩ����ͼ
	JButton button;														//������
	LinkedList<Goods> goodsList;										//���Goods���������
	public InputArea(File f) {
		this.f = f;
		goodsList = new LinkedList<Goods>();
		name = new JTextField(12);
		type = new JTextField(12);
		writer = new JTextField(12);
		ISBN = new JTextField(12);
		price = new JTextField(12);
		button = new JButton("¼��");
		button.addActionListener(this);
		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("��������:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("��������:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("��������:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("����ISBN/ISSN[2]��:"));
		boxV1.add(Box.createVerticalStrut(25));
		boxV1.add(new JLabel("������:"));
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
		if(f.exists()) {												//�Ƿ����ָ�������ļ�¼.��������SQL�����ѡ������,��exists()��������true,���򷵻�false
			try {
				FileInputStream fi = new FileInputStream(f);			//�����ֽ�������
				ObjectInputStream oi = new ObjectInputStream(fi);		//��������������
				goodsList = (LinkedList<Goods>)oi.readObject();			//GoodsΪ����
				fi.close();
				oi.close();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setWriter(writer.getText());
				goods.setType(type.getText());
				goods.setISBN(ISBN.getText());
				goods.setPrice(price.getText());
				goodsList.add(goods);
				FileOutputStream fo = new FileOutputStream(f);			//�����ֽ������
				ObjectOutputStream out = new ObjectOutputStream(fo);	//�������������
				out.writeObject(goodsList);								//ʹ��writeObject()������goodsListд��һ���ļ�
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

