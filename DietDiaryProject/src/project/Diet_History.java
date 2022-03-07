package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Diet_History extends JFrame {


	DbConnect db = new DbConnect();
	
	Container cp;
	DefaultTableModel model;
	Font f1,f2,f3,f4,f5;
	JLabel lbTitle1,lbTitle2;
	JTable table,table1;
	JButton btnExit;
	
	public Diet_History(String title) {
		super(title);
		cp=this.getContentPane();
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(800, 100, 520, 610);
		cp.setBackground(new Color(204,226,211));//..diet
		
		this.initDesign();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initDesign() {
		this.setLayout(null);
		
		//글꼴
		f1 = new Font("",Font.BOLD,40); //lblTitle
		f2 = new Font("",Font.PLAIN,23); //
		f3 = new Font("",Font.ITALIC,20); //
		f4 = new Font("",Font.BOLD,20); //
		f5 = new Font("",Font.PLAIN,15); //
		
		
		//lblTitle
		lbTitle1 = new JLabel("DIET History");
		lbTitle1.setFont(f1);
		lbTitle1.setBackground(Color.white);
		lbTitle1.setForeground(new Color(204,226,211));
		lbTitle1.setBounds(30, 30, 300, 50);
		this.add(lbTitle1);
		//lblTitle 그림자
		lbTitle2 = new JLabel("DIET History");
		lbTitle2.setFont(f1);
		lbTitle2.setBackground(Color.white);
		lbTitle2.setForeground(new Color(200,226,211));
		lbTitle2.setBounds(32, 28, 300, 50);
		this.add(lbTitle2);
		
		
		//판넬생성..board1(배경),board2(table)		
		JPanel board2 = new JPanel();
		board2.setBackground(Color.white);
		board2.setBounds(10, 100, 480, 440);
		this.add(board2);
		
		JPanel board1 = new JPanel();
		board1.setBackground(Color.white);
		board1.setBounds(0, 20, 520, 530);
		this.add(board1);

		
		//테이블생성		
		String[] title= {"Num.","Breakfast","Lunch","Dinner","TotalKcal","Date"};
		
		//main id 불러오기!
		JTextField tfid=Project1.tfid;
		String id = tfid.getText();
		
		model=new DefaultTableModel(title, 0);
		table=new JTable(model);
		this.add("Center", new JScrollPane(table));
		
		model.setRowCount(0); //테이블 초기화 선언
		
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select seq,breakfast,lunch,dinner,kcal,to_char(writedate,'yyyy-MM-dd') writedate from diethistory where id='"+id+"' order by seq";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("seq"));
				data.add(rs.getString("breakfast"));
				data.add(rs.getString("lunch"));
				data.add(rs.getString("dinner"));
				data.add(rs.getString("kcal"));
				data.add(rs.getString("writedate"));;
				
				//테이블에 추가
				model.addRow(data);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		table.setRowHeight(23); //테이블 칼럼 높이 정하기
		board2.add(new JScrollPane(table));
		
	}
	
	public static void main(String[] args) {
		new Diet_History("Diet History");

	}

}
