package ��ҳ��;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import ͼ��ά��.Goods;
import ͼ��ά��.WindowAddBorrowers;
import ͼ��ά��.WindowFeedBack;
import ͼ��ά��.WindowGoods;
import ͼ��ά��.WindowStack;
import ����ҵ��.WindowBooksBespeaking;
import ����ҵ��.WindowBorrowBooks;
import ����ҵ��.WindowReturnBook;

public class WindowMain extends JFrame implements ActionListener {
	JFrame frame;
	JPanel panel;
	JMenuBar menubar;
	JMenu menuOne,menuTwo,menuThree,menuFour,menu2One,menu3One,menu3Two;
	JMenuItem itemOne,itemTwo,itemThree,item2One,item2Two,item2Three,
			item3One,item3Two,item3Three,item3Four,item3Five,item3Six,
			item4One,item4Two;
	
	public WindowMain() {
		init();
		setTitle("Unified Library Application");
		setBounds(500, 200, 500, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		validate();
	}

	void init() {
		frame = new JFrame();
		panel = new JPanel();
		menubar = new JMenuBar();
		menuOne = new JMenu("Functions");
		menuTwo = new JMenu("Information");
		menuThree = new JMenu("Maintenance");
		menuFour = new JMenu("Help");
		menu2One = new JMenu("�����߹���");
		menu3One = new JMenu("�����鿯����");
		menu3Two = new JMenu("ͼ�����");
		itemOne = new JMenuItem("���鴦��");
		itemTwo = new JMenuItem("���鴦��");
		itemThree = new JMenuItem("Ԥ��ͼ��");
		item2One = new JMenuItem("��ӽ�����");
		item2Two = new JMenuItem("�޸Ľ�����");
		item2Three = new JMenuItem("ɾ��������");
		item3One = new JMenuItem("��������鿯");
		item3Two = new JMenuItem("�޸������鿯");
		item3Three = new JMenuItem("ɾ�������鿯");
		item3Four = new JMenuItem("�������");
		item3Five = new JMenuItem("�޸�����");
		item3Six = new JMenuItem("ɾ������");
		item4One = new JMenuItem("����ѯ");
		item4Two = new JMenuItem("����");

		itemOne.addActionListener((ActionEvent e)->{
										new WindowBorrowBooks();
									});
		itemTwo.addActionListener((ActionEvent e)->{
										new WindowReturnBook();
									});
		itemThree.addActionListener((ActionEvent e)->{
										new WindowBooksBespeaking();
									});
		item2One.addActionListener((ActionEvent e)->{
										new WindowAddBorrowers();
									});
		item3One.addActionListener((ActionEvent e)->{
										new WindowGoods();
									});
		item4One.addActionListener((ActionEvent e)->{
										try {
												new WindowStack();
											}
										catch(Exception ee) {
												JOptionPane.showMessageDialog(this, "û����Ϣ","���ѶԻ���",JOptionPane.WARNING_MESSAGE);
											}
									});
		item4Two.addActionListener((ActionEvent e)->{
										new WindowFeedBack();
									});
		addWindowListener(new WindowListener() {
												@Override
												public void windowOpened(WindowEvent e) {}
												@Override
												public void windowIconified(WindowEvent e) {}
												@Override
												public void windowDeiconified(WindowEvent e) {}
												@Override
												public void windowDeactivated(WindowEvent e) {}
												@Override
												public void windowClosing(WindowEvent e) {
													int n = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���","�˳�",JOptionPane.YES_NO_OPTION);
													if(n == JOptionPane.YES_OPTION) {
														System.exit(0);
													}
													else if(n == JOptionPane.NO_OPTION){}
												}
												@Override
												public void windowClosed(WindowEvent e) {}
												@Override
												public void windowActivated(WindowEvent e) {}
											});

		menuOne.add(itemOne);								//Functions�����Ӳ˵�
		menuOne.add(itemTwo);
		menuOne.add(itemThree);
		
		menuTwo.add(menu2One);								//Information�����Ӳ˵�
		menu2One.setMnemonic(KeyEvent.VK_A);
		menu2One.add(item2One);
		item2One.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		menu2One.add(item2Two);
		item2Two.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		menu2One.add(item2Three);
		item2Three.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		menuThree.add(menu3One);							//Information�����Ӳ˵�
		menu3One.setMnemonic(KeyEvent.VK_S);
		menu3One.add(item3One);
		item3One.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		menu3One.add(item3Two);
		item3Two.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		menu3One.add(item3Three);
		item3Three.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		menuThree.add(menu3Two);							//Maintenance�����Ӳ˵�
		menu3Two.setMnemonic(KeyEvent.VK_D);
		menu3Two.add(item3Four);
		item3Four.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menu3Two.add(item3Five);
		item3Five.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		menu3Two.add(item3Six);
		item3Six.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		
		menuFour.add(item4One);								//Help�����Ӳ˵�
		menuFour.add(item4Two);
		
		menubar.add(menuOne);
		menubar.add(menuTwo);
		menubar.add(menuThree);
		menubar.add(menuFour);
		
		add(panel);
		add(menubar, BorderLayout.NORTH);
	}
	public void actionPerformed(ActionEvent e) {}
}
