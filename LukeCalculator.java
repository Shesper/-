package com.casillas.balgoon;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LukeCalculator {

	private static boolean first[] = {false, false, false};
	
	public static JTextField TArea1;
	public static JTextField TArea2;
	public static JTextField TArea3;
	public static JTextArea resultText;
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.setTitle("���� ����");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
		frame.setSize(500, 400);
		
		Container c = frame.getContentPane();
		c.setBackground(Color.WHITE);
		
		JButton b1 = new JButton("���");
		b1.setBounds(400, 320, 75, 35);
		frame.add(b1);
		frame.setLayout(null);

		JTextArea result = new JTextArea("");
		frame.add(result);
		result.setBounds(10, 200, 300, 50);
		result.setEnabled(false);
		result.setDisabledTextColor(Color.BLACK);
		
		JTextArea logo = new JTextArea("���� : ī�þ߽� - �߱�");
		frame.add(logo);
		logo.setBounds(360, 300, 200, 20);
		logo.setEnabled(false);
		logo.setDisabledTextColor(Color.BLACK);
		
		JTextArea text1 = new JTextArea("����� �ٿ�");
		frame.add(text1);
		text1.setBounds(10, 12, 80, 20);
		text1.setToolTipText("�� ĭ�� ���� �����ϰ��ִ� ����� �ٿ� ������ �Է����ּ���.");
		text1.setEnabled(false);
		text1.setDisabledTextColor(Color.BLUE);
		
		JTextField jfield = new JTextField("����� �ٿ� ������ �Է����ּ���.");
		jfield.setBounds(100, 10, 200, 27);
		jfield.setToolTipText("������ �Է°����մϴ�.");
		
		jfield.addKeyListener(getKeyListener(jfield, ButtonEnum.DARK_BUTTON.getID()));
		jfield.addMouseListener(getMouseEvent(jfield, ButtonEnum.DARK_BUTTON.getID()));
		
		
		JTextArea text2 = new JTextArea("����");
		frame.add(text2);
		text2.setBounds(10, 52, 80, 20);
		text2.setToolTipText("�� ĭ�� ���� �����ϰ��ִ� ���� ������ �Է����ּ���.");
		text2.setEnabled(false);
		text2.setDisabledTextColor(Color.PINK);
		
		JTextField jfield1 = new JTextField("���� ������ �Է����ּ���.");
		jfield1.setBounds(100, 50, 200, 27);
		jfield1.setToolTipText("������ �Է°����մϴ�.");
		
		jfield1.addKeyListener(getKeyListener(jfield1, ButtonEnum.MONOL_BUTTON.getID()));
		jfield1.addMouseListener(getMouseEvent(jfield1, ButtonEnum.MONOL_BUTTON.getID()));
		
		JTextArea text3 = new JTextArea("�ʿ� ����");
		frame.add(text3);
		text3.setBounds(10, 92, 80, 20);
		text3.setToolTipText("�� ĭ�� �ʿ� ���� ������ �Է����ּ���.");
		text3.setEnabled(false);
		text3.setDisabledTextColor(Color.BLACK);
		
		JTextField jfield2 = new JTextField("�ʿ� ���� ������ �Է����ּ���.");
		jfield2.setBounds(100, 90, 200, 27);
		jfield2.setToolTipText("������ �Է°����մϴ�.");
		
		jfield2.addKeyListener(getKeyListener(jfield2, ButtonEnum.RESULT_MONOL_BUTTON.getID()));
		jfield2.addMouseListener(getMouseEvent(jfield2, ButtonEnum.RESULT_MONOL_BUTTON.getID()));
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				int dark = getDark();
				int monol = getMonol();
				int result = getResultMonol();
				
				if(result > 1000)
				{
					resultText.setText("�ʿ� ���� ������ 1000�� �̻� �Է��� �� �����ϴ�!");
					resultText.setDisabledTextColor(Color.RED);
					resultText.setToolTipText(null);
					return;
				}
				
				if(dark < 0 || monol < 0 || result < 0)
				{
					resultText.setText("0 �̻��� ���ڸ� �Է°����մϴ�!");
					resultText.setDisabledTextColor(Color.RED);
					resultText.setToolTipText(null);
					return;
					
				}else{
					
					resultText.setText(getResultText(result));
					resultText.setDisabledTextColor(Color.BLACK);
					resultText.setToolTipText("�ּ�(���� 10��, ����� �ٿ� 6��) �ִ�(���� 3��, ����� �ٿ� 4��) ������ ������ Ƚ���Դϴ�.");
				}
			}

		});
		
		
		frame.add(jfield);
		frame.add(jfield1);
		frame.add(jfield2);	
		
		frame.setVisible(true);
		
		TArea1 = jfield;
		TArea2 = jfield1;
		TArea3 = jfield2;
		resultText = result;
	}
	
	public static KeyListener getKeyListener(JTextField jfield, int a)
	{
		KeyListener e = new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {

				if(!first[a])
				{
					jfield.setText("");
					first[a] = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		return e;
	}
	
	public static MouseListener getMouseEvent(JTextField jfield, int a)
	{
		MouseListener e = new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!first[a]) {
					
					jfield.setText("");
					first[a] = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		return e;
	}
	
	public static int getDark()
	{
		int amt = -1;
		try {
			
			amt = Integer.parseInt(TArea1.getText());
			
		}catch(Exception e){
			
			return -1;
		}
		return amt;
	}
	
	public static int getMonol()
	{
		int amt = -1;
		try {
			
			amt = Integer.parseInt(TArea2.getText());
			
		}catch(Exception e){
			
			return -1;
		}
		return amt;
	}
	
	public static int getResultMonol()
	{
		int amt = -1;
		try {
			
			amt = Integer.parseInt(TArea3.getText());
			
		}catch(Exception e){
			
			return -1;
		}
		return amt;
	}
	
	public static String getResultText(int result)
	{
		String buffer = "";
		int monol = getMonol();
		int dark = getDark();
		
		buffer = "��ǥ ���� �������� ���� ���̵� Ƚ����\n�ּ� " + minRaidCount(dark, monol, result) + "ȸ �ִ� " + maxRaidCount(dark, monol, result) + "ȸ ���� �Դϴ�.";
		return buffer;
	}
	
	public static int maxRaidCount(int dark, int monol, int result)
	{
		int raid = 0;
		
		int remaindark = (dark % 5);
		int count = (result - (monol + (dark / 5)));

		
		if(count <= 0)
		{
			return 0;
		}
		
		do
		{
			raid++;
			
			count -= 3;
			remaindark += 4;
			
			if((remaindark / 5) >= 1)
			{
				count -= (remaindark / 5);
				remaindark -= (remaindark / 5) * 5;
			}
			
		}while(count >= 0);
		
		return raid;
	}
	
	public static int minRaidCount(int dark, int monol, int result)
	{
		int raid = 0;
		
		int remaindark = (dark % 5);

		int count = (result - (monol + (dark / 5)));
		
		if(count <= 0)
		{
			return 0;
		}
		
		do
		{
			raid++;
			
			count -= 10;
			remaindark += 6;
			
			if((remaindark / 5) >= 1)
			{
				count -= (remaindark / 5);
				remaindark -= (remaindark / 5) * 5;
			}
			
		}while(count >= 0);
		
		return raid;
	}
}
