package 图书维护;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WindowFeedBack extends JFrame implements ActionListener {
	Box baseBox,box1,box2;
	JTextArea textShow;
	JButton buttonOne,buttonTwo;
	public WindowFeedBack() {
		init();
		setLayout(new FlowLayout());
		setTitle("反馈");
		setBounds(500, 200, 500, 300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	void init() {
		textShow = new JTextArea(10,50);
		textShow.setLineWrap(true);
		buttonOne = new JButton("确定");
		buttonTwo = new JButton("重置");
		
		box1 = Box.createHorizontalBox();
		box1.add(textShow);
		box2 = Box.createHorizontalBox();
		box2.add(buttonOne);
		box2.add(Box.createHorizontalStrut(30));
		box2.add(buttonTwo);
		baseBox = Box.createVerticalBox();
		baseBox.add(box1);
		baseBox.add(Box.createVerticalStrut(25));
		baseBox.add(box2);
		
		buttonTwo.addActionListener((ActionEvent e)->{
										textShow.setText("");
									});
		
		add(baseBox);
	}
	public void actionPerformed(ActionEvent e) {}
}
