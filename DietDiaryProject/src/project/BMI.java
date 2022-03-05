package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BMI extends JFrame {

	DbConnect db = new DbConnect();
	Container cp;
	Font f1,f2;
	JLabel lbHeight,lbWeight;
	JTextField tHeight,tWeight;
	JButton btnBmi,btnDiet,btnCheck,btnSave,btnHistory;
	
	public BMI(String title) {
		super(title);
		cp=this.getContentPane();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(800, 100, 400, 600);
		cp.setBackground(new Color(204,219,226));//..bmi
		//cp.setBackground(new Color(226,204,208));//..diet
		//cp.setBackground(new Color(204,226,211));//..main
		
		this.initDesign();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
				
		//글꼴
		f1 = new Font("",Font.BOLD,30); //..btnBmi,btnDiet
		f2 = new Font("",Font.PLAIN,20); //JLabel
		
		//버튼생성..btnBmi,btnDiet
		btnBmi = new JButton("BMI");
		btnBmi.setFont(f1);
		btnBmi.setBackground(Color.white);
		btnBmi.setForeground(new Color(204,219,226));
		btnBmi.setBounds(30, 10, 140, 50);
		btnBmi.setBorderPainted(false); //jbutton border(외곽선) 없애기
		//btnBmi.setOpaque(false);
		this.add(btnBmi);
		
		btnDiet = new JButton("DIET");
		btnDiet.setFont(f1);
		btnDiet.setBackground(new Color(204,219,226));
		btnDiet.setForeground(Color.white);
		btnDiet.setBounds(210, 10, 140, 50);
		btnDiet.setBorderPainted(false);
		btnDiet.setOpaque(false);
		this.add(btnDiet);
		
		//판넬생성..board
		JPanel board = new JPanel();
		board.setBackground(Color.white);
		board.setBounds(0, 60, 400, 480);
		this.add(board);
		
		//라벨생성..lbHeight,lbWeight
		lbHeight = new JLabel("Height");
		lbHeight.setFont(f2);
		lbHeight.setBounds(10, 200, 100, 30);
		board.add(lbHeight);
						
	}
		
	public static void main(String[] args) {
		new BMI("Diet Diary");
	}

}
