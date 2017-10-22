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
		frame.setTitle("모놀리움 계산기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
		frame.setSize(500, 400);
		
		Container c = frame.getContentPane();
		c.setBackground(Color.WHITE);
		
		JButton b1 = new JButton("결과");
		b1.setBounds(400, 320, 75, 35);
		frame.add(b1);
		frame.setLayout(null);

		JTextArea result = new JTextArea("");
		frame.add(result);
		result.setBounds(10, 200, 300, 50);
		result.setEnabled(false);
		result.setDisabledTextColor(Color.BLACK);
		
		JTextArea logo = new JTextArea("제작 : 카시야스 - 발군");
		frame.add(logo);
		logo.setBounds(360, 300, 200, 20);
		logo.setEnabled(false);
		logo.setDisabledTextColor(Color.BLACK);
		
		JTextArea text1 = new JTextArea("어둠의 근원");
		frame.add(text1);
		text1.setBounds(10, 12, 80, 20);
		text1.setToolTipText("옆 칸에 현재 소지하고있는 어둠의 근원 갯수를 입력해주세요.");
		text1.setEnabled(false);
		text1.setDisabledTextColor(Color.BLUE);
		
		JTextField jfield = new JTextField("어둠의 근원 갯수를 입력해주세요.");
		jfield.setBounds(100, 10, 200, 27);
		jfield.setToolTipText("정수만 입력가능합니다.");
		
		jfield.addKeyListener(getKeyListener(jfield, ButtonEnum.DARK_BUTTON.getID()));
		jfield.addMouseListener(getMouseEvent(jfield, ButtonEnum.DARK_BUTTON.getID()));
		
		
		JTextArea text2 = new JTextArea("모놀리움");
		frame.add(text2);
		text2.setBounds(10, 52, 80, 20);
		text2.setToolTipText("옆 칸에 현재 소지하고있는 모놀리움 갯수를 입력해주세요.");
		text2.setEnabled(false);
		text2.setDisabledTextColor(Color.PINK);
		
		JTextField jfield1 = new JTextField("모놀리움 갯수를 입력해주세요.");
		jfield1.setBounds(100, 50, 200, 27);
		jfield1.setToolTipText("정수만 입력가능합니다.");
		
		jfield1.addKeyListener(getKeyListener(jfield1, ButtonEnum.MONOL_BUTTON.getID()));
		jfield1.addMouseListener(getMouseEvent(jfield1, ButtonEnum.MONOL_BUTTON.getID()));
		
		JTextArea text3 = new JTextArea("필요 모놀리움");
		frame.add(text3);
		text3.setBounds(10, 92, 80, 20);
		text3.setToolTipText("옆 칸에 필요 모놀리움 갯수를 입력해주세요.");
		text3.setEnabled(false);
		text3.setDisabledTextColor(Color.BLACK);
		
		JTextField jfield2 = new JTextField("필요 모놀리움 갯수를 입력해주세요.");
		jfield2.setBounds(100, 90, 200, 27);
		jfield2.setToolTipText("정수만 입력가능합니다.");
		
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
					resultText.setText("필요 모놀리움 갯수는 1000개 이상 입력할 수 없습니다!");
					resultText.setDisabledTextColor(Color.RED);
					resultText.setToolTipText(null);
					return;
				}
				
				if(dark < 0 || monol < 0 || result < 0)
				{
					resultText.setText("0 이상의 숫자만 입력가능합니다!");
					resultText.setDisabledTextColor(Color.RED);
					resultText.setToolTipText(null);
					return;
					
				}else{
					
					resultText.setText(getResultText(result));
					resultText.setDisabledTextColor(Color.BLACK);
					resultText.setToolTipText("최소(모놀리움 10개, 어둠의 근원 6개) 최대(모놀리움 3개, 어둠의 근원 4개) 값으로 산출한 횟수입니다.");
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
		
		buffer = "목표 모놀리움 갯수까지 남은 레이드 횟수는\n최소 " + minRaidCount(dark, monol, result) + "회 최대 " + maxRaidCount(dark, monol, result) + "회 까지 입니다.";
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
