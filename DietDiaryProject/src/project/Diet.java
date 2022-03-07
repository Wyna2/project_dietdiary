package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Diet extends JFrame implements ActionListener {

DbConnect db = new DbConnect();
	
	Container cp;
	Font f1,f2,f3,f4,f5;
	JLabel lbBreakfast,lbLunch,lbDinner,lbResult,lbKcal1,lbKcal2,lbKcal3;
	JComboBox<String> cBreakfast,cLunch,cDinner;
	JTextField tBreakfast,tbLunch,tDinner,tKcal1,tKcal2,tKcal3;
	JButton btnBmi,btnDiet,btnSave,btnHistory;
	
	public Diet(String title) {
		super(title);
		cp=this.getContentPane();
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(800, 100, 400, 600);
		cp.setBackground(new Color(204,226,211));//..diet
		
		this.initDesign();
		setLocationRelativeTo(null);
		this.setVisible(true);		
	}
	
	public void initDesign()
	{
		this.setLayout(null);
			
		//글꼴
		f1 = new Font("",Font.BOLD,30); //btnBmi,btnDiet
		f2 = new Font("",Font.ITALIC,23); //lbBreakfast,lbLunch,lbDinner
		f3 = new Font("",Font.BOLD,20); //tBreakfast,tbLunch,tDinner,tKcal1,tKcal2,tKcal3
		f4 = new Font("",Font.BOLD,20); //btnSave,btnHistory
		f5 = new Font("",Font.PLAIN,15); //lbResult
		
		//버튼생성..btnBmi,btnDiet
		btnBmi = new JButton("BMI");
		btnBmi.setFont(f1);
		btnBmi.setBackground(new Color(204,226,211));
		btnBmi.setForeground(Color.white);
		btnBmi.setBounds(30, 10, 140, 50);
		btnBmi.setBorderPainted(false); //jbutton border(외곽선) 없애기
		btnBmi.setOpaque(false);
		this.add(btnBmi);
		btnBmi.addActionListener(this);
		
		btnDiet = new JButton("DIET");
		btnDiet.setFont(f1);
		btnDiet.setBackground(Color.white);
		btnDiet.setForeground(new Color(204,226,211));
		btnDiet.setBounds(210, 10, 140, 50);
		btnDiet.setBorderPainted(false);
		this.add(btnDiet);
		
		//액션버튼생성..btnSave,btnHistory		
		btnSave = new JButton("Save");
		btnSave.setFont(f4);
		btnSave.setBackground(new Color(79,180,110));
		btnSave.setForeground(Color.white);
		btnSave.setBounds(60, 470, 120, 40);
		btnSave.setBorderPainted(false);
		this.add(btnSave);
		btnSave.addActionListener(this);
		
		btnHistory = new JButton("History");
		btnHistory.setFont(f4);
		btnHistory.setBackground(new Color(79,180,110));
		btnHistory.setForeground(Color.white);
		btnHistory.setBounds(200, 470, 120, 40);
		btnHistory.setBorderPainted(false);
		this.add(btnHistory);
		btnHistory.addActionListener(this);

		
		//라벨생성1..lbBreakfast
		lbBreakfast = new JLabel("Breakfast");
		lbBreakfast.setFont(f2);
		lbBreakfast.setBounds(60, 80, 140, 50);
		add(lbBreakfast);
		
		cBreakfast=new JComboBox<String>(); 
        cBreakfast.setBounds(180, 93, 140, 25);
        this.add(cBreakfast);
		
		tBreakfast = new JTextField();
		//tBreakfast.setHorizontalAlignment(JTextField.RIGHT); //텍스트 오른쪽정렬
		tBreakfast.setFont(f3);
		tBreakfast.setBounds(60, 120, 260, 30);
		tBreakfast.setBackground(new Color(204,226,211));
		tBreakfast.setForeground(Color.white);
		tBreakfast.setBorder(new LineBorder(Color.white,1));
		add(tBreakfast);		
		
		lbKcal1 = new JLabel("1,234");
		lbKcal1.setFont(f3);
		lbKcal1.setBounds(210, 140, 50, 50);
		add(lbKcal1);
				
		lbKcal1 = new JLabel("Kcal");
		lbKcal1.setFont(f2);
		lbKcal1.setBounds(270, 140, 50, 50);
		lbKcal1.setForeground(new Color(40,140,148));
		add(lbKcal1);
		
		lbKcal1 = new JLabel("Kcal");
		lbKcal1.setFont(f2);
		lbKcal1.setBounds(270, 340, 50, 50);
		lbKcal1.setForeground(new Color(40,140,148));
		add(lbKcal1);
		
		
		//라벨생성2..lbLunch
		lbLunch = new JLabel("Lunch");
		lbLunch.setFont(f2);
		lbLunch.setBounds(60, 180, 140, 50);
		add(lbLunch);
		
		cLunch=new JComboBox<String>(); 
		cLunch.setBounds(180, 193, 140, 25);
        this.add(cLunch);
				
		tbLunch = new JTextField();
		tbLunch.setFont(f3);
		tbLunch.setBounds(60, 220, 260, 30);
		tbLunch.setBackground(new Color(204,226,211));
		tbLunch.setForeground(Color.white);
		tbLunch.setBorder(new LineBorder(Color.white,1));
		add(tbLunch);
				
		lbKcal2 = new JLabel("1,234");
		lbKcal2.setFont(f3);
		lbKcal2.setBounds(210, 240, 50, 50);
		add(lbKcal2);
					
		lbKcal2 = new JLabel("Kcal");
		lbKcal2.setFont(f2);
		lbKcal2.setBounds(270, 240, 50, 50);
		lbKcal2.setForeground(new Color(40,140,148));
		add(lbKcal2);
		
		
		//라벨생성3..Dinner
		lbDinner = new JLabel("Dinner");
		lbDinner.setFont(f2);
		lbDinner.setBounds(60, 280, 140, 50);
		add(lbDinner);
		
		cLunch=new JComboBox<String>(); 
		cLunch.setBounds(180, 293, 140, 25);
        this.add(cLunch);
						
		tDinner = new JTextField();
		//tBreakfast.setHorizontalAlignment(JTextField.RIGHT); //텍스트 오른쪽정렬
		tDinner.setFont(f3);
		tDinner.setBounds(60, 320, 260, 30);
		tDinner.setBackground(new Color(204,226,211));
		tDinner.setForeground(Color.white);
		tDinner.setBorder(new LineBorder(Color.white,1));
		add(tDinner);
						
		lbKcal3 = new JLabel("1,234");
		lbKcal3.setFont(f3);
		lbKcal3.setBounds(210, 340, 50, 50);
		add(lbKcal3);
										
		
		//결과라벨
		lbResult = new JLabel("측정결과",JLabel.CENTER);
		lbResult.setFont(f3);
		lbResult.setBounds(60, 400, 260, 50);
		lbResult.setBorder(new LineBorder(new Color(66,163,118),5));
		this.add(lbResult);
		
		
		//판넬생성..board
		JPanel board = new JPanel();
		board.setBackground(Color.white);
		board.setBounds(0, 60, 400, 480);
		this.add(board);
						
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		
		if(ob==btnBmi) {
			BMI bmi = new BMI("name님의 BMI");
			bmi.setVisible(true);
		} 
			
		}

	
	public static void main(String[] args) {
		new Diet("Name님의 DIET");
	}

}
