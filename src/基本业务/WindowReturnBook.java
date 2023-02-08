package ����ҵ��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ͼ��ά��.WindowStack;

public class WindowReturnBook extends JFrame implements ActionListener {
	JFrame frame;
	Box baseBox1,baseBox2,baseBox3,boxV1,boxV2,boxV3,boxV4;
	JComboBox<String> type;
	JTextField textOne,textTwo,textThree,textFour;
	JLabel labelOne,labelTwo,labelThree,labelFour;
	JButton buttonOne,buttonTwo;
	public WindowReturnBook() {
		init();
		setTitle("ͼ��黹");
		setLayout(new FlowLayout());
		setBounds(500, 200, 500, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	
	void init() {
		frame = new JFrame();
		textOne = new JTextField(18);
		textTwo = new JTextField(18);
		textThree = new JTextField(18);
		textFour = new JTextField(18);
		labelOne = new JLabel("�鿯��:");
		labelTwo = new JLabel("ISBN/ISSN[2]��:");
		labelThree = new JLabel("��������:");
		labelFour = new JLabel("�黹ʱ��:");
		type = new JComboBox<String>();
		buttonOne = new JButton("ȷ��");
		buttonTwo = new JButton("����");
		
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener((ActionEvent e)->{
										this.textOne.setText("");
										this.textTwo.setText("");
										this.textThree.setText("");
										this.textFour.setText("");
									});

		type.addItem("������");
		type.addItem("������");
		type.addItem("������");
		type.addItem("������");
		
		boxV1 = Box.createHorizontalBox();
		boxV1.add(type);
		boxV1.add(Box.createHorizontalStrut(10));
		boxV1.add(labelOne);
		boxV1.add(Box.createHorizontalStrut(8));
		boxV1.add(textOne);
		
		boxV2 = Box.createVerticalBox();
		boxV2.add(labelTwo);
		boxV2.add(Box.createVerticalStrut(40));
		boxV2.add(labelThree);
		boxV2.add(Box.createVerticalStrut(40));
		boxV2.add(labelFour);
		boxV2.add(Box.createVerticalStrut(40));
		
		boxV3 = Box.createVerticalBox();
		boxV3.add(textTwo);
		boxV3.add(Box.createVerticalStrut(40));
		boxV3.add(textThree);
		boxV3.add(Box.createVerticalStrut(40));
		boxV3.add(textFour);
		boxV3.add(Box.createVerticalStrut(40));
		
		boxV4 = Box.createHorizontalBox();
		boxV4.add(buttonOne);
		boxV4.add(Box.createHorizontalStrut(100));
		boxV4.add(buttonTwo);
		
		baseBox1 = Box.createHorizontalBox();
		baseBox1.add(boxV1);
		baseBox2 = Box.createHorizontalBox();
		baseBox2.add(boxV2);
		baseBox2.add(Box.createHorizontalStrut(35));
		baseBox2.add(boxV3);
		baseBox3 = Box.createHorizontalBox();
		baseBox3.add(boxV4);
		
		add(baseBox1);
		add(Box.createVerticalStrut(70));
		add(baseBox2);
		add(Box.createVerticalStrut(20));
		add(baseBox3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text1,text2,text3,text4;
		text1 = textOne.getText().toString().trim();
		text2 = textTwo.getText().toString().trim();
		text3 = textThree.getText().toString().trim();
		text4 = textFour.getText().toString().trim();
		
		if(text1.length()!=0 && text2.length()!=0 && text3.length()!=0 && text4.length()!=0) {
			JOptionPane.showMessageDialog(this, "�黹ͼ��ɹ�", "��ʾ�Ի���", JOptionPane.WARNING_MESSAGE);
			this.textOne.setText("");
			this.textTwo.setText("");
			this.textThree.setText("");
			this.textFour.setText("");
		}
		else {
			JOptionPane.showMessageDialog(this, "����ʧ�ܣ�����������", "����Ի���", JOptionPane.WARNING_MESSAGE);
		}
	}

}
