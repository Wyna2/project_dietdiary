package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Diet extends JFrame implements ActionListener,ItemListener {

DbConnect db = new DbConnect();
	
	Container cp;
	Font f1,f2,f3,f4,f5;
	JLabel lbBreakfast,lbLunch,lbDinner,lbResult,lbKcal1,lbKcal2,lbKcal3;
	JComboBox<String> cBreakfast,cLunch,cDinner;
	JTextField tBreakfast,tLunch,tDinner,tKcal1,tKcal2,tKcal3;
	JButton btnBmi,btnDiet,btnSave,btnHistory;
		
	public Diet(String title) {
		super(title);
		cp=this.getContentPane();
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(800, 100, 400, 600);
		cp.setBackground(new Color(204,226,211));//..diet
		
		this.initDesign();
		setLocationRelativeTo(null);
		this.ComboBoxMenuList();
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
		//콤보박스1
		cBreakfast=new JComboBox<String>(); 
        cBreakfast.setBounds(180, 93, 140, 25);
        this.add(cBreakfast);
        cBreakfast.addItemListener(this);
		//테이블1
		tBreakfast = new JTextField();
		//tBreakfast.setHorizontalAlignment(JTextField.RIGHT); //텍스트 오른쪽정렬
		tBreakfast.setFont(f3);
		tBreakfast.setBounds(60, 120, 260, 30);
		tBreakfast.setBackground(new Color(204,226,211));
		tBreakfast.setForeground(Color.white);
		tBreakfast.setBorder(new LineBorder(Color.white,1));
		add(tBreakfast);		
		//kcal텍스트
		tKcal1 = new JTextField("1234");
		tKcal1.setFont(f3);
		tKcal1.setBounds(210, 140, 50, 50);
		tKcal1.setBorder(null);
		add(tKcal1);
		//라벨생성2..kcal 라벨
		lbKcal1 = new JLabel("Kcal");
		lbKcal1.setFont(f2);
		lbKcal1.setBounds(270, 140, 50, 50);
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
        cLunch.addItemListener(this);
				
		tLunch = new JTextField();
		tLunch.setFont(f3);
		tLunch.setBounds(60, 220, 260, 30);
		tLunch.setBackground(new Color(204,226,211));
		tLunch.setForeground(Color.white);
		tLunch.setBorder(new LineBorder(Color.white,1));
		add(tLunch);
				
		tKcal2 = new JTextField("1234");
		tKcal2.setFont(f3);
		tKcal2.setBounds(210, 240, 50, 50);
		tKcal2.setBorder(null);
		add(tKcal2);
					
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
		
		cDinner=new JComboBox<String>(); 
		cDinner.setBounds(180, 293, 140, 25);
        this.add(cDinner);
        cDinner.addItemListener(this);
						
		tDinner = new JTextField();
		//tBreakfast.setHorizontalAlignment(JTextField.RIGHT); //텍스트 오른쪽정렬
		tDinner.setFont(f3);
		tDinner.setBounds(60, 320, 260, 30);
		tDinner.setBackground(new Color(204,226,211));
		tDinner.setForeground(Color.white);
		tDinner.setBorder(new LineBorder(Color.white,1));
		add(tDinner);
						
		tKcal3 = new JTextField("1234");
		tKcal3.setFont(f3);
		tKcal3.setBounds(210, 340, 50, 50);
		tKcal3.setBorder(null);
		add(tKcal3);

		lbKcal3 = new JLabel("Kcal");
		lbKcal3.setFont(f2);
		lbKcal3.setBounds(270, 340, 50, 50);
		lbKcal3.setForeground(new Color(40,140,148));
		add(lbKcal3);
		
		
		//결과라벨
		lbResult = new JLabel("측정결과",JLabel.CENTER);
		
		if(tKcal1!=null && tKcal2!=null && tKcal3!=null) {
			int calBreakfast = Integer.parseInt(tKcal1.getText());
			int calLunch = Integer.parseInt(tKcal2.getText());
			int calDinner = Integer.parseInt(tKcal3.getText());
			int calResult = calBreakfast+calLunch+calDinner;
			lbResult.setText("<html>오늘 섭취한 kcal은<br>총 "+calResult+"Kcal 입니다.</html>");
		}
		
		lbResult.setFont(f5);
		lbResult.setBounds(60, 400, 260, 50);
		lbResult.setBorder(new LineBorder(new Color(66,163,118),5));
		this.add(lbResult);
		
		
		//판넬생성..board
		JPanel board = new JPanel();
		board.setBackground(Color.white);
		board.setBounds(0, 60, 400, 480);
		this.add(board);
						
	}
	
	
	public void insertData()
	{		
		int calBreakfast = Integer.parseInt(tKcal1.getText());
		int calLunch = Integer.parseInt(tKcal2.getText());
		int calDinner = Integer.parseInt(tKcal3.getText());
		int calResult = calBreakfast+calLunch+calDinner;
		
		//main id 불러오기!
		JTextField tfid=Project1.getTfid();
		String id = tfid.getText();
		
		String breakfast=tBreakfast.getText();
		String lunch=tLunch.getText();
		String dinner=tDinner.getText();
		String kcal = Integer.toString(calResult);;
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String date=simpleDate.format(new java.util.Date());

		String sql="insert into diethistory (seq,id,breakfast,lunch,dinner,kcal,writedate) values (seq_mehistory.nextval,?,?,?,?,?,?)";
		System.out.println(id+", "+breakfast+", "+lunch+", "+dinner+", "+kcal);
		
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?..6개 바인딩
			pstmt.setString(1, id);
			pstmt.setString(2, breakfast);
			pstmt.setString(3, lunch);
			pstmt.setString(4, dinner);
			pstmt.setString(5, kcal);
			pstmt.setString(6, date);
			pstmt.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}	
	
	
	
	public void ComboBoxMenuList()
	{
		Connection conn=db.getOracle();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			String sql="select name from cbdiet";
			rs=stmt.executeQuery(sql);
		
			while(rs.next()) {
			    cBreakfast.addItem(rs.getString("name"));
			    cLunch.addItem(rs.getString("name"));
			    cDinner.addItem(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	
	
	
	@Override
		public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		
		//main id 불러오기!
		JTextField tfid=Project1.getTfid();
		String id = tfid.getText();
		
			if(ob==btnBmi) {
				BMI bmi = new BMI("BMI");
				bmi.setVisible(true);
				this.setVisible(false);
			} else if(ob==btnSave) {
				insertData();
				JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
			} else if(ob==btnHistory) {
				Diet_History dhistory = new Diet_History("DIET HISTORY");
				dhistory.setVisible(true);
			}
				
		}
	
	@Override
		public void itemStateChanged(ItemEvent e) {
			String menu1=(String)cBreakfast.getSelectedItem();
			tBreakfast.setText(menu1);
			String menu2=(String)cLunch.getSelectedItem();
			tLunch.setText(menu2);
			String menu3=(String)cDinner.getSelectedItem();
			tDinner.setText(menu3);
			
		}
	
	public static void main(String[] args) {
		new Diet("DIET");
	}
	
}
