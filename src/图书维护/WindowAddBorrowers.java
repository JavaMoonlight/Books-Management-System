package ͼ��ά��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowAddBorrowers extends JFrame implements ActionListener {
	JFrame frame;
	JPanel panel;
	Box baseBox,boxV1,boxV2;
	JButton buttonOne,buttonTwo;
	
	public WindowAddBorrowers() {
		init();
		setTitle("��ӽ�����");
		setBounds(600, 250, 330, 220);
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	void init(){
		frame = new JFrame();
		panel = new JPanel();
		buttonOne = new JButton("ȷ��");
		buttonTwo = new JButton("ȡ��");

		buttonOne.addActionListener(this);
		buttonTwo.addActionListener((ActionEvent e)->{
										new WindowAddBorrowers();
									});
		
		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("����:"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����:"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("ͼ�鿨��:"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����:"));
		
		boxV2 = Box.createVerticalBox();
		boxV2.add(new JTextField(18));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JPasswordField(18));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(18));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(18));
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		
		panel.add(baseBox);
		add(panel);
		add(buttonOne);
		add(buttonTwo);
	}
	public void actionPerformed(ActionEvent e) {
	}
}
